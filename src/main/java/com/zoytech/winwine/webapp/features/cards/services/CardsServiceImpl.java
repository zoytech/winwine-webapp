package com.zoytech.winwine.webapp.features.cards.services;

import static com.zoytech.winwine.webapp.common.utils.JsonUtils.json;

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

  @Override
  public List<CardModel> findAll() {
    return CardMapper.INSTANCE.fromEntities(repository.findAll());
  }

  public CardModel save(String cardDeckId, CreateCardModel createCardModel) {
    var requestEntity = CardMapper.INSTANCE.fromRequest(cardDeckId, createCardModel);
    var result = repository.save(requestEntity);
    return CardMapper.INSTANCE.fromEntity(result);
  }

  @Override
  public List<CardModel> saveAll(String cardDeckId, List<CreateCardModel> createCardModels) {
    if (!CollectionUtils.isEmpty(createCardModels)) {
      var requestEntities = CardMapper.INSTANCE.fromRequests(cardDeckId, createCardModels);
      var result = repository.saveAll(requestEntities);
      log.info("CardsServiceImpl-saveAll results={}", json(result));
      return CardMapper.INSTANCE.fromEntities(requestEntities);
    }
    return new ArrayList<>();
  }

  @Override
  public List<CardModel> getCardsByCardDeckId(String cardDeckId) {
    return CardMapper.INSTANCE.fromEntities(repository.findAllByCardDeckId(cardDeckId));
  }
}
