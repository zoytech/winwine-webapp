package com.zoytech.winwine.webapp.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.JsonFormat.TypeRegistry;
import java.lang.reflect.Type;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JsonUtils {
  private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
  private static final JsonFormat.Parser PARSER = JsonFormat.parser().ignoringUnknownFields();
  private static final JsonFormat.Printer PRINTER = JsonFormat.printer().includingDefaultValueFields().omittingInsignificantWhitespace();
  private static final JsonFormat.Printer PRINTER_NO_DEFAULT = JsonFormat.printer().omittingInsignificantWhitespace();
  private static final Gson GSON = (new GsonBuilder()).disableHtmlEscaping().create();

  public static String json(Object obj) {
    if (obj == null) {
      return "";
    }
    return obj instanceof MessageOrBuilder ? print((MessageOrBuilder)obj) : printGson(obj);
  }

  public static <B extends Message.Builder, P extends Message> P parse(String json, B protoBuilder) {
    try {
      PARSER.merge(json, protoBuilder);
      return (P) protoBuilder.build();
    } catch (InvalidProtocolBufferException var3) {
      throw new IllegalArgumentException("Error when parsing json from string:" + json, var3);
    }
  }

  public static String print(MessageOrBuilder proto) {
    try {
      return PRINTER.usingTypeRegistry(TypeRegistry.newBuilder().add(proto.getDescriptorForType()).build()).print(proto);
    } catch (InvalidProtocolBufferException var2) {
      throw new IllegalArgumentException("Error when parsing json to string", var2);
    }
  }

  public static String printJsonNoDefaultValues(MessageOrBuilder proto) {
    try {
      return PRINTER_NO_DEFAULT.print(proto);
    } catch (InvalidProtocolBufferException var2) {
      throw new IllegalArgumentException("Error when parsing json to string", var2);
    }
  }

  public static String printGson(Object object) {
    return GSON.toJson(object);
  }

  public static <T> T parseGson(String json, Class<T> clazz) {
    return GSON.fromJson(json, clazz);
  }


  private JsonUtils() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
}
