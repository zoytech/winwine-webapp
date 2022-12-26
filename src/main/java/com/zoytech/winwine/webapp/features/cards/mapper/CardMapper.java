package com.zoytech.winwine.webapp.features.cards.mapper;

import com.zoytech.winwine.webapp.features.cards.entity.CardEntity;
import com.zoytech.winwine.webapp.features.cards.model.CardModel;
import com.zoytech.winwine.webapp.features.cards.model.CreateCardModel;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.var;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface CardMapper {

  CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

  CardEntity fromRequest(CreateCardModel model);


  default CardEntity fromRequest(String cardDeckId, CreateCardModel model) {
    var requestEntity = CardMapper.INSTANCE.fromRequest(model);
    requestEntity.setCardDeckId(cardDeckId);
    requestEntity.setCardId(UUID.randomUUID().toString());
    return requestEntity;
  }

  default List<CardEntity> fromRequests(String cardDeckId, List<CreateCardModel> models) {
    return models.stream()
        .map(model -> CardMapper.INSTANCE.fromRequest(cardDeckId, model))
        .collect(Collectors.toList());
  }

  CardEntity fromModel(CardModel model);

  List<CardEntity> fromModels(List<CardModel> models);

  CardModel fromEntity(CardEntity entity);

  List<CardModel> fromEntities(List<CardEntity> entities);
}
