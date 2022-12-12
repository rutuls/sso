package com.datdyn.platform.sxsdk.models.PolicyRun.CopyDataOnce;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CopyDataOnceMenifest {
    @JsonProperty("ChildManifestID")
    Long ChildManifestID; 
    @JsonProperty("DetailsCount")
    Long DetailsCount;
    @JsonProperty("Summary")
    CopyDataOnceSummary copyDataOnceSummary;
}
