package com.datdyn.platform.maf.dtos.APIResponse;

import java.time.Instant;

import com.datdyn.platform.maf.entities.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponentResponseDto {
    
    String id;
    String name;
    String label;
    String description;
    // JsonObject componentJSON;
    String createdBy;
    Instant createdDate;
    String lastModifiedBy;
    Instant lastModifiedDate;
    //Long order;
  
    public ComponentResponseDto(Component component) {
      this.id = component.getId();
      this.name = component.getName();
      this.label = component.getLabel();
      this.description = component.getDescription();
      // this.componentJSON = component.getModel();
      this.createdBy = component.getCreatedBy();
      this.createdDate = component.getCreatedDate();
      this.lastModifiedBy = component.getLastModifiedBy();
      this.lastModifiedDate = component.getLastModifiedDate();
      //this.order = component.getOrder();
    }

}
