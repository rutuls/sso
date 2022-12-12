package com.datdyn.platform.maf.dtos.Responses;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SXResponseDto {
    @JsonProperty("Link")
    private String link;
    @JsonProperty("TotalCount")
    private Integer totalCount;
    @JsonProperty("ReturnedCount")
    private Integer returnedCount;
    @JsonProperty("Policies")
    private ArrayList<PoliciesResponseDto> policies;
}
