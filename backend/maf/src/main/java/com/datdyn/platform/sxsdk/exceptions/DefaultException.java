package com.datdyn.platform.sxsdk.exceptions;

import javax.ws.rs.core.Response;

public class DefaultException extends RuntimeException {
  private Response sxAPIResponse;

  public DefaultException(String message, Response sxAPIResponse) {
    super(message);
    this.sxAPIResponse = sxAPIResponse;
  }

  public DefaultException(Throwable cause, Response sxAPIResponse) {
    super(cause);
    this.sxAPIResponse = sxAPIResponse;
  }

  public DefaultException(String message, Throwable throwable, Response sxAPIResponse) {
    super(message, throwable);
    this.sxAPIResponse = sxAPIResponse;
  }

  public Response getOriginalSXResponse() {
    return this.sxAPIResponse;
  }
}
