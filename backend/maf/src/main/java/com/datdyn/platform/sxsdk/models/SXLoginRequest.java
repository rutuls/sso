package com.datdyn.platform.sxsdk.models;

import org.jboss.resteasy.annotations.jaxrs.FormParam;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SXLoginRequest {
  @FormParam
  @JsonProperty("UserName")
  String username;
  @FormParam
  @JsonProperty("Password")
  String password;
  @FormParam
  @JsonProperty("grant_type")
  String grantType = "password";

  public SXLoginRequest(String username, String password) {
    this();
    this.username = username;
    this.password = password;
  }
}
