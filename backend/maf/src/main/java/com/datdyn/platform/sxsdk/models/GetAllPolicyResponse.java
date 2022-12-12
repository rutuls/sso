package com.datdyn.platform.sxsdk.models;

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
public class GetAllPolicyResponse {

    @JsonProperty("TotalCount")
    Long TotalCount;
    @JsonProperty("ReturnedCount")
    Long ReturnedCount;
    @JsonProperty("Policies")
    List<Policy> policyList;
}