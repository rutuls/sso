package com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.CIFSAttributesReplication;

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
    CIFSAttirbuteGeneric archive;
    @JsonProperty("ReadOnly")
    CIFSAttirbuteGeneric readOnly;
    @JsonProperty("Compressed")
    CIFSAttirbuteGeneric compressed;
    @JsonProperty("Hidden")
    CIFSAttirbuteGeneric hidden;
    @JsonProperty("System")
    CIFSAttirbuteGeneric system;
    @JsonProperty("ExcludeOffline")
    Boolean excludeOffline;
    @JsonProperty("DoCopySparseFiles")
    Boolean doCopySparseFiles;
    @JsonProperty("DoNotPreserveSparseFiles")
    Boolean doNotPreserveSparseFiles;
}
