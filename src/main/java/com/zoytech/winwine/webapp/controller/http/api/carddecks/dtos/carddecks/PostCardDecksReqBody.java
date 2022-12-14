package com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks;

import java.io.Serializable;
import java.util.List;
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
public class PostCardDecksReqBody implements Serializable {
  private String cardDeckName;

  private String cardDeckImage;
  private String cardDeckDescription;

  private List<String> hashtags;
}
