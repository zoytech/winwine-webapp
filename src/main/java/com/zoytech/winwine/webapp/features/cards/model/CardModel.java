package com.zoytech.winwine.webapp.features.cards.model;


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
public class CardModel {

  private String cardId;
  private String cardDeckId;
  private String cardTitle;
  private String cardDescription;
  private String cardImage;


}
