package com.zoytech.winwine.webapp.controller.http.api.carddecks.mapper;

import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.PostCardDecksReqBody;
import com.zoytech.winwine.webapp.features.carddecks.models.CardDeckModel;
import com.zoytech.winwine.webapp.features.cards.model.CardModel;
import com.zoytech.winwine.webapp.features.cards.model.CreateCardModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.var;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.util.CollectionUtils;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface CardDecksHttpMapper {

  CardDecksHttpMapper INSTANCE = Mappers.getMapper(CardDecksHttpMapper.class);

  CardDeckModel mapRequest(PostCardDecksReqBody request);

  CardDeckModel map(CardDeckModel model);

  CreateCardModel map(CardModel model);

  default List<CreateCardModel> map(List<CardModel> models) {
    if (CollectionUtils.isEmpty(models)) {
      return new ArrayList<>();
    }
    return models.stream().map(this::map).collect(Collectors.toList());
  }

  default CardDeckModel map(CardDeckModel model, List<CardModel> cards) {
    var result = map(model);
    result.setPreviewCards(cards);
    return result;
  }
}
