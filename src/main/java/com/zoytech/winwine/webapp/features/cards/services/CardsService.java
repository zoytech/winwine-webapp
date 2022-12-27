package com.zoytech.winwine.webapp.features.cards.services;

import com.zoytech.winwine.webapp.features.cards.model.CardModel;
import com.zoytech.winwine.webapp.features.cards.model.CreateCardModel;
import java.util.List;

public interface CardsService {


  List<CardModel> findAll(String cardDeckId);

  List<CardModel> findPreview(String cardDeckId);

  CardModel save(String cardDeckId, CreateCardModel createCardModel);

  List<CardModel> saveAll(String cardDeckId, List<CreateCardModel> createCardModel);

}
