package com.zoytech.winwine.webapp.features.hashtags.mapper;

import com.zoytech.winwine.webapp.features.hashtags.entity.HashtagEntity;
import com.zoytech.winwine.webapp.features.hashtags.model.HashtagModel;
import com.zoytech.winwine.webapp.features.hashtags.model.CreateHashtagModel;
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
public interface HashtagMapper {

  HashtagMapper INSTANCE = Mappers.getMapper(HashtagMapper.class);

  HashtagEntity fromRequest(CreateHashtagModel model);


  default HashtagEntity fromRequest(String cardDeckId, CreateHashtagModel model) {
    var requestEntity = HashtagMapper.INSTANCE.fromRequest(model);
    requestEntity.setCardDeckId(cardDeckId);
    requestEntity.setCardId(UUID.randomUUID().toString());
    return requestEntity;
  }

  default List<HashtagEntity> fromRequests(String cardDeckId, List<CreateHashtagModel> models) {
    return models.stream()
        .map(model -> HashtagMapper.INSTANCE.fromRequest(cardDeckId, model))
        .collect(Collectors.toList());
  }

  HashtagEntity fromModel(HashtagModel model);

  List<HashtagEntity> fromModels(List<HashtagModel> models);

  HashtagModel fromEntity(HashtagEntity entity);

  List<HashtagModel> fromEntities(List<HashtagEntity> entities);
}
