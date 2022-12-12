package com.datdyn.platform.maf.dtos.APIResponse;

import java.util.List;

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
public class SXRequestResponse {
    @JsonProperty("Id")
    Long id;
    @JsonProperty("Name")
    String name;
    @JsonProperty("ProjectGroup")
    String projectGroup;
    @JsonProperty("Description")
    String description;
    @JsonProperty("Source")
    String source;
    @JsonProperty("Destination")
    String destination;
    @JsonProperty("CreatedBy")
    String createdBy;
    @JsonProperty("ModifiedBy")
    String modifiedBy;
    @JsonProperty("UTCCreatedTime")
    String UTCCreatedTime;
    @JsonProperty("UTCModifiedTime")
    String UTCModifiedTime;
    @JsonProperty("MigrationSchedule")
    MigrationSchedule migrationSchedule;
    @JsonProperty("Actions")
    Actions actions;
    @JsonProperty("ReplicationOptions")
    ReplicationOptions replicationOptions;
    @JsonProperty("MigrationFlow")
    List<ActionExecution> migrationFlow;
}