package com.zoytech.winwine.webapp.features.cards.services;

import static com.zoytech.winwine.webapp.common.utils.JsonUtils.json;

import com.zoytech.winwine.webapp.features.carddecks.service.CardDecksService;
import com.zoytech.winwine.webapp.features.cards.mapper.CardMapper;
import com.zoytech.winwine.webapp.features.cards.model.CardModel;
import com.zoytech.winwine.webapp.features.cards.model.CreateCardModel;
import com.zoytech.winwine.webapp.features.cards.repository.CardRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class CardsServiceImpl implements CardsService {

  @Autowired
  private CardRepository repository;

  @Autowired
  private CardDecksService cardDecksService;

  @Override
  public List<CardModel> findAll(String cardDeckId) {
    return CardMapper.INSTANCE.fromEntities(repository.findByCardDeckId(cardDeckId));
  }

  @Override
  public List<CardModel> findPreview(String cardDeckId) {
    var cards = findAll(cardDeckId);
    return cards.subList(0, Math.min(3, cards.size()));
  }

  public CardModel save(String cardDeckId, CreateCardModel createCardModel) {
    var requestEntity = CardMapper.INSTANCE.fromRequest(cardDeckId, createCardModel);
    var entities = repository.save(requestEntity);
    cardDecksService.updateNumberOfCards(cardDeckId, findAll(cardDeckId).size());
    return CardMapper.INSTANCE.fromEntity(entities);
  }

  @Override
  public List<CardModel> saveAll(String cardDeckId, List<CreateCardModel> createCardModels) {
    if (!CollectionUtils.isEmpty(createCardModels)) {
      var requestEntities = CardMapper.INSTANCE.fromRequests(cardDeckId, createCardModels);
      var entities = repository.saveAll(requestEntities);
      log.info("CardsServiceImpl-saveAll entities={}", json(entities));
      cardDecksService.updateNumberOfCards(cardDeckId, findAll(cardDeckId).size());
      return CardMapper.INSTANCE.fromEntities(requestEntities);
    }
    return new ArrayList<>();
  }


}
