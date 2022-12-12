// THIS CLASS IS CURRENTLY NOT BEING USED AS INTENDED. THERE ARE PLANS FOR THE SAME

package com.datdyn.platform.sxsdk.api;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.datdyn.platform.sxsdk.configs.SXConfig;
import com.datdyn.platform.sxsdk.service.SXRestClient;
import com.datdyn.platform.sxsdk.service.SXRestClientHeaderFactory;

@Singleton
public class SXConnector {

  @Inject
  SXConfig sxConfig;

  @RestClient
  SXRestClient sxClient;
  
  @PostConstruct
  synchronized public void init() {
    SXRestClientHeaderFactory.setAuthToken(
      sxClient.getToken("UserName=" + sxConfig.username() + "&Password=" + sxConfig.password() + "&grant_type=password")
      .getAccessToken());
  }
  
  
// This code will be used later on
//   public Uni<PagedResponse<Policy>> getAllPolicies(Integer pageNumber, Integer pageSize) {
//     // sxClient.getToken(SXLoginRequest.builder().username(sxConfig.username()).password(sxConfig.password()).build())
//     // .subscribe().with(res -> {
//     // SXRestClientHeaderFactory.setAuthToken(res.getAccessToken());
//     // });
//     return sxClient.getAllPolicies(pageNumber, pageSize);
//   }

}
