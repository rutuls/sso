package com.datdyn.platform.sxsdk.models.PolicyRun.PreventUserConnection;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreventUserConnectionMenifest {
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
    @JsonProperty("NewShareName")
    String NewShareName;
}
