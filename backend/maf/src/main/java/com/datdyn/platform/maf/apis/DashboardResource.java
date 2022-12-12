package com.datdyn.platform.maf.apis;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import com.datdyn.platform.maf.services.internal.DashboardService;
import com.datdyn.platform.sxsdk.service.SXRestClient;

@Path(ApiVersions.V1 + "/dashboard")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DashboardResource {

    @RestClient
    SXRestClient sxClient;

    @Inject
    DashboardService dashboardService;

    @GET
    @Path("/policy/status/details")
    @Operation(summary = "Fetch count as per last run status for all policies", description = "Fetch count as per last run status for all policies")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", name = "Ok"),
            @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
            @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
            @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
    })
    public Response getAllPolicyStatusDetails() {
        try {
            return Response.ok().entity(dashboardService.getAllPolicyStatusDetails()).build();
        } catch (Exception exception) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/licenseDetails")
    @Operation(summary = "Fetch License Details for dashboard metering.", description = "Fetch License Details for dashboard metering..")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", name = "Ok"),
            @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
            @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
    })
    public Response getlicenseDetails() {
        return sxClient.getLicenseUsage();
    }

    @GET
    @Path("/project/details")
    @Operation(summary = "Fetch project details for dashboard metering.", description = "Fetch project details for dashboard metering.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", name = "Ok"),
            @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
            @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
            @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
    })
    public Response getAllProjectDetails() {
        try {
            return Response.ok(dashboardService.getAllProjectDetails()).build();
        } catch (Exception exception) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/owner/details")
    @Operation(summary = "Fetch owner details for dashboard metering.", description = "Fetch owner details for dashboard metering.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", name = "Ok"),
            @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
            @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
            @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
    })
    public Response getAllOwnerDetails() {
        try {
            return Response.ok(dashboardService.getAllOwnerDetails()).build();
        } catch (Exception exception) {
            return Response.serverError().build();
        }
    }
}
