package com.datdyn.platform.sxsdk.models.PolicyRun.CopyDataUntil;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CopyDataUntilMenifest {
    @JsonProperty("ChildManifestID")
    Long ChildManifestID; 
    @JsonProperty("DetailsCount")
    Long DetailsCount;
    @JsonProperty("Summary")
    CopyDataUntillSummary summary;
}
