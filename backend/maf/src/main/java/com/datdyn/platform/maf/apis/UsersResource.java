package com.datdyn.platform.maf.apis;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.datdyn.platform.maf.services.UserService;

@Path(ApiVersions.V1+"/users")
public class UsersResource {

  @Inject
  UserService userService;

  @GET
  @Path("/count")
  public Long count() {
    return 1L;
  }
}
