package com.zoytech.winwine.webapp.common.utils;


import static com.zoytech.winwine.webapp.common.constants.AppConstants.DELIMITER;
import static com.zoytech.winwine.webapp.common.constants.AppConstants.SPLITTER;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;


@Slf4j
public class AppUtils {

  private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##"); // use to beautify number before return

  public static String getCurrentOrDefault(String currentValue, String defaultValue) {
    return !StringUtils.isEmpty(currentValue)
        ? currentValue
        : defaultValue;
  }

  public static String joinKeysWithDelimiter(List<String> keys) {
    if (keys.isEmpty()) {
      return "";
    }

    return keys.stream()
        .map(key -> StringUtils.isEmpty(key) ? "NULL" : key)
        .collect(Collectors.joining(DELIMITER));
  }

  public static String joinKeysWithDelimiter(String... keys) {
    if (keys.length == 0) {
      return "";
    }

    StringJoiner joinerKeys = new StringJoiner(DELIMITER);
    for (String keyUnit : keys) {
      if (StringUtils.isEmpty(keyUnit)) {
        joinerKeys.add("NULL");
      } else {
        joinerKeys.add(keyUnit);
      }
    }
    return joinerKeys.toString();
  }

  public static String toVNDCurrencyString(long value) {
    return NumberFormat.getNumberInstance(Locale.US)
        .format(value)
        .replace(',', '.') + "đ";
  }

  public static String replaceLast(String text, String regex, String replacement) {
    return text.replaceFirst("(?s)" + regex + "(?!.*?" + regex + ")", replacement);
  }

//  public static String generateGlobalTraceId(long time) {
//    return DateTimeUtils.convertTimestampToPattern(time, "yyyyMM")
//        .concat("-")
//        .concat(UUID.randomUUID().toString());
  //}

  public static String beautifyJoiningContent(List<String> contents) {
    if (CollectionUtils.isEmpty(contents)) {
      return "";
    }
    return AppUtils.replaceLast(
        contents.stream().filter(content -> !StringUtils.isEmpty(content)).collect(
            Collectors.joining("; ")), "; ", " và ");
  }


  public static float roundFloat(float number) {
    return Float.parseFloat(DECIMAL_FORMAT.format(number));
  }

  public static int randomInt(int minValue, int maxValue) {
    return (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
  }

  public static float randomFloat(float rawMin, float rawMax) {
    if (rawMin > rawMax) {
      float average = (rawMax + rawMin) / 2;
      log.warn(
          "AppUtils-randomFloat rawMin={} rawMax={}: minValue > maxValue, in this case randomFloat return average={}",
          rawMin, rawMax, average);
      return average;
    }
    float deltaMin = 0;
    float deltaMax = 0;
    if (rawMin < 0) {
      deltaMin = -rawMin;
    }
    if (rawMax < 0) {
      deltaMax = -rawMax;
    }
    float fixingDelta = Math.max(deltaMax, deltaMin);
    return RandomUtils.nextFloat(rawMin + fixingDelta, rawMax + fixingDelta) - fixingDelta;

  }

  public static String convertListToString(List<String> list) {
    return String.join(SPLITTER, list);
  }

  public static List<String> convertStringToList(String s) {
    if (StringUtils.isEmpty(s)) {
      return new ArrayList<>();
    }
    return Arrays.stream(s.split(SPLITTER)).collect(Collectors.toList());
  }
}