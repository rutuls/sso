package com.datdyn.platform.maf.apis;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import com.datdyn.platform.maf.entities.Component;
import com.datdyn.platform.maf.services.internal.ComponentService;

@Path(ApiVersions.V1 + "/components")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ComponentsResource { 
     @Inject
     ComponentService componentService;
    
  @GET
  @Operation(summary = "Fetch all available components.", description = "Fetch all available components.")
  @APIResponses(value = {
      @APIResponse(responseCode = "200", name = "Ok"),
      @APIResponse(responseCode = "401", name = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden"),
      @APIResponse(responseCode = "500", name = "Internal Server Error")
  })
  public List<Component> getComponents() {
    List<Component> allComponents = componentService.getAllComponents();
    return allComponents;
  }
}
