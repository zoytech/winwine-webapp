package com.zoytech.winwine.webapp.controller.http.api.carddecks.mapper;

import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.PostCardDecksRequest;
import com.zoytech.winwine.webapp.features.carddecks.models.CardDeckModel;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface CardDecksHttpMapper {

  CardDecksHttpMapper INSTANCE = Mappers.getMapper(CardDecksHttpMapper.class);

  CardDeckModel mapRequest(PostCardDecksRequest request);


}
