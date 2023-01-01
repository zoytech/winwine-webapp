package com.zoytech.winwine.webapp.common.enumerations;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(enumAsRef = true)
public enum ResponseCode {

  SUCCESS(1, "Success"),

  EXCEPTION(0, "Exception..."),

  CARD_DECK_NOT_FOUND(-1, "CARD_DECK_NOT_FOUND"),

  CARD_NOT_FOUND(-2, "CARD_NOT_FOUND"),

  HASHTAG_NOT_FOUND(-3, "HASHTAG_NOT_FOUND"),

  // SYSTEM
  SYSTEM_LOCK_REACHED_LIMIT(-999, "Exception..."),

  SYSTEM_BUSY(-999, "System busy! Please try again later..."),
  ;

  private final int status;
  private final String message;

  @JsonValue
  public String getMessage() {
    return this.message;
  }

  @JsonValue
  public int getStatus() {
    return this.status;
  }

}
