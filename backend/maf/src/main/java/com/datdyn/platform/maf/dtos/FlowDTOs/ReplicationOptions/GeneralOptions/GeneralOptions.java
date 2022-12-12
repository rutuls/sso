package com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.GeneralOptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneralOptions {
    @JsonProperty("AssertBackup")
    Boolean assertBackup;
    @JsonProperty("IncludeSubFolders")
    Boolean includeSubFolders;
    @JsonProperty("AllowStreamLoss")
    Boolean allowStreamLoss;
    @JsonProperty("DeleteOrphanFilesAndFolderOnDestination")
    Boolean deleteOrphanFilesAndFolderOnDestination;
    @JsonProperty("EnableCopyInPlace")
    Boolean enableCopyInPlace;
    @JsonProperty("OverrideTimeStamp")
    Boolean overrideTimeStamp;
    @JsonProperty("PreserveLastAccessTimeOnSource")
    Boolean preserveLastAccessTimeOnSource;
    @JsonProperty("CopyDirectoriesOnly")
    Boolean copyDirectoriesOnly;
    @JsonProperty("HandleHardlinks")
    Boolean handleHardLinks;
    @JsonProperty("CopyFiles")
    Integer copyFiles;
    @JsonProperty("CopySecurity")
    Integer copySecurity;
    @JsonProperty("RetryFailOpenFile")
    RetryFailOpenFile retryFailOpenFile;
    @JsonProperty("ReplicationDuration")
    ReplicationDuration replicationDuration;
    @JsonProperty("EventDetails")
    EventDetails eventDetails;
}