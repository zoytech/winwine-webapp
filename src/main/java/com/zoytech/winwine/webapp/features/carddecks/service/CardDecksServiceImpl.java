package com.zoytech.winwine.webapp.features.carddecks.service;

import com.zoytech.winwine.webapp.common.utils.JsonUtils;
import com.zoytech.winwine.webapp.features.carddecks.mapper.CardDeckMapper;
import com.zoytech.winwine.webapp.features.carddecks.models.CardDeckModel;
import com.zoytech.winwine.webapp.features.carddecks.repository.CardDeckRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CardDecksServiceImpl implements CardDecksService {

  @Autowired
  private CardDeckRepository cardDeckRepository;

  @Override
  public CardDeckModel createCardDeck(CardDeckModel cardDeckModel) {
    var entity = cardDeckRepository.save(CardDeckMapper.INSTANCE.fromModel(cardDeckModel));
    log.info("CardDecksServiceImpl-createCardDeck entity={}", JsonUtils.json(entity));
    return CardDeckMapper.INSTANCE.fromEntity(entity);
  }

  @Override
  public CardDeckModel getCardDeckById(String cardDeckId) {
    var optional = cardDeckRepository.findById(cardDeckId);
    if (optional.isPresent()) {
      var entity = optional.get();
      log.info("CardDecksServiceImpl-createCardDeck entity={}", JsonUtils.json(entity));
      return CardDeckMapper.INSTANCE.fromEntity(entity);
    } else {
      return null;
    }
  }
}
