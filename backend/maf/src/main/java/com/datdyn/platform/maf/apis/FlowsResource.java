package com.datdyn.platform.maf.apis;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.datdyn.platform.sxsdk.api.SXConnector;
import com.datdyn.platform.sxsdk.models.GetAllPolicyResponse;
import com.datdyn.platform.sxsdk.models.PolicyRunManifestResponseDto;
import com.datdyn.platform.sxsdk.models.PolicyRunStatusResponseDto;
import com.datdyn.platform.sxsdk.models.SXRequest;
import com.datdyn.platform.sxsdk.models.SXResponse;
import com.datdyn.platform.sxsdk.models.ValidateAPIResponse;
import com.datdyn.platform.sxsdk.service.SXRestClient;

@Path(ApiVersions.V1 + "/flows")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FlowsResource {

  @Inject
  SXConnector sxConnector;

  @RestClient
  SXRestClient sxClient;

  @GET
  @Operation(summary = "Fetch all user's migration flows.", description = "Fetch all flows of the current user.")
  @APIResponses(value = {
      @APIResponse(responseCode = "200", name = "Ok"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public GetAllPolicyResponse getFlows(@QueryParam("pageNumber") Integer pageNumber, @QueryParam("pageSize") Integer pageSize) {
    return sxClient.getAllPolicies(pageNumber, pageSize);
  }

  @GET
  @Path("/{flowId}")
  @Operation(summary = "Fetch user's migration flow with provided {flowId}.", description = "Fetch existing user flow with provided {flowId}.")
  @APIResponses(value = {
      @APIResponse(responseCode = "200", name = "Ok"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "404", name = "Not Found", description = "No flow exists in the system with provided {flowId}"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public SXResponse getFlow(@Valid @NotBlank @PathParam("flowId") String flowId) {
    return sxClient.getPolicyById(flowId);
  }

  @POST
  @Path("/validate")
  @Operation(summary = "Validate the migration flow.", description = "Validate the migration flow.")
  @APIResponses(value = {
      @APIResponse(responseCode = "200", name = "Ok", description = "Provided migration flow is valid"),
      @APIResponse(responseCode = "400", name = "Bad Request", description = "Provided migration flow is not valid"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public ValidateAPIResponse validateFlow(@RequestBody SXRequest sxRequestResponse,@QueryParam("parameterName") String parameterName) {
    return sxClient.validatePolicyJSON(sxRequestResponse, parameterName);
  }

  @POST
  @Operation(summary = "Create new migration flow.", description = "Create new migration flow in the system.")
  @APIResponses(value = {
      @APIResponse(responseCode = "201", name = "Created", description = "Provided new migration flow has been created and stored in the system"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public SXResponse createFlow(@RequestBody SXRequest sxRequestResponse) {
    return sxClient.createPolicy(sxRequestResponse);
  }

  @PUT
  @Path("/{flowId}")
  @Operation(summary = "Update existing migration flow.", description = "Update existing migration flow in the system for provided {flowId}.")
  @APIResponses(value = {
      @APIResponse(responseCode = "200", name = "Ok"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "404", name = "Not Found", description = "No flow exists in the system with provided {flowId}"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public SXResponse updateFlow(@Valid @PathParam("flowId") Long flowId, @RequestBody SXRequest sxRequestResponse) {
    return sxClient.updatePolicy(sxRequestResponse, flowId);
  }


  @DELETE
  @Operation(summary = "Delete user's migration flow with provided {flowId}.", description = "Delete existing user flow with provided {flowId}.")
  @APIResponses(value = {
      @APIResponse(responseCode = "204", name = "No Content", description = "Flow has been deleted but no content to return"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "404", name = "Not Found", description = "No flow exists in the system with provided {flowId}"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public Response deleteFlow(@Valid @QueryParam("ids") Long[] policyIds) {
    return sxClient.deletePolicies(policyIds);
  }

  @DELETE
  @Path("cancel")
  @Operation(summary = "Cancel flow run", description = "Cancel flow run.")
  @APIResponses(value = {
      @APIResponse(responseCode = "204", name = "No Content", description = "Flow has been cancelled but no content to return"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "404", name = "Not Found", description = "No flow exists in the system with provided {flowId}"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public Response cancelFlowRun(@Valid @QueryParam("ids") Long[] policyIds) {
      return sxClient.cancelPolicies(policyIds);
  }

  @POST
  @Path("/{flowId}/run")
  @Operation(summary = "Run a migration flow.", description = "Run a migration flow.")
  @APIResponses(value = {
      @APIResponse(responseCode = "204", name = "No Content", description = "Flow triggered to run but no content to return"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "404", name = "Not Found", description = "No flow exists in the system with provided {flowId}"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public Response runFlow(@Valid @PathParam("flowId") Long flowId) {
    return sxClient.triggerPolicyRun(flowId);
  }

  @PUT
  @Path("/{flowId}/firstAction")
  @Operation(summary = "Move flow run to first action", description = "Move flow run to first action.")
  @APIResponses(value = {
      @APIResponse(responseCode = "204", name = "No Content", description = "Flow triggered to run but no content to return"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "404", name = "Not Found", description = "No flow exists in the system with provided {flowId}"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public Response movePolicyToFirstAction(@Valid @PathParam("flowId") Long flowId) {
    return sxClient.movePolicyToFirstAction(flowId);
  }

  @PUT
  @Path("/{flowId}/nextAction")
  @Operation(summary = "Move flow run to next action.", description = "Move flow run to next action.")
  @APIResponses(value = {
      @APIResponse(responseCode = "204", name = "No Content", description = "Flow triggered to run but no content to return"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "404", name = "Not Found", description = "No flow exists in the system with provided {flowId}"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public Response movePolicyToNextAction(@Valid @PathParam("flowId") Long flowId) {
    return sxClient.movePolicyToNextAction(flowId);
  }

  @GET
  @Path("/{flowId}/allRunStatus")
  @Operation(summary = "Get All Run Status of a policy.", description = "Get All Run Status of a policy.")
  @APIResponses(value = {
      @APIResponse(responseCode = "204", name = "No Content", description = "no content to return"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "404", name = "Not Found", description = "No flow exists in the system with provided {flowId}"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public PolicyRunStatusResponseDto getAllRunStatusesOfPolicy(@Valid @PathParam("flowId") Long flowId) {
    return sxClient.getAllRunStatusesOfPolicy(flowId);
  }

  @GET
  @Path("/{flowId}/lastRunStatus")
  @Operation(summary = "Get Last Run Status of a policy.", description = "Get Last Run Status of a policy.")
  @APIResponses(value = {
      @APIResponse(responseCode = "204", name = "No Content", description = "no content to return"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "404", name = "Not Found", description = "No flow exists in the system with provided {flowId}"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public PolicyRunManifestResponseDto getLastRunManifestOfPolicy(@Valid @PathParam("flowId") Long flowId) {
    return sxClient.getLastRunManifestOfPolicy(flowId);
  }

  @GET
  @Path("/{flowId}/manifest/{manifestId}")
  @Operation(summary = "Get Last Run Status of a policy.", description = "Get Last Run Status of a policy.")
  @APIResponses(value = {
      @APIResponse(responseCode = "204", name = "No Content", description = "no content to return"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "404", name = "Not Found", description = "No flow exists in the system with provided {flowId}"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public PolicyRunManifestResponseDto getSpecificRunManifestOfPolicy(@Valid @PathParam("flowId") Long flowId,@Valid @PathParam("manifestId") Long manifestid) {
    return sxClient.getSpecificRunManifestOfPolicy(flowId,manifestid);
  }

}
