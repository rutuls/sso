package com.datdyn.platform.sxsdk.models.PolicyRun.StopSharingSource;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StopSharingSourceMenifest {
    @JsonProperty("ChildManifestID")
    Long ChildManifestID;
    @JsonProperty("Status")
    String Status;
    @JsonProperty("ErrorMessage")
    String ErrorMessage;
    @JsonProperty("ErrorCode")
    Long ErrorCode;
    @JsonProperty("UTCStartTime")
    String UTCStartTime;
    @JsonProperty("UTCStopTime")
    String UTCStopTime;
    @JsonProperty("OriginalShareName")
    String OriginalShareName;
}
