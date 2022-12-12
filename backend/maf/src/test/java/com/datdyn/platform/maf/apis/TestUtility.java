package com.datdyn.platform.maf.apis;

import java.util.ArrayList;
import java.util.TreeSet;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import com.datdyn.platform.maf.clients.SXService;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.Actions;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.Batch1.Batch1;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.Batch2.Batch2;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.CopyDataOnce.CopyDataOnce;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.CopyDataUntil.CopyDataUntil;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.PreventUserConnection.PreventUserConnection;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.SourceSizing.SourceSizing;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.StopSharingResource.StopSharingResource;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.UpdateAutomountOrDFS.UpdateAutomountOrDFS;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.VerifyReplication.VerifyReplication;
import com.datdyn.platform.maf.dtos.FlowDTOs.MigrationFlow.ActionExecution;
import com.datdyn.platform.maf.dtos.FlowDTOs.MigrationSchedule.MigrationSchedule;
import com.datdyn.platform.maf.dtos.Responses.AuthResponseDto;
import com.datdyn.platform.maf.dtos.Responses.PoliciesResponseDto;
import com.datdyn.platform.maf.dtos.Responses.SXResponseDto;

@ApplicationScoped
public class TestUtility {

    @ConfigProperty(name = "test-data.domainName")
    String domainName;

    @ConfigProperty(name = "test-data.username")
    String username;

    @ConfigProperty(name = "test-data.password")
    String password;

    @ConfigProperty(name = "test-data.source")
    String sourceLocation;

    @ConfigProperty(name = "test-data.destination")
    String destinationLocation;

    @Inject
    @RestClient
    SXService sxService;

    TreeSet<Integer> policyIdSet = new TreeSet<>();

    public String getAuthToken() {
        AuthResponseDto authResponse = sxService.loginSX("UserName=" + domainName + "%5C" + username + "&Password=" +
                password + "&grant_type=password");
        return authResponse.getAccessToken();
    }

    public Integer getRandomId(String token) {
        SXResponseDto sxResponseDto = sxService.getAllPolicies(token);
        int totalCount = sxResponseDto.getTotalCount();
        for (int i = 0; i < totalCount; i++) {
            policyIdSet.add(sxResponseDto.getPolicies().get(i).getId());
        }
        int requiredPolicyId = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!policyIdSet.contains(i)) {
                requiredPolicyId = i;
                break;
            }
        }
        policyIdSet.add(requiredPolicyId);
        return requiredPolicyId;
    }

    public PoliciesResponseDto getStorageXRequest(String token) {
        SXResponseDto sxResponseDto = sxService.getAllPolicies(token);
        int policyCount = sxService.getAllPolicies(token).getPolicies().size();
        TreeSet<String> policyNameSet = new TreeSet<>();
        for (int i = 0; i < policyCount; i++) {
            policyNameSet.add(sxResponseDto.getPolicies().get(i).getName());
        }
        int requiredPolicyId = 0;
        while (true) {
            if (!policyNameSet.contains("Policy" + requiredPolicyId)) {
                break;
            } else {
                requiredPolicyId++;
            }
        }

        PoliciesResponseDto policy = new PoliciesResponseDto();
        policy.setId(requiredPolicyId);
        policy.setName("Policy" + requiredPolicyId);
        policy.setDescription("Policy description");
        policy.setSource(sourceLocation);
        policy.setDestination(destinationLocation);
        policy.setCreatedBy("Policy" + requiredPolicyId);
        policy.setModifiedBy("Policy" + requiredPolicyId);
        policy.setMigrationSchedule(new MigrationSchedule());

        Batch1 batch1 = new Batch1();
        batch1.setEnableBatch(false);
        Batch2 batch2 = new Batch2();
        batch2.setEnableBatch(false);
        SourceSizing sourceSizing = new SourceSizing();
        sourceSizing.setEnableSourceSizing(true);
        sourceSizing.setSource(sourceLocation);
        CopyDataOnce copyDataOnce = new CopyDataOnce();
        copyDataOnce.setEnableCopyDataOnce(false);
        CopyDataUntil copyDataUntil = new CopyDataUntil();
        copyDataUntil.setEnableCopyDataUntil(false);
        UpdateAutomountOrDFS updateAutomountOrDFS = new UpdateAutomountOrDFS();
        updateAutomountOrDFS.setEnableUpdateAutomountOrDFS(false);
        PreventUserConnection preventUserConnection = new PreventUserConnection();
        preventUserConnection.setEnablePreventUserConnection(false);
        VerifyReplication verifyReplication = new VerifyReplication();
        verifyReplication.setEnableVerifyReplication(false);
        StopSharingResource stopSharingResource = new StopSharingResource();
        stopSharingResource.setEnableStopSharingResource(false);
        policy.setActions(new Actions(batch1, sourceSizing, copyDataOnce, copyDataUntil, updateAutomountOrDFS,
                preventUserConnection, verifyReplication, stopSharingResource, batch2));

        ArrayList<ActionExecution> actionExecutions = new ArrayList<>();
        actionExecutions.add(new ActionExecution(1, "SourceSizing"));
        policy.setMigrationFlow(actionExecutions);

        return policy;
    }

    public PoliciesResponseDto getUpdatedStorageXData(PoliciesResponseDto storageXRequestData) {
        storageXRequestData.setSource(destinationLocation);
        storageXRequestData.setDestination(sourceLocation);
        storageXRequestData.getActions().getSourceSizing().setSource(destinationLocation);
        return storageXRequestData;
    }
}
