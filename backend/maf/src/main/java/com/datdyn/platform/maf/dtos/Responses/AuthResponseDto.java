package com.datdyn.platform.maf.dtos.Responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("DomainName")
    private String domainName;
    @JsonProperty("Role")
    private String role;
    @JsonProperty("expires_in")
    private String expiresIn;
    @JsonProperty("error")
    private String error;
    @JsonProperty("error_description")
    private String errorDescription;

}
