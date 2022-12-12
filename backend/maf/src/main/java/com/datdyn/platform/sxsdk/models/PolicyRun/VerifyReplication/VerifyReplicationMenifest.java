package com.datdyn.platform.sxsdk.models.PolicyRun.VerifyReplication;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerifyReplicationMenifest {
    @JsonProperty("Source")
    SourceManifest sourceManifest;
    @JsonProperty("Destination")
    DestinationManifest destinationManifest;
}
