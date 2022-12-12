//This class is currently not being used. For future scope to improve the project.

package com.datdyn.platform.maf.dtos.APIResponse;

import java.time.Instant;

import com.datdyn.platform.maf.entities.Flow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlowResponseDto {

    String id;
    String name;
    String projectName;
    Long sxRefId;
    String status;
    Instant createdDate;
    String createdBy;
    Instant lastModifiedDate;
    String lastModifiedBy;
  
    public FlowResponseDto(Flow flow){
        this.id = flow.getId();
        this.name = flow.getName();
        this.projectName = flow.getProjectName();
        this.sxRefId = flow.getSxRefId();
        this.status = flow.getStatus();
        this.createdDate = flow.getCreatedDate();
        this.createdBy = flow.getCreatedBy();
        this.lastModifiedDate = flow.getLastModifiedDate();
        this.lastModifiedBy = flow.getLastModifiedBy();
    }
}
