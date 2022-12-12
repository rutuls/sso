package com.datdyn.platform.sxsdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SXLoginResponse {
  @JsonProperty("access_token")
  String accessToken;
}
