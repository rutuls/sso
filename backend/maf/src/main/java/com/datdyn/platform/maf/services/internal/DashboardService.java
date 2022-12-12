package com.datdyn.platform.maf.services.internal;

import com.datdyn.platform.maf.dtos.APIResponse.PolicyStatusDetailsResponse;
import com.datdyn.platform.maf.entities.Flow;
import com.datdyn.platform.maf.repositories.FlowRepository;
import com.datdyn.platform.sxsdk.api.SXConnector;
import com.datdyn.platform.sxsdk.configs.SXConfig;
import com.datdyn.platform.sxsdk.models.GetAllPolicyResponse;
import com.datdyn.platform.sxsdk.models.Policy;
import com.datdyn.platform.sxsdk.service.SXRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;

@ApplicationScoped
public class DashboardService {

    @Inject
    SXConnector sxConnector;

    @RestClient
    SXRestClient sxClient;

    @Inject
    SXConfig sxConfig;

    @Inject
    FlowRepository flowRepository;

    public PolicyStatusDetailsResponse getAllPolicyStatusDetails() {
        GetAllPolicyResponse response = sxClient.getAllPolicies(1, sxConfig.pagesize());
        if (!Objects.isNull(response)) {
            PolicyStatusDetailsResponse policyStatusDetailsResponse = new PolicyStatusDetailsResponse();
            long totalNumberOfRecords = response.getTotalCount();
            int totalNumberOfPagesToFetch = (int) Math.ceil(totalNumberOfRecords / sxConfig.pagesize()) + 1;
            if (totalNumberOfRecords > 0 && totalNumberOfPagesToFetch >= 1) {
                List<Map<String, Long>> policyCountByStatusMapList = new ArrayList<Map<String, Long>>();
                for (int i = 1; i <= totalNumberOfPagesToFetch; i++) {
                    Map<String, Long> policyCountByStatusMap = new TreeMap<String, Long>();
                    GetAllPolicyResponse policyDetailsResponse = sxClient.getAllPolicies(i, sxConfig.pagesize());
                    if (!Objects.isNull(policyDetailsResponse)) {
                        policyCountByStatusMap = policyDetailsResponse
                                .getPolicyList()
                                .stream()
                                .collect(groupingBy(Policy::getLastRunStatus, TreeMap::new, Collectors.counting()));
                    }
                    policyCountByStatusMapList.add(policyCountByStatusMap);
                }
                Map<String, Long> finalPolicyCountByLastRunStatus = policyCountByStatusMapList
                        .stream()
                        .flatMap(map -> map.entrySet().stream())
                        .collect(groupingBy(Map.Entry::getKey, summingLong(Map.Entry::getValue)));
                policyStatusDetailsResponse.setPolicyCountByLastRunStatus(finalPolicyCountByLastRunStatus);
                return policyStatusDetailsResponse;
            }
        }
        return new PolicyStatusDetailsResponse();
    }

    public Map<String, Long> getAllProjectDetails() {
        Map<String, Long> projectDetails = flowRepository
                .listAll()
                .stream()
                .collect(Collectors.groupingBy(Flow::getProjectName, Collectors.counting()));
        return projectDetails;
    }

    public Map<String, Long> getAllOwnerDetails() {
        Map<String, Long> ownerDetails = flowRepository
                .listAll()
                .stream()
                .collect(Collectors.groupingBy(Flow::getCreatedBy, Collectors.counting()));
        return ownerDetails;
    }
}
