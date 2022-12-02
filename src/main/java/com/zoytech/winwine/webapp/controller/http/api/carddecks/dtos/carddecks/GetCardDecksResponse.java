package com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks;

import java.io.Serializable;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class GetCardDecksResponse implements Serializable {

  GetCardDecksResponse.Data data;

  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static final class Data {

    private String cardDeckName;
    private String cardDeckDescription;
    private Set<String> hashTags;
  }
}
