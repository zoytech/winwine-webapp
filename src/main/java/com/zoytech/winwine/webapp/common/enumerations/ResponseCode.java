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

  USER_HIGH_RISK(-1, "Exception..."),
  LIMIT_REACHED(-2, "Exception..."),

  // INVALID
  INVALID_CAMPAIGN_CODE(-10, "Exception..."),
  INVALID_USER_ID(-11, "Exception..."),
  INVALID_USER_TOKEN(-12, "Exception..."),
  INVALID_ZALO_ID(-13, "Exception..."),
  INVALID_USER_INFO_FIELD_NAME(-14, "Exception..."),
  INVALID_TASK_TYPE_BY_TASK_NAME(-15, "Exception..."),
  INVALID_TASK_BY_EXTRA_TRIGGER(-16, "Exception..."),
  INVALID_TASK_FOR_USER(-17, "Exception..."),
  INVALID_USER_REWARD_TYPE(-18, "Exception..."),
  INVALID_SHARE_KEY(-19, "Exception..."),
  INVALID_REWARD_NAME_TO_DELIVER(-20, "Exception..."),
  INVALID_REQUEST_TIME(-21, "Exception..."),
  INVALID_USER_COUNTER(-22, "Exception..."),
  INVALID_GAME_TYPE(-23, "Exception..."),
  INVALID_USER_SEGMENT(-24, "Exception..."),
  INVALID_VPOINTS_TO_EVAL(-25, "Exception..."),

  FAILED_TO_GET_USER_SCHEME_INFO(-50, "Exception..."),
  FAILED_TO_GET_USER_ASSETS_INFO(-51, "Exception..."),
  FAILED_TO_GET_QUICK_TASK_INFO(-52, "Exception..."),
  FAILED_TO_UPDATE_USER_COUNTER(-60, "Exception..."),
  FAILED_TO_CALCULATE_GAME_REWARDS(-70, "Exception..."),
  INVALID_USER_TASK_SEGMENT(-71,"Exception..."),
  INVALID_TASK_SOURCE_TYPE(-72, "Exception..."),

  FAILED_TO_GET_GAME_SCENES(-80, "Exception..."),
  FAILED_TO_GET_SLX_STATUS(-95, "Exception..."),
  FAILED_TO_GIVE_SLX(-96, "Exception..."),

  USER_NOT_JOINED(-100, "Exception..."),
  USER_NOT_ENOUGH_TICKET(-101, "Exception..."),
  USER_HAS_REACH_LIMIT(-102, "Exception..."),

  ALREADY_INIT_USER(-200, "Exception..."),
  ALREADY_DONE_TASK(-201, "Exception..."),
  ALREADY_HAD_SLX(-202, "Exception..."),

  // EXTERNAL_SERVICES
  // ZPI
  ZPI_CALL_FAILED(-800, "Exception..."),
  // RISK
  RISK_CALL_FAILED(-810, "Exception..."),
  RISK_RESPONSE_FAILED(-811, "Exception..."),
  // RULE
  RULE_RESPONSE_FAILED(-811, "Exception..."),
  // LAMBDA
  CALL_LAMBDA_GET_TICKET_FAILED(-820, "Exception..."),
  CALL_LAMBDA_PRODUCE_TICKET_FAILED(-821, "Exception..."),
  CALL_LAMBDA_CONSUME_TICKET_FAILED(-822, "Exception..."),
  CALL_LAMBDA_GET_COIN_FAILED(-823, "Exception..."),
  CALL_LAMBDA_PRODUCE_COIN_FAILED(-824, "Exception..."),
  CALL_LAMBDA_REDEEM_COIN_FAILED(-825, "Exception..."),
  CALL_LAMBDA_CONSUME_ITEM_FAILED(-826, "Exception..."),
  CALL_LAMBDA_GET_STORE_FAILED(-827, "Exception..."),
  CALL_LAMBDA_PURCHASE_ITEM_FAILED(-828, "Exception..."),
  CALL_LAMBDA_GET_TASK_FAILED(-829, "Exception..."),
  CALL_LAMBDA_GET_TASK_BY_NAME_FAILED(-830, "Exception..."),
  CALL_LAMBDA_DO_TASK_FAILED(-831, "Exception..."),
  CALL_LAMBDA_DO_P2P_FAILED(-832, "Exception..."),
  CALL_LAMBDA_REGISTER_REFERRAL_FAILED(-833, "Exception..."),
  CALL_LAMBDA_DO_REFERRAL_FAILED(-834, "Exception..."),
  CALL_LAMBDA_GET_STAMP_COLLECTION_FAILED(-835, "Exception..."),
  CALL_LAMBDA_GET_STAMP_REDEMPTION_FAILED(-836, "Exception..."),
  CALL_LAMBDA_REDEEM_STAMP_FAILED(-837, "Exception..."),
  CALL_LAMBDA_CREATE_GIVEN_STAMP_FAILED(-838, "Exception..."),
  CALL_LAMBDA_ACCEPT_GIVEN_STAMP_FAILED(-839, "Exception..."),
  CALL_LAMBDA_VALIDATE_GIVEN_STAMP_FAILED(-840, "Exception..."),
  CALL_LAMBDA_CREATE_REQUESTED_STAMP_FAILED(-841, "Exception..."),
  CALL_LAMBDA_ACCEPT_REQUESTED_STAMP_FAILED(-842, "Exception..."),
  CALL_LAMBDA_VALIDATE_REQUESTED_STAMP_FAILED(-843, "Exception..."),
  CALL_LAMBDA_GET_REWARD_FAILED(-844, "Exception..."),
  CALL_LAMBDA_CALCULATE_REWARDS_FAILED(-845, "Exception..."),
  CALL_LAMBDA_DELIVER_REWARDS_FAILED(-846, "Exception..."),
  CALL_LAMBDA_REVOKE_REWARDS_FAILED(-847, "Exception..."),
  CALL_LAMBDA_ISSUE_REWARD_FAILED(-848, "Exception..."),
  CALL_LAMBDA_ISSUE_REWARDS_FAILED(-849, "Exception..."),
  CALL_LAMBDA_ISSUE_FINAL_REWARD_FAILED(-850, "Exception..."),
  CALL_LAMBDA_GET_TASKS_BY_NAMES_FAILED(-851, "Exception..."),
  // SHARING
  CALL_SHARING_GET_SHARE_LINK_FAILED(-870, "Exception..."),
  CALL_SHARING_GET_SHARE_DATA_FAILED(-871, "Exception..."),
  CALL_SHARING_CREATE_SHARE_LINK_FAILED(-872, "Exception..."),
  // NOTIFICATION
  CALL_NOTIFICATION_SEND_Z_INSTANT_MESSAGE_FAILED(-880, "Exception..."),
  CALL_NOTIFICATION_SEND_DIRECT_MESSAGE_FAILED(-881, "Exception..."),
  //
  SLX_GET_PACKS_CALL_FAILED(-890, "Exception..."),
  SLX_GET_PACKS_RESPONSE_FAILED(-891, "Exception..."),

  // GAME
  USER_ALREADY_IN_GAME(-700, "Exception..."),
  INVALID_ACTION_LOG(-701, "Exception..."),
  GAME_ALREADY_RECORDED(-702, "Exception..."),
  INVALID_GAME_STATUS(-703, "Exception..."),
  INVALID_GAME_ID(-704, "Exception..."),
  INVALID_GAME_MAP(-705, "Exception..."),
  USE_BOOSTER_FAILED(-706, "Exception..."),
  INVALID_SCENE_TYPE(-707, "Exception..."),
  INVALID_SCENE_TIME(-708, "Exception..."),
  INVALID_CREATE_REQUEST(-707, "Exception..."),
  INVALID_USED_BOOSTER(-708, "Exception..."),
  INVALID_RECORD_DURATION(-709, "Exception..."),

  DECRYPT_FAILED(-850, "Exception..."),
  INVALID_SECURE_TOKEN(-799, "Exception..."),
  INVALID_RECORD_ENTITY(-710, "Exception..."),
  INVALID_RECORD_PLAYER_SHOT(-711, "Exception..."),
  INVALID_RECORD_PLAYER_STATUS(-712, "Exception..."),
  INVALID_RECORD(-720, "INVALID_RECORD"),
  INVALID_GAME_TIME_OUT(-713, "Exception..."),


  HANDLED_TASK_SOURCE_TRANS(-750, "Exception..."),
  //SESSION
  SESSION_NOT_FOUND(-800, "SESSION_NOT_FOUND"),
  INVALID_SESSION_TIME(-801, "INVALID_SESSION_TIME"),
  // VALIDATE
  CAMPAIGN_NOT_STARTED(-898, "CAMPAIGN_NOT_STARTED"),
  CAMPAIGN_HAS_ENDED(-899, "CAMPAIGN_HAS_ENDED"),

  // QUIZ
  CALL_QUIZ_FIND_MATCH_EXCEPTION(-900, "CALL_QUIZ_FIND_MATCH_EXCEPTION"),
  CALL_QUIZ_GET_MATCH_EXCEPTION(-901, "CALL_QUIZ_GET_MATCH_EXCEPTION"),

  FIND_MATCH_FAILED(-902,"FIND_MATCH_FAILED"),
  MATCH_NOT_FOUND(-903,"MATCH_NOT_FOUND"),
  MATCH_RESULT_NOT_FOUND(-904,"MATCH_RESULT_NOT_FOUND"),



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
