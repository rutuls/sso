package com.datdyn.platform.sxsdk.models.ReplicationOptions.CIFSSecurityReplication;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CIFSSecurityReplication {
    @JsonProperty("SecurityDescriptorProcessing")
    SecurityDescriptorProcessing securityDescriptorProcessing;
}
