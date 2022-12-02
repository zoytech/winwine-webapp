package com.zoytech.winwine.webapp.controller.http.configurations;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "http.api")
public class HttpAPIConfig {

  private String prefix;
  private Set<Long> allowedUserIdDev;
}
