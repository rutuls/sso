package com.datdyn.platform.maf.apis;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import com.datdyn.platform.maf.dtos.APIResponse.TemplateResponseDto;
import com.datdyn.platform.maf.services.internal.TemplateService;


@Path(ApiVersions.V1 + "/templates")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TemplatesResource {

  @Inject
  TemplateService templateService;

  @GET
  @Operation(summary = "Fetch all migration templates.", description = "Fetch all templates of the current user.")
  @APIResponses(value = {
      @APIResponse(responseCode = "200", name = "Ok"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public List<TemplateResponseDto> getTemplates() {
    return templateService.getAllTemplates();
  }

  @GET
  @Path("/{templateId}")
  @Operation(summary = "Fetch migration template with provided {templateId}.", description = "Fetch migration template with provided {templateId}.")
  @APIResponses(value = {
      @APIResponse(responseCode = "200", name = "Ok"),
      @APIResponse(responseCode = "401", name = "Unauthorized", description = "Unauthorized"),
      @APIResponse(responseCode = "403", name = "Forbidden", description = "Forbidden"),
      @APIResponse(responseCode = "404", name = "Not Found", description = "No template exists in the system with provided {templateId}"),
      @APIResponse(responseCode = "500", name = "Internal Server Error", description = "Internal Server Error")
  })
  public TemplateResponseDto getTemplate(@Valid @NotBlank @PathParam("templateId") String templateId) {
    return templateService.getById(templateId);
  }
}
