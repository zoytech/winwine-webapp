package com.zoytech.winwine.webapp.features.carddecks.models;


import com.zoytech.winwine.webapp.features.cards.model.CardModel;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
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

  private String cardDeckImage;
  private String cardDeckDescription;

  private int numberOfCards;

  @Default
  private List<CardModel> previewCards = new ArrayList<>();

//  private Integer numberOfCards;

//  @Default
//  private List<CardModel> cards = new ArrayList<>();

}
