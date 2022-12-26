package com.zoytech.winwine.webapp.controller.http.api.carddecks.mapper;

import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.PostCardDecksReqBody;
import com.zoytech.winwine.webapp.features.carddecks.models.CardDeckModel;
import com.zoytech.winwine.webapp.features.cards.model.CardModel;
import java.util.List;
import lombok.var;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface CardDecksHttpMapper {

  CardDecksHttpMapper INSTANCE = Mappers.getMapper(CardDecksHttpMapper.class);

  CardDeckModel mapRequest(PostCardDecksReqBody request);

  CardDeckModel map(CardDeckModel model);

  default CardDeckModel map(CardDeckModel model, List<CardModel> cards) {
    var result = map(model);
    result.setPreviewCards(cards);
    return result;
  }
}
