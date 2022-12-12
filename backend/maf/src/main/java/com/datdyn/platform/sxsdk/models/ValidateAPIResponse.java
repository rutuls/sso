package com.datdyn.platform.sxsdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidateAPIResponse {

    @JsonProperty("Status")
    String Status;
    @JsonProperty("Message")
    String Message;
}
