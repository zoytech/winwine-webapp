package com.zoytech.winwine.webapp.features.hashtags.services;

import static com.zoytech.winwine.webapp.common.utils.JsonUtils.json;

import com.zoytech.winwine.webapp.features.hashtags.mapper.HashtagMapper;
import com.zoytech.winwine.webapp.features.hashtags.model.CreateHashtagModel;
import com.zoytech.winwine.webapp.features.hashtags.model.HashtagModel;
import com.zoytech.winwine.webapp.features.hashtags.repository.HashtagRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class HashtagServiceImpl implements HashtagService {

  @Autowired
  private HashtagRepository repository;

  private static final Map<String, HashtagModel> hashtagMap = new HashMap<>();

  @Override
  public boolean isExist(String hashtagId) {
    checkAndWarmUp();
    return hashtagMap.containsKey(hashtagId);
  }

  @Override
  public List<HashtagModel> findAll() {
    checkAndWarmUp();
    return new ArrayList<>(hashtagMap.values());
  }

  private void checkAndWarmUp() {
    if (CollectionUtils.isEmpty(hashtagMap)) {
      repository.findAll().forEach((entity) -> {
        var model = HashtagMapper.INSTANCE.fromEntity(entity);
        hashtagMap.put(entity.getHashtagId(), model);
      });
    }
  }

  public HashtagModel save(CreateHashtagModel createHashtagModel) {
    var requestEntity = HashtagMapper.INSTANCE.fromRequest( createHashtagModel);
    var result = repository.save(requestEntity);
    return HashtagMapper.INSTANCE.fromEntity(result);
  }

  @Override
  public List<HashtagModel> saveAll(String cardDeckId, List<CreateHashtagModel> createHashtagModels) {
    if (!CollectionUtils.isEmpty(createHashtagModels)) {
      var requestEntities = HashtagMapper.INSTANCE.fromRequests(cardDeckId, createHashtagModels);
      var result = repository.saveAll(requestEntities);
      log.info("HashtagServiceImpl-saveAll results={}", json(result));
      return HashtagMapper.INSTANCE.fromEntities(requestEntities);
    }
    return new ArrayList<>();
  }

}
