package com.zoytech.winwine.webapp.features.carddecks.models;


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
public class CardDeckModel {

  private String cardDeckId;
  private String ownerId;
  private String cardDeckName;
  private String cardDeckDescription;

//  private Integer numberOfCards;

//  @Default
//  private List<CardModel> cards = new ArrayList<>();

}
