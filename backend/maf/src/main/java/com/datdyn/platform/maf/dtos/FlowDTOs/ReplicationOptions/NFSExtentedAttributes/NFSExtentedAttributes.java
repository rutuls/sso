package com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.NFSExtentedAttributes;

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
public class NFSExtentedAttributes {
    @JsonProperty("PreserveExtendedAttributes")
    Boolean preserveExtendedAttributes;
    @JsonProperty("PosixNFSv4ACL")
    Boolean posixNFSv4ACL;
    @JsonProperty("UserMappingsEnabled")
    Boolean userMappingsEnabled;
    @JsonProperty("UserMappingsCollection")
    List<UserMappingsCollection> UserMappingsCollection;
}
