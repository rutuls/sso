package com.datdyn.platform.maf.dtos.Responses;
import java.util.ArrayList;

import com.datdyn.platform.maf.dtos.FlowDTOs.MigrationFlow.ActionExecution;
import com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.ReplicationOptions;
import com.datdyn.platform.sxsdk.models.PolicyRun.Manifests;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyRunManifestResponseDto {
    @JsonProperty("PolicyID")
    private Integer policyID;
    @JsonProperty("ManifestID")
    private Integer manifestID;
    @JsonProperty("Link")
    private String link;
    @JsonProperty("LastRunAction")
    private String lastRunAction;
    @JsonProperty("LastRunActionOrder")
    private String lastRunActionOrder;
    @JsonProperty("LastRunActionResult")
    private String lastRunActionResult;
    @JsonProperty("Manifest")
    private Manifests manifest;
    @JsonProperty("ReplicationOptions")
    private ReplicationOptions replicationOptions;
    @JsonProperty("MigrationFlow")
    private ArrayList<ActionExecution> migrationFlow;
}
