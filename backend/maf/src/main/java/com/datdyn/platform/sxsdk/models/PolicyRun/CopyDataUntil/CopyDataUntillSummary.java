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
public class CopyDataUntillSummary {

    @JsonProperty("Source")
    String Source;
    @JsonProperty("Destination")
    String Destination;
    @JsonProperty("DataEngine")
    String DataEngine;
    @JsonProperty("UTCStartTime")
    String UTCStartTime;
    @JsonProperty("UTCStopTime")
    String UTCStopTime;
    @JsonProperty("ElapsedTime")
    String ElapsedTime;
    @JsonProperty("Operation")
    String Operation;
    @JsonProperty("Status")
    String Status;
    @JsonProperty("EventDetails")
    String EventDetails;
    @JsonProperty("DifferentialReplication")
    String DifferentialReplication;
    @JsonProperty("ReplicationMethod")
    String ReplicationMethod;
    @JsonProperty("Simulation")
    Boolean Simulation;
    @JsonProperty("Warnings")
    Long Warnings;
    @JsonProperty("Errors")
    Long Errors;
    @JsonProperty("FoldersCopied")
    Long FoldersCopied;
    @JsonProperty("FolderSecurityCopied")
    Long FolderSecurityCopied;
    @JsonProperty("FoldersInSync")
    Long FoldersInSync;
    @JsonProperty("FoldersDeleted")
    Long FoldersDeleted;
    @JsonProperty("FoldersFailed")
    Long FoldersFailed;
    @JsonProperty("FoldersExcluded")
    Long FoldersExcluded;
    @JsonProperty("FoldersIgnored")
    Long FoldersIgnored;
    @JsonProperty("FilesCopied")
    Long FilesCopied;
    @JsonProperty("FileSecurityCopied")
    Long FileSecurityCopied;
    @JsonProperty("FilesInSync")
    Long FilesInSync;
    @JsonProperty("FilesDeleted")
    Long FilesDeleted;
    @JsonProperty("FilesFailed")
    Long FilesFailed;
    @JsonProperty("FilesExcluded")
    Long FilesExcluded;
    @JsonProperty("FilesIgnored")
    Long FilesIgnored;
    @JsonProperty("BytesCopied")
    Long BytesCopied;
    @JsonProperty("BytesInSync")
    Long BytesInSync;
    @JsonProperty("BytesDeleted")
    Long BytesDeleted;
    @JsonProperty("BytesExcluded")
    Long BytesExcluded;
    @JsonProperty("InitialThrottle")
    Long InitialThrottle;
    @JsonProperty("CopyRate")
    String CopyRate;
    @JsonProperty("ChecksumMismatches")
    Long ChecksumMismatches;
    
}
