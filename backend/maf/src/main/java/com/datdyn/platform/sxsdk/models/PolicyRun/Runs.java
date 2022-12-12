package com.datdyn.platform.sxsdk.models.PolicyRun;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Runs {
    @JsonProperty("ManifestID")
    private Integer manifestID;
    @JsonProperty("RunStatus")
    private String runStatus;
    @JsonProperty("PolicyRunDurationInSeconds")
    private Long policyRunDurationInSeconds;
    @JsonProperty("Agent")
    private String agent;
    @JsonProperty("UTCStartTime")
    private String uTCStartTime;
    @JsonProperty("UTCEndTime")
    private String uTCEndTime;
}
