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
public class DestinationManifest {
    @JsonProperty("ComparisonResult")
    String ComparisonResult;
    @JsonProperty("ChildManifestID")
    Long ChildManifestID;
    @JsonProperty("Status")
    String Status;
    @JsonProperty("DataEngine")
    String DataEngine;
    @JsonProperty("UTCQueueTime")
    String UTCQueueTime;
    @JsonProperty("UTCStartTime")
    String UTCStartTime;
    @JsonProperty("UTCStopTime")
    String UTCStopTime;
    @JsonProperty("ElapsedTime")
    String ElapsedTime;
    @JsonProperty("Files")
    Long Files;
    @JsonProperty("Directories")
    Long Directories;
    @JsonProperty("TotalBytesOfFilesAndSymlinks")
    Long TotalBytesOfFilesAndSymlinks;
    @JsonProperty("TotalDiskSpaceUsed")
    Long TotalDiskSpaceUsed;
    @JsonProperty("IgnoredDirectories")
    Long IgnoredDirectories;
    @JsonProperty("SymbolicLinks")
    Long SymbolicLinks;
    
}
