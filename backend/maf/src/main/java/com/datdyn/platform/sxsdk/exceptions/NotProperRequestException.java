package com.datdyn.platform.sxsdk.exceptions;

import javax.ws.rs.core.Response;

public class NotProperRequestException extends RuntimeException {
  private Response sxAPIResponse;

  public NotProperRequestException(String message, Response sxAPIResponse) {
    super(message);
    this.sxAPIResponse = sxAPIResponse;
  }

  public NotProperRequestException(Throwable cause, Response sxAPIResponse) {
    super(cause);
    this.sxAPIResponse = sxAPIResponse;
  }

  public NotProperRequestException(String message, Throwable throwable, Response sxAPIResponse) {
    super(message, throwable);
    this.sxAPIResponse = sxAPIResponse;
  }

  public Response getOriginalSXResponse() {
    return this.sxAPIResponse;
  }
}
