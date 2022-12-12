package com.datdyn.platform.sxsdk.exceptions;

import javax.ws.rs.core.Response;

public class NoResourceFoundException extends RuntimeException {
  private Response sxAPIResponse;

  public NoResourceFoundException(String message, Response sxAPIResponse) {
    super(message);
    this.sxAPIResponse = sxAPIResponse;
  }

  public NoResourceFoundException(Throwable cause, Response sxAPIResponse) {
    super(cause);
    this.sxAPIResponse = sxAPIResponse;
  }

  public NoResourceFoundException(String message, Throwable throwable, Response sxAPIResponse) {
    super(message, throwable);
    this.sxAPIResponse = sxAPIResponse;
  }

  public Response getOriginalSXResponse() {
    return this.sxAPIResponse;
  }
}
