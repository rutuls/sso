package com.datdyn.platform.maf.dtos.APIResponse;

import java.time.Instant;

import com.datdyn.platform.maf.entities.Template;
import com.datdyn.platform.maf.enums.TemplateType;
import com.datdyn.platform.maf.models.TemplateModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateResponseDto {
  String id;
  String name;
  String label;
  String description;
  TemplateType type;
  TemplateModel templateJSON;
  String createdBy;
  Instant createdDate;
  String lastModifiedBy;
  Instant lastModifiedDate;

  public TemplateResponseDto(Template template) {
    this.id = template.getId();
    this.name = template.getName();
    this.label = template.getLabel();
    this.description = template.getDescription();
    this.type = template.getType();
    this.templateJSON = template.getModel();
    this.createdBy = template.getCreatedBy();
    this.createdDate = template.getCreatedDate();
    this.lastModifiedBy = template.getLastModifiedBy();
    this.lastModifiedDate = template.getLastModifiedDate();
  }
}
