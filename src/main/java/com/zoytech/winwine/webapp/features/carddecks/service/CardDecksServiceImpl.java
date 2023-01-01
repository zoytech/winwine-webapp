package com.zoytech.winwine.webapp.features.carddecks.service;

import com.zoytech.winwine.webapp.common.enumerations.ResponseCode;
import com.zoytech.winwine.webapp.common.exceptions.InvalidInfoException;
import com.zoytech.winwine.webapp.common.utils.JsonUtils;
import com.zoytech.winwine.webapp.features.carddecks.entity.CardDeckHashtagEntity;
import com.zoytech.winwine.webapp.features.carddecks.mapper.CardDeckMapper;
import com.zoytech.winwine.webapp.features.carddecks.models.CardDeckModel;
import com.zoytech.winwine.webapp.features.carddecks.repository.CardDeckHashtagRepository;
import com.zoytech.winwine.webapp.features.carddecks.repository.CardDeckRepository;
import com.zoytech.winwine.webapp.features.hashtags.services.HashtagService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class CardDecksServiceImpl implements CardDecksService {

  @Autowired
  private CardDeckRepository repository;

  @Autowired
  private HashtagService hashtagService;

  @Autowired
  private CardDeckHashtagRepository cardDeckHashtagRepository;

  @Override
  public List<CardDeckModel> findAll() {

    var result = CardDeckMapper.INSTANCE.fromEntities(repository.findAll());
    result.forEach(cardDeckModel -> {
      cardDeckModel.setHashtags(
          cardDeckHashtagRepository.findByCardDeckId(cardDeckModel.getCardDeckId()).stream().map(
              CardDeckHashtagEntity::getHashtagId).collect(Collectors.toList()));
    });
    return result;
  }

  public CardDeckModel save(CardDeckModel cardDeckModel) {
    var requestEntity = CardDeckMapper.INSTANCE.fromModel(cardDeckModel);
    requestEntity.setCardDeckId(UUID.randomUUID().toString());
    requestEntity.setOwnerId("0");
    requestEntity.setNumberOfCards(0);
    var result = repository.save(requestEntity);

    if (!CollectionUtils.isEmpty(cardDeckModel.getHashtags())) {
      cardDeckModel.getHashtags().forEach(hashtag -> {
            if (!hashtagService.isExist(hashtag)) {
              throw new InvalidInfoException(ResponseCode.HASHTAG_NOT_FOUND);
            }
            cardDeckHashtagRepository.save(CardDeckHashtagEntity.builder()
                .cardDeckId(result.getCardDeckId())
                .hashtagId(hashtag)
                .build());
          }
      );
    }

    log.info("CardDecksServiceImpl-createCardDeck entity={}", JsonUtils.json(result));
    return CardDeckMapper.INSTANCE.fromEntity(result);
  }

  @Override
  public CardDeckModel getByCardDeckId(String cardDeckId) {
    var optional = repository.findById(cardDeckId);
    if (optional.isPresent()) {
      var entity = optional.get();
      log.info("CardDecksServiceImpl-createCardDeck entity={}", JsonUtils.json(entity));
      var model = CardDeckMapper.INSTANCE.fromEntity(entity);
      model.setHashtags(
          cardDeckHashtagRepository.findByCardDeckId(model.getCardDeckId()).stream().map(
              CardDeckHashtagEntity::getHashtagId).collect(Collectors.toList()));
      return model;
    } else {
      return null;
    }
  }

  @Override
  public void updateNumberOfCards(String cardDeckId, int numberOfCards) {
    repository.updateNumberOfCards(cardDeckId, numberOfCards);
  }
}
