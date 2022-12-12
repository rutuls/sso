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
public class PolicyFolderCountsResponse {
    Map<String, Long> policyFileCountsResponse = new TreeMap<String, Long>();
}
