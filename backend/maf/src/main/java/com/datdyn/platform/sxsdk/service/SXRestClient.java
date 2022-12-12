package com.datdyn.platform.sxsdk.service;

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

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.datdyn.platform.sxsdk.models.GetAllPolicyResponse;
import com.datdyn.platform.sxsdk.models.PolicyRunManifestResponseDto;
import com.datdyn.platform.sxsdk.models.PolicyRunStatusResponseDto;
import com.datdyn.platform.sxsdk.models.SXLoginResponse;
import com.datdyn.platform.sxsdk.models.SXRequest;
import com.datdyn.platform.sxsdk.models.SXResponse;
import com.datdyn.platform.sxsdk.models.ValidateAPIResponse;

@RegisterRestClient(configKey = "sx")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterClientHeaders(SXRestClientHeaderFactory.class)
//@RegisterProvider(value = ThrowableMapper.class)
//@Retry(maxRetries = 2,retryOn = AuthenticationRequiredException.class)
public interface SXRestClient {

    @POST
    @Path("/token")
    SXLoginResponse getToken(@RequestBody String credentials);

    @POST
    @Path("/api/v5/nonlinear/migration/policies")
    SXResponse createPolicy(@RequestBody SXRequest sxRequestDto);

    @PUT
    @Path("/api/v5/nonlinear/migration/policies/{id}")
    SXResponse updatePolicy(@RequestBody SXRequest sxRequestDto, @PathParam("id") Long id);

    @GET
    @Path("/api/v5/nonlinear/migration/policies/{id}")
    SXResponse getPolicyById(@PathParam("id") String id);

    @GET
    @Path("/api/v5/nonlinear/migration/policies")
    GetAllPolicyResponse getAllPolicies(@QueryParam("pageNumber") Integer pageNumber, @QueryParam("pageSize") Integer pageSize);

    @POST
    @Path("/api/v5/nonlinear/migration/policies/{id}/runs")
    Response triggerPolicyRun(@PathParam("id") Long id);

    @GET
    @Path("/api/v5/nonlinear/migration/policies/{id}/runs/statuses")
    PolicyRunStatusResponseDto getAllRunStatusesOfPolicy(@PathParam("id") Long id);

    @GET
    @Path("/api/v5/nonlinear/migration/policies/{id}/runs/manifest")
    PolicyRunManifestResponseDto getLastRunManifestOfPolicy(@PathParam("id") Long id);

    @GET
    @Path("/api/v5/nonlinear/migration/policies/{id}/runs/manifest/{manifestid}")
    PolicyRunManifestResponseDto getSpecificRunManifestOfPolicy(@PathParam("id") Long id, @PathParam("manifestid") Long manifestid);

    @DELETE
    @Path("/api/v5/nonlinear/migration/policies/cancel")
    Response cancelPolicies(@QueryParam("ids") Long[] policyIds);

    @DELETE
    @Path("/api/v5/nonlinear/migration/policies")
    Response deletePolicies(@QueryParam("ids") Long[] policyIds);

    @PUT
    @Path("/api/v5/nonlinear/migration/policies/{id}/firstAction")
    Response movePolicyToFirstAction(@PathParam("id") Long id);

    @PUT
    @Path("/api/v5/nonlinear/migration/policies/{id}/nextAction")
    Response movePolicyToNextAction(@PathParam("id") Long id);

    @POST
    @Path("/api/v5/nonlinear/migration/policies/validation")
    ValidateAPIResponse validatePolicyJSON(@RequestBody SXRequest sxRequestDto, @QueryParam("parameterName") String parameterName);

    @GET
    @Path("/api/v5/license/usagedetails")
    Response getLicenseUsage();
    
    // @ClientExceptionMapper
    // static RuntimeException toException(Response response) {
    //     switch (response.getStatus()) {
    //         case 400:
    //             return new NotProperRequestException("Bad Request i.e request is not proper as per the endpoint specifications.", response);
    //         case 401:
    //             return new AuthenticationRequiredException("Authentication required for the request, please authenticate and provide valid authentication token.", response);
    //         case 404:
    //             return new NoResourceFoundException("No resource found.", response);
    //     }
    //     return new DefaultException("The remote service call ended up with an error.", response);
    // }
}
