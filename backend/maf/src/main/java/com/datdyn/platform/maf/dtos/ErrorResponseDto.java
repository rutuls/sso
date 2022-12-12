package com.datdyn.platform.maf.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
  String uuid;
  String message;
  List<FieldConstraintErrorDto> errors;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class FieldConstraintErrorDto {
    String field;
    String message;
  }
  
  public ErrorResponseDto(String message) {
    this.message = message;
  }
}
