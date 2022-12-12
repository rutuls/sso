package com.datdyn.platform.sxsdk.models.PolicyRun.Batch2;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Batch2Menifest {
    @JsonProperty("ChildManifestID")
    Integer childManifestID;
    @JsonProperty("Status")
    String Status;
    @JsonProperty("UTCStartTime")
    String UTCStartTime;
    @JsonProperty("UTCStopTime")
    String UTCStopTime;
    @JsonProperty("ElapsedTime")
    String ElapsedTime;
    @JsonProperty("ExitCode")
    Integer ExitCode;
    @JsonProperty("StdOut")
    String StdOut;
    @JsonProperty("StdErr")
    String StdErr;
}
