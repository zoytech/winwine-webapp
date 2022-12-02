package com.zoytech.winwine.webapp.features.carddecks.service;

import com.zoytech.winwine.webapp.features.carddecks.models.CardDeckModel;

public interface CardDecksService {

  CardDeckModel createCardDeck(CardDeckModel cardDeckModel);

  CardDeckModel getCardDeckById(String cardDeckId);
}
