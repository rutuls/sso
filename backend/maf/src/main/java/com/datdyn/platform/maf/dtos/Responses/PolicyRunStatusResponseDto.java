package com.datdyn.platform.maf.dtos.Responses;

import java.util.ArrayList;

import com.datdyn.platform.sxsdk.models.PolicyRun.Runs;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyRunStatusResponseDto {
    @JsonProperty("PolicyID")
    private Integer policyID;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Link")
    private String link;
    @JsonProperty("Source")
    private String source;
    @JsonProperty("PolicyRunStatus")
    private String policyRunStatus;
    @JsonProperty("LastRunStatus")
    private String lastRunStatus;
    @JsonProperty("LastAction")
    private String lastAction;
    @JsonProperty("LastActionOrderInWorkFlow")
    private String lastActionOrderInWorkFlow;
    @JsonProperty("HasScheduledTask")
    private Boolean hasScheduledTask;
    @JsonProperty("Runs")
    private ArrayList<Runs> runs;
}
