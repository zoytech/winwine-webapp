package com.zoytech.winwine.webapp.features.carddecks.service;

import com.zoytech.winwine.webapp.common.utils.JsonUtils;
import com.zoytech.winwine.webapp.features.carddecks.mapper.CardDeckMapper;
import com.zoytech.winwine.webapp.features.carddecks.models.CardDeckModel;
import com.zoytech.winwine.webapp.features.carddecks.repository.CardDeckRepository;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CardDecksServiceImpl implements CardDecksService {

  @Autowired
  private CardDeckRepository repository;



  @Override
  public List<CardDeckModel> findAll() {
    return CardDeckMapper.INSTANCE.fromEntities(repository.findAll());
  }

  public CardDeckModel save(CardDeckModel cardDeckModel) {
    var requestEntity  = CardDeckMapper.INSTANCE.fromModel(cardDeckModel);
    requestEntity.setCardDeckId(UUID.randomUUID().toString());
    requestEntity.setOwnerId("0");
    requestEntity.setNumberOfCards(0);
    var result = repository.save(requestEntity);
    log.info("CardDecksServiceImpl-createCardDeck entity={}", JsonUtils.json(result));
    return CardDeckMapper.INSTANCE.fromEntity(result);
  }

  @Override
  public CardDeckModel getByCardDeckId(String cardDeckId) {
    var optional = repository.findById(cardDeckId);
    if (optional.isPresent()) {
      var entity = optional.get();
      log.info("CardDecksServiceImpl-createCardDeck entity={}", JsonUtils.json(entity));
      return CardDeckMapper.INSTANCE.fromEntity(entity);
    } else {
      return null;
    }
  }
}
