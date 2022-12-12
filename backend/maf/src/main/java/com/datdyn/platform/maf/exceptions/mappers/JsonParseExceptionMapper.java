package com.datdyn.platform.maf.exceptions.mappers;

import java.util.UUID;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.datdyn.platform.maf.dtos.ErrorResponseDto;
import com.fasterxml.jackson.core.JsonParseException;

import io.quarkus.logging.Log;

@Provider
public class JsonParseExceptionMapper implements ExceptionMapper<JsonParseException> {

  @Override
  public Response toResponse(JsonParseException jse) {
    UUID uuid = UUID.randomUUID();
    Log.debug(uuid.toString() + ": Invalid Json Format of Request Payload", jse);
    return Response.status(Response.Status.BAD_REQUEST)
        .entity(new ErrorResponseDto(uuid.toString(), "Invalid JSON Format of Request Payload", null)).build();
  }

}
