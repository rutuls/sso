package com.datdyn.platform.maf.exceptions.mappers;

import java.util.UUID;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.datdyn.platform.maf.dtos.ErrorResponseDto;

import io.quarkus.logging.Log;

@Provider
public class ThrowableMapper implements ExceptionMapper<Throwable> {

  @Override
  public Response toResponse(Throwable throwable) {
    UUID uuid = UUID.randomUUID();
    Log.error(uuid.toString() + ": Internal Server Error", throwable);
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(new ErrorResponseDto(uuid.toString(),
            "Internal Server Error, please check the logs with 'uuid' for more information about the error", null))
        .build();
  }

}
