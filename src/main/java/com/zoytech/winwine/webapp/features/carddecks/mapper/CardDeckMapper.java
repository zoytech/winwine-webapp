package com.zoytech.winwine.webapp.features.carddecks.mapper;

import com.zoytech.winwine.webapp.features.carddecks.entity.CardDeckEntity;
import com.zoytech.winwine.webapp.features.carddecks.models.CardDeckModel;
import java.util.List;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface CardDeckMapper {

  CardDeckMapper INSTANCE = Mappers.getMapper(CardDeckMapper.class);

  CardDeckEntity fromModel(CardDeckModel model);

  List<CardDeckEntity> fromModels(List<CardDeckModel> models);

  CardDeckModel fromEntity(CardDeckEntity entity);
  List<CardDeckModel> fromEntities(List<CardDeckEntity> entities);
}
