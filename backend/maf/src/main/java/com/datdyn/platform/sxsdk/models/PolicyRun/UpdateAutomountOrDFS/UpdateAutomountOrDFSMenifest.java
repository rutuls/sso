package com.datdyn.platform.sxsdk.models.PolicyRun.UpdateAutomountOrDFS;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateAutomountOrDFSMenifest {
    @JsonProperty("ChildManifestID")
    Integer childManifestID;
    @JsonProperty("Status")
    String Status;
    @JsonProperty("ErrorCode")
    Integer ErrorCode;
    @JsonProperty("UTCStartTime")
    String UTCStartTime;
    @JsonProperty("UTCStopTime")
    String UTCStopTime;
}
