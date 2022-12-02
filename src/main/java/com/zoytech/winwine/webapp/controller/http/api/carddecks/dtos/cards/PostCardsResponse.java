package com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.cards;

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
public class PostCardsResponse implements Serializable {

  PostCardsResponse.Data data;

  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static final class Data {

    private String cardDeckName;
    private String cardDeckDescription;
    private Set<String> hashTags;
  }
}
