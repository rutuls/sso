package com.datdyn.platform.sxsdk.models.ReplicationOptions.CIFSAttributesReplication;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CIFSAttributesReplication {
    @JsonProperty("Archive")
    CIFSAttributeGenericClass archive;
    @JsonProperty("ReadOnly")
    CIFSAttributeGenericClass readOnly;
    @JsonProperty("Compressed")
    CIFSAttributeGenericClass compressed;
    @JsonProperty("Hidden")
    CIFSAttributeGenericClass hidden;
    @JsonProperty("System")
    CIFSAttributeGenericClass system;
    @JsonProperty("ExcludeOffline")
    Boolean excludeOffline;
    @JsonProperty("DoCopySparseFiles")
    Boolean doCopySparseFiles;
    @JsonProperty("DoNotPreserveSparseFiles")
    Boolean doNotPreserveSparseFiles;
}
