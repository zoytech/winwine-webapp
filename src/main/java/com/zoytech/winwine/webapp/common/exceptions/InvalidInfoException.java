package com.zoytech.winwine.webapp.common.exceptions;

import com.zoytech.winwine.webapp.common.enumerations.ResponseCode;

public class InvalidInfoException extends BaseCodeException {

  public InvalidInfoException(ResponseCode code) {
    super(code);
  }
}
