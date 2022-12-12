package com.datdyn.platform.sxsdk.models.ReplicationOptions.NFSExtentedAttributes;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMappingsCollection {
    @JsonProperty("Key")
    String key;
    @JsonProperty("SourceParameter")
    String sourceParameter;
    @JsonProperty("DestinationACE")
    String destinationACE;
}
