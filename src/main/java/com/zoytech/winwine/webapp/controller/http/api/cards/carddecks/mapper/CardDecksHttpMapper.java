package com.zoytech.winwine.webapp.controller.http.api.cards.carddecks.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface CardDecksHttpMapper {

  CardDecksHttpMapper INSTANCE = Mappers.getMapper(CardDecksHttpMapper.class);

}