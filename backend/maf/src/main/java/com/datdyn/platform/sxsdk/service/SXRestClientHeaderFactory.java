// THIS CLASS IS CURRENTLY NOT BEING USED AS INTENDED. THERE ARE PLANS FOR THE SAME

package com.datdyn.platform.sxsdk.service;

import javax.inject.Singleton;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;


@Singleton
public class SXRestClientHeaderFactory implements ClientHeadersFactory {
  private static String AUTH_HEADER_NAME = "Authorization";
  private static String token = "dummyToken";
  public static void setAuthToken(String token) {
    SXRestClientHeaderFactory.token = token != null ? token : "";
  }

  @Override
  public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders,
      MultivaluedMap<String, String> clientOutgoingHeaders) {
        MultivaluedHashMap<String, String> newHeaders = new MultivaluedHashMap<>();
        newHeaders.add(AUTH_HEADER_NAME, "Bearer " + token);
        return newHeaders;
  }
}
