package com.datdyn.platform.maf.dtos.Responses;

import java.util.ArrayList;

import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.Actions;
import com.datdyn.platform.maf.dtos.FlowDTOs.MigrationFlow.ActionExecution;
import com.datdyn.platform.maf.dtos.FlowDTOs.MigrationSchedule.MigrationSchedule;
import com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.ReplicationOptions;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PoliciesResponseDto {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Source")
    private String source;
    @JsonProperty("Destination")
    private String destination;
    @JsonProperty("CreatedBy")
    private String createdBy;
    @JsonProperty("ModifiedBy")
    private String modifiedBy;
    @JsonProperty("MigrationSchedule")
    private MigrationSchedule migrationSchedule;
    @JsonProperty("Actions")
    private Actions actions;
    @JsonProperty("ReplicationOptions")
    private ReplicationOptions replicationOptions;
    @JsonProperty("MigrationFlow")
    private ArrayList<ActionExecution> migrationFlow;
}
