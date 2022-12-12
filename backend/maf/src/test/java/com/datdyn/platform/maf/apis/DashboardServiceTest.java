package com.datdyn.platform.maf.apis;

import com.datdyn.platform.maf.dtos.APIResponse.PolicyStatusDetailsResponse;
import com.datdyn.platform.maf.services.internal.DashboardService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DashboardServiceTest {

    @Inject
    DashboardService dashboardService;

    @Test
    @Order(1)
    public void getAllPolicyStatusDetails_Pass() {
        PolicyStatusDetailsResponse policyStatusDetailsResponse;
        policyStatusDetailsResponse = dashboardService.getAllPolicyStatusDetails();
        if(!Objects.isNull(policyStatusDetailsResponse) && !Objects.isNull(policyStatusDetailsResponse.getPolicyCountByLastRunStatus())){
            if(policyStatusDetailsResponse.getPolicyCountByLastRunStatus().containsKey("Completed")){
                Assertions.assertTrue(policyStatusDetailsResponse.getPolicyCountByLastRunStatus().get("Completed").intValue() >= 0);
            }
            if(policyStatusDetailsResponse.getPolicyCountByLastRunStatus().containsKey("Failed")){
                Assertions.assertTrue(policyStatusDetailsResponse.getPolicyCountByLastRunStatus().get("Failed").intValue() >= 0);
            }
            if(policyStatusDetailsResponse.getPolicyCountByLastRunStatus().containsKey("NeverRun")){
                Assertions.assertTrue(policyStatusDetailsResponse.getPolicyCountByLastRunStatus().get("NeverRun").intValue() >= 0);
            }
            if(policyStatusDetailsResponse.getPolicyCountByLastRunStatus().containsKey("Cancelled")){
                Assertions.assertTrue(policyStatusDetailsResponse.getPolicyCountByLastRunStatus().get("Cancelled").intValue() >= 0);
            }
        }
    }

    @Test
    @Order(2)
    public void getAllProjectDetails_Pass() {
        Map<String, Long> projectDetails = dashboardService.getAllProjectDetails();
        Iterator<java.util.Map.Entry<String, Long>> iterator = projectDetails.entrySet().iterator();
        if (projectDetails.size() > 0) {
            while (iterator.hasNext()) {
                java.util.Map.Entry<String, Long> entry = iterator.next();
                Assertions.assertTrue(entry.getValue() > 0);
            }
        }
    }

    @Test
    @Order(3)
    public void getAllOwnerDetails_Pass() {
        Map<String, Long> ownerDetails = dashboardService.getAllOwnerDetails();
        Iterator<java.util.Map.Entry<String, Long>> iterator = ownerDetails.entrySet().iterator();
        if (ownerDetails.size() > 0) {
            while (iterator.hasNext()) {
                java.util.Map.Entry<String, Long> entry = iterator.next();
                Assertions.assertTrue(entry.getValue() > 0);
            }
        }
    }
}
