package com.datdyn.platform.sxsdk.models;

import java.util.List;

import com.datdyn.platform.sxsdk.models.Actions.Actions;
import com.datdyn.platform.sxsdk.models.MigrationFlow.ActionExecution;
import com.datdyn.platform.sxsdk.models.MigrationSchedule.MigrationSchedule;
import com.datdyn.platform.sxsdk.models.ReplicationOptions.ReplicationOptions;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SXResponse {
    @JsonProperty("Id")
    Long id;
    @JsonProperty("Name")
    String name;
    @JsonProperty("ProjectName")
    String projectName;
    @JsonProperty("Description")
    String description;
    @JsonProperty("LastRunStatus")
    String lastRunStatus;
    @JsonProperty("LastRunAction")
    String lastRunAction;
    @JsonProperty("NextRunAction")
    String nextRunAction;
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