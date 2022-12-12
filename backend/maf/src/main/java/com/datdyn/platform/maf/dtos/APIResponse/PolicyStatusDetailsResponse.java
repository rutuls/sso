package com.datdyn.platform.maf.dtos.APIResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.TreeMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyStatusDetailsResponse {
    Map<String, Long> policyCountByLastRunStatus = new TreeMap<String, Long>();
}
