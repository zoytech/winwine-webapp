package com.zoytech.winwine.webapp.features.carddecks.service;

import com.zoytech.winwine.webapp.features.carddecks.models.CardDeckModel;
import java.util.List;

public interface CardDecksService {


  List<CardDeckModel> findAll();

  CardDeckModel save(CardDeckModel cardDeckModel);

  CardDeckModel getByCardDeckId(String cardDeckId);
}
