package com.datdyn.platform.maf.apis;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import com.datdyn.platform.maf.clients.SXService;
import com.datdyn.platform.maf.dtos.Responses.PoliciesResponseDto;
import com.datdyn.platform.maf.dtos.Responses.PolicyRunStatusResponseDto;
import com.datdyn.platform.maf.dtos.Responses.SXResponseDto;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SXServiceTest {

    @Inject
    TestUtility testUtility;

    @Inject
    @RestClient
    SXService sxService;

    String token;

    ArrayList<Integer> policyIdCreatedList = new ArrayList<>();

    @BeforeAll
    void setUp() {
        token = "bearer " + testUtility.getAuthToken();
    }

    @AfterAll
    void afterAll() {
        sxService.deletePolicies(policyIdCreatedList.toArray(), token);
    }

    @Test
    @Order(1)
    public void createPolicyTest_Pass() {
        PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policy = sxService.createPolicy(storageXRequestData, token);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), Response.ok(policy).build().getStatus());
        Assertions.assertTrue(policy.getName().equals(storageXRequestData.getName()));
        Assertions.assertTrue(policy.getSource().equals(storageXRequestData.getSource()));
        Assertions.assertTrue(policy.getDestination().equals(storageXRequestData.getDestination()));
        Assertions.assertTrue(!policy.getSource().isBlank());
        for (int i = 0; i < policy.getMigrationFlow().size(); i++) {
            String actionType = storageXRequestData.getMigrationFlow().get(i).getAction();
            Assertions.assertTrue(policy.getActions().toString().contains(actionType));
        }
        policyIdCreatedList.add(policy.getId());
    }

    @Test
    @Order(2)
    public void createPolicyTest_400BadRequest() {
        PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
        storageXRequestData.setActions(null);
        try {
            sxService.createPolicy(storageXRequestData, token);
        } catch (Exception exception) {
            
            Assertions.assertTrue(exception.getMessage().contains("status code 400"));
        }
    }

    @Test
    @Order(3)
    public void updatePolicyTest_Pass() {
        PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policyCreated = sxService.createPolicy(storageXRequestData, token);
        PoliciesResponseDto storageXUpdatedRequestData = testUtility.getUpdatedStorageXData(storageXRequestData);
        PoliciesResponseDto policyUpdated = sxService.updatePolicy(storageXUpdatedRequestData, policyCreated.getId(),
                token);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), Response.ok(policyUpdated).build().getStatus());
        Assertions.assertTrue(policyUpdated.getName().equals(storageXUpdatedRequestData.getName()));
        Assertions.assertTrue(policyUpdated.getSource().equals(storageXUpdatedRequestData.getSource()));
        Assertions.assertTrue(policyUpdated.getDestination().equals(storageXUpdatedRequestData.getDestination()));
        Assertions.assertTrue(!policyUpdated.getSource().isBlank());
        for (int i = 0; i < policyUpdated.getMigrationFlow().size(); i++) {
            String actionType = storageXUpdatedRequestData.getMigrationFlow().get(i).getAction();
            Assertions.assertTrue(policyUpdated.getActions().toString().contains(actionType));
        }
        policyIdCreatedList.add(policyUpdated.getId());
    }

    @Test
    @Order(4)
    public void updatePolicyTest_Fail() {
        PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policyCreated = sxService.createPolicy(storageXRequestData, token);
        storageXRequestData.setActions(null);
        try {
            sxService.updatePolicy(storageXRequestData, policyCreated.getId(), token);
        } catch (Exception exception) {
            Assertions.assertTrue(exception.getMessage().contains("Bad Request, status code 400"));
        }
        policyIdCreatedList.add(policyCreated.getId());
    }

    @Test
    @Order(7)
    public void getPolicyByIdTest_Pass() {
        PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policyCreated = sxService.createPolicy(storageXRequestData, token);
        PoliciesResponseDto responsePolicyObject = sxService.getPolicyById(policyCreated.getId(), token);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(),
                Response.ok(responsePolicyObject).build().getStatus());
        Assertions.assertTrue(!responsePolicyObject.getSource().isBlank());
        policyIdCreatedList.add(policyCreated.getId());
    }

    @Test
    @Order(8)
    public void getPolicyByIdTest_Fail() {
        try {
            sxService.getPolicyById(testUtility.getRandomId(token), token);
        } catch (Exception exception) {
            Assertions.assertTrue(exception.getMessage().contains("status code 500"));
        }
    }

    @Test
    @Order(9)
    public void getAllPoliciesTest() {
        SXResponseDto sXResponseDto = sxService.getAllPolicies(token);
        Assertions.assertEquals("api/v5/nonlinear/migration/policies", sXResponseDto.getLink());
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), Response.ok(sXResponseDto).build().getStatus());
        Assertions.assertTrue(sXResponseDto.getPolicies().size() >= 0);
    }

    @Test
    @Order(5)
    public void triggerPolicyRunTest_Pass() {
        PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policy = sxService.createPolicy(storageXRequestData, token);
        String response = sxService.triggerPolicyRun(policy.getId(), token);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), Response.ok(response).build().getStatus());
        Assertions.assertTrue(response.contains("Action(s) set to run successfully."));
        policyIdCreatedList.add(policy.getId());
    }

    @Test
    @Order(6)
    public void triggerPolicyRunTest_Fail() {
        try {
            sxService.triggerPolicyRun(testUtility.getRandomId(token), token);
        } catch (Exception exception) {
            Assertions.assertTrue(exception.getMessage().contains("status code 400"));
        }
    }

    @Test
    @Order(10)
    public void getAllRunStatusesOfPolicyTest_Pass() {
        PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policyCreated = sxService.createPolicy(storageXRequestData, token);
        sxService.triggerPolicyRun(policyCreated.getId(), token);
        PolicyRunStatusResponseDto policyRunStatus = sxService.getAllRunStatusesOfPolicy(policyCreated.getId(),
                token);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), Response.ok(policyRunStatus).build().getStatus());
        Assertions.assertTrue(!policyRunStatus.getSource().isBlank());
        if (policyRunStatus.getRuns().size() > 0) {
            Assertions.assertTrue(policyRunStatus.getRuns().get(0).getManifestID() >= 0);
        }
        policyIdCreatedList.add(policyCreated.getId());
    }

    @Test
    @Order(11)
    public void getAllRunStatusesOfPolicyTest_Fail() {
        try {
            sxService.getAllRunStatusesOfPolicy(testUtility.getRandomId(token), token);
        } catch (Exception exception) {
            Assertions.assertTrue(exception.getMessage().contains("status code 400"));
        }
    }

    // This particular test is being commented for now. Rohit will look into it
    // @Test
    // @Order(12)
    // public void getLastRunManifestOfPolicyTest_Pass() {
    //     PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
    //     PoliciesResponseDto policyCreated = sxService.createPolicy(storageXRequestData, token);
    //     sxService.triggerPolicyRun(policyCreated.getId(), token);
    //     PolicyRunManifestResponseDto policyLastRunManifest = sxService.getLastRunManifestOfPolicy(policyCreated.getId(),
    //             token);
    //     Assertions.assertEquals(Response.Status.OK.getStatusCode(),
    //             Response.ok(policyLastRunManifest).build().getStatus());
    //     Assertions.assertEquals("api/v5/nonlinear/migration/policies/" + policyCreated.getId() + "/runs/manifest",
    //             policyLastRunManifest.getLink());
    //     for (int i = 0; i < policyLastRunManifest.getMigrationFlow().size(); i++) {
    //         String actionType = storageXRequestData.getMigrationFlow().get(i).getAction();
    //         Assertions.assertTrue(
    //                 policyLastRunManifest.getManifest().toString().toLowerCase().contains(actionType.toLowerCase()));
    //     }
    //     policyIdCreatedList.add(policyCreated.getId());
    // }

    @Test
    @Order(13)
    public void getLastRunManifestOfPolicyTest_Fail() {
        try {
            sxService.getLastRunManifestOfPolicy(testUtility.getRandomId(token), token);
        } catch (Exception exception) {
            Assertions.assertTrue(exception.getMessage().contains("status code 400"));
        }
    }

    // @Test
    // @Order(14)
    // public void getSpecificRunManifestOfPolicyTest_Pass() {
    //     PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
    //     PoliciesResponseDto policyCreated = sxService.createPolicy(storageXRequestData, token);
    //     sxService.triggerPolicyRun(policyCreated.getId(), token);
    //     PolicyRunManifestResponseDto policyLastRunManifest = sxService.getLastRunManifestOfPolicy(policyCreated.getId(),
    //             token);
    //     PolicyRunManifestResponseDto policySpecificRunManifest = sxService.getSpecificRunManifestOfPolicy(
    //             policyCreated.getId(),
    //             policyLastRunManifest.getManifestID(), token);
    //     Assertions.assertEquals(Response.Status.OK.getStatusCode(),
    //             Response.ok(policySpecificRunManifest).build().getStatus());
    //     Assertions.assertEquals("api/v5/nonlinear/migration/policies/" + policyCreated.getId() + "/runs/manifest/"
    //             + policyLastRunManifest.getManifestID(), policySpecificRunManifest.getLink());
    //     for (int i = 0; i < policySpecificRunManifest.getMigrationFlow().size(); i++) {
    //         String actionType = storageXRequestData.getMigrationFlow().get(i).getAction();
    //         Assertions.assertTrue(policySpecificRunManifest.getManifest().toString().toLowerCase()
    //                 .contains(actionType.toLowerCase()));
    //     }
    //     policyIdCreatedList.add(policyCreated.getId());
    // }

    @Test
    @Order(15)
    public void getSpecificRunManifestOfPolicyTest_Fail() {
        try {
            sxService.getSpecificRunManifestOfPolicy(testUtility.getRandomId(token),
                    testUtility.getRandomId(token), token);
        } catch (Exception exception) {
            Assertions.assertTrue(exception.getMessage().contains("status code 500"));
        }
    }

    @Test
    @Order(22)
    public void cancelPoliciesTest_Fail_WhenPoliciesPresentInDatabase() {
        PoliciesResponseDto storageXRequestData1 = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policy1 = sxService.createPolicy(storageXRequestData1, token);
        PoliciesResponseDto storageXRequestData2 = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policy2 = sxService.createPolicy(storageXRequestData2, token);
        Integer[] policyIds = new Integer[2];
        policyIds[0] = policy1.getId();
        policyIds[1] = policy2.getId();
        try {
            sxService.cancelPolicies(policyIds, token);
        } catch (Exception exception) {
            Assertions.assertTrue(exception.getMessage().contains("status code 400"));
        }
        policyIdCreatedList.add(policy1.getId());
        policyIdCreatedList.add(policy2.getId());
    }

    @Test
    @Order(23)
    public void cancelPoliciesTest_Fail_WhenPoliciesNotInDatabase() {
        Integer[] policyIds = new Integer[2];
        policyIds[0] = testUtility.getRandomId(token);
        policyIds[1] = testUtility.getRandomId(token);
        try {
            sxService.cancelPolicies(policyIds, token);
        } catch (Exception exception) {
            Assertions.assertTrue(exception.getMessage().contains("status code 404"));
        }
    }

    @Test
    @Order(20)
    public void deletePoliciesTest_Pass() {
        PoliciesResponseDto storageXRequestData1 = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policy1 = sxService.createPolicy(storageXRequestData1, token);
        PoliciesResponseDto storageXRequestData2 = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policy2 = sxService.createPolicy(storageXRequestData2, token);
        Integer[] policyIds = new Integer[2];
        policyIds[0] = policy1.getId();
        policyIds[1] = policy2.getId();
        String response = sxService.deletePolicies(policyIds, token);
        Assertions.assertTrue(response.contains("deleted"));
    }

    @Test
    @Order(21)
    public void deletePoliciesTest_Fail() {
        Integer[] policyIds = new Integer[2];
        policyIds[0] = testUtility.getRandomId(token);
        policyIds[1] = testUtility.getRandomId(token);
        try {
            sxService.deletePolicies(policyIds, token);
        } catch (Exception exception) {
            Assertions.assertTrue(exception.getMessage().contains("status code 404"));
        }
    }

    @Test
    @Order(16)
    public void movePolicyToFirstActionTest_Pass() {
        PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policy = sxService.createPolicy(storageXRequestData, token);
        String response = sxService.movePolicyToFirstAction(policy.getId(), token);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), Response.ok(response).build().getStatus());
        Assertions.assertTrue(
                response.toString().contains("Successfully moved the nonlinear migration policy to the first action."));
        policyIdCreatedList.add(policy.getId());
    }

    @Test
    @Order(17)
    public void movePolicyToFirstActionTest_Fail() {
        try {
            sxService.movePolicyToFirstAction(testUtility.getRandomId(token), token);
        } catch (Exception exception) {
            Assertions.assertTrue(exception.getMessage().contains("status code 404"));
        }
    }

    @Test
    @Order(18)
    public void movePolicyToNextActionTest_Pass() {
        PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
        PoliciesResponseDto policy = sxService.createPolicy(storageXRequestData, token);
        String response = sxService.movePolicyToNextAction(policy.getId(), token);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), Response.ok(response).build().getStatus());
        Assertions.assertTrue(
                response.toString().contains("Successfully moved the nonlinear migration policy to the next action."));
        policyIdCreatedList.add(policy.getId());
    }

    @Test
    @Order(19)
    public void movePolicyToNextActionTest_Fail() {
        try {
            sxService.movePolicyToNextAction(testUtility.getRandomId(token), token);
        } catch (Exception exception) {
            Assertions.assertTrue(exception.getMessage().contains("status code 404"));
        }
    }

    @Test
    @Order(24)
    public void validatePolicyTest_Pass_OneAction() {
        PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
        String parameterName = storageXRequestData.getMigrationFlow().get(0).getAction();
        String response = sxService.validatePolicy(storageXRequestData, token, parameterName);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), Response.ok(response).build().getStatus());
        Assertions.assertTrue(response.toString().contains("Success"));
    }

    @Test
    @Order(25)
    public void validatePolicyTest_Pass_AllActions() {
        PoliciesResponseDto storageXRequestData = testUtility.getStorageXRequest(token);
        String response = sxService.validatePolicy(storageXRequestData, token, null);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), Response.ok(response).build().getStatus());
        Assertions.assertTrue(response.toString().contains("Success"));
    }

}
