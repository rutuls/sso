package com.datdyn.platform.maf.clients;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.datdyn.platform.maf.dtos.Responses.AuthResponseDto;
import com.datdyn.platform.maf.dtos.Responses.PoliciesResponseDto;
import com.datdyn.platform.maf.dtos.Responses.PolicyRunManifestResponseDto;
import com.datdyn.platform.maf.dtos.Responses.PolicyRunStatusResponseDto;
import com.datdyn.platform.maf.dtos.Responses.SXResponseDto;


@RegisterRestClient()
public interface SXService {

        @POST
        @Path("/token")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        AuthResponseDto loginSX(@RequestBody String credentials);

        @POST
        @Path("/api/v5/nonlinear/migration/policies")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        PoliciesResponseDto createPolicy(@RequestBody PoliciesResponseDto policy,
                        @HeaderParam("Authorization") String token);

        @PUT
        @Path("/api/v5/nonlinear/migration/policies/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        PoliciesResponseDto updatePolicy(@RequestBody PoliciesResponseDto Policy, @PathParam("id") Integer id,
                        @HeaderParam("Authorization") String token);

        @GET
        @Path("/api/v5/nonlinear/migration/policies/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        PoliciesResponseDto getPolicyById(@PathParam("id") Integer id, @HeaderParam("Authorization") String token);

        @GET
        @Path("/api/v5/nonlinear/migration/policies")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        SXResponseDto getAllPolicies(@HeaderParam("Authorization") String token);

        @POST
        @Path("/api/v5/nonlinear/migration/policies/{id}/runs")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        String triggerPolicyRun(@PathParam("id") Integer id, @HeaderParam("Authorization") String token);

        @GET
        @Path("/api/v5/nonlinear/migration/policies/{id}/runs/statuses")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        PolicyRunStatusResponseDto getAllRunStatusesOfPolicy(@PathParam("id") Integer id,
                        @HeaderParam("Authorization") String token);

        @GET
        @Path("/api/v5/nonlinear/migration/policies/{id}/runs/manifest")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        PolicyRunManifestResponseDto getLastRunManifestOfPolicy(@PathParam("id") Integer id,
                        @HeaderParam("Authorization") String token);

        @GET
        @Path("/api/v5/nonlinear/migration/policies/{id}/runs/manifest/{manifestid}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        PolicyRunManifestResponseDto getSpecificRunManifestOfPolicy(@PathParam("id") Integer id,
                        @PathParam("manifestid") Integer manifestid,
                        @HeaderParam("Authorization") String token);

        @DELETE
        @Path("/api/v5/nonlinear/migration/policies/cancel")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        String cancelPolicies(@QueryParam("ids") Object[] policyIds,
                        @HeaderParam("Authorization") String token);

        @DELETE
        @Path("/api/v5/nonlinear/migration/policies")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        String deletePolicies(@QueryParam("ids") Object[] policyIds,
                        @HeaderParam("Authorization") String token);

        @PUT
        @Path("/api/v5/nonlinear/migration/policies/{id}/firstAction")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        String movePolicyToFirstAction(@PathParam("id") Integer id, @HeaderParam("Authorization") String token);

        @PUT
        @Path("/api/v5/nonlinear/migration/policies/{id}/nextAction")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        String movePolicyToNextAction(@PathParam("id") Integer id, @HeaderParam("Authorization") String token);

        @POST
        @Path("/api/v5/nonlinear/migration/policies/validation")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        String validatePolicy(@RequestBody PoliciesResponseDto policyDefinition,
                        @HeaderParam("Authorization") String token, @QueryParam("parameterName") String parameterName);

}