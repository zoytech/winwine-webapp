package com.zoytech.winwine.webapp.common.exceptions;

import com.zoytech.winwine.webapp.common.enumerations.ResponseCode;

public class BaseCodeException extends RuntimeException {

  public BaseCodeException(ResponseCode code) {
    super(code.name());
  }
}
