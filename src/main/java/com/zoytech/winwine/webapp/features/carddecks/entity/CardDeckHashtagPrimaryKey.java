package com.zoytech.winwine.webapp.features.carddecks.entity;


import java.io.Serializable;
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
public class CardDeckHashtagPrimaryKey  implements Serializable {
  private String cardDeckId;
  private String hashtagId;
}
