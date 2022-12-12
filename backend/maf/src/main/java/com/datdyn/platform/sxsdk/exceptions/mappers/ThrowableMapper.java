package com.datdyn.platform.sxsdk.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.datdyn.platform.sxsdk.exceptions.AuthenticationRequiredException;

@Provider
public class ThrowableMapper implements ExceptionMapper<AuthenticationRequiredException> {

  
  // @Override
  // public Response toResponse(Throwable throwable) {
  //   UUID uuid = UUID.randomUUID();
  //   Log.error(uuid.toString() + ": Internal Server Error", throwable);
  //   return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
  //       .entity(new ErrorResponseDto(uuid.toString(),
  //           "Internal Server Error, please check the logs with 'uuid' for more information about the error", null))
  //       .build();
  // }

  @Override
  public Response toResponse(AuthenticationRequiredException exception) {
    return null;
  }

}
