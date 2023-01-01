package com.zoytech.winwine.webapp.features.carddecks.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CardDeckHashtagPrimaryKey {
  private String cardDeckId;
  private String hashtagId;
}
