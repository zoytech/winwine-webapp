package com.zoytech.winwine.webapp.common.utils;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class HttpUtils {

  private static final String USER_AGENT_HEADER = "User-Agent";

  private static final String ZLP_AGENT = "zalopayclient";
  private static final String ZALO_AGENT = "zalo";

  public static String getUserAgent(HttpServletRequest request) {
    return StringUtils.hasLength(request.getHeader(USER_AGENT_HEADER))
        ? request.getHeader(USER_AGENT_HEADER)
        : "Missing User-Agent";
  }

  public static boolean isInZLP(String userAgent) {
    return StringUtils.hasLength(userAgent) && userAgent.toLowerCase().contains(ZLP_AGENT);
  }

  public static boolean isInZalo(String userAgent) {
    return StringUtils.hasLength(userAgent) && userAgent.toLowerCase().contains(ZALO_AGENT) && !isInZLP(userAgent);
  }

  public static String getSearchParams(HttpServletRequest request) {
    return request.getQueryString() == null ? "" : request.getQueryString();
  }

  public static boolean isRedirectLinkMatchWhitelist(String link, String pattern) {
    Pattern whitelistPattern = Pattern.compile(pattern);
    return whitelistPattern.matcher(link).matches();
  }

}
