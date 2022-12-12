package com.datdyn.platform.maf.exceptions.mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.datdyn.platform.maf.dtos.ErrorResponseDto;
import com.datdyn.platform.maf.dtos.ErrorResponseDto.FieldConstraintErrorDto;
import io.quarkus.logging.Log;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

  @Override
  public Response toResponse(ConstraintViolationException cve) {
    UUID uuid = UUID.randomUUID();
    Log.debug(uuid.toString() + ": Validation Failed", cve);
    
    List<FieldConstraintErrorDto> errors = cve.getConstraintViolations().stream().map(cv -> {
      return new FieldConstraintErrorDto(cv.getPropertyPath().toString(), cv.getMessage());
    }).collect(Collectors.toList());

    return Response.status(Response.Status.BAD_REQUEST)
        .entity(new ErrorResponseDto(UUID.randomUUID().toString(), "Bad Request", errors)).build();
  }

}