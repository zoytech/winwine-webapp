package com.zoytech.winwine.webapp.common.configurations;

import com.zoytech.winwine.webapp.common.enumerations.AppEnvironment;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "common")
public class CommonConfig {

  @NotNull
  private AppEnvironment appEnv;

  @NotBlank
  private String campaignCode;
}
