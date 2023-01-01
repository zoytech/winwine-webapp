package com.zoytech.winwine.webapp.features.hashtags.services;

import com.zoytech.winwine.webapp.features.hashtags.model.CreateHashtagModel;
import com.zoytech.winwine.webapp.features.hashtags.model.HashtagModel;
import java.util.List;

public interface HashtagService {

  boolean isExist(String hashtagId);

  List<HashtagModel> findAll();


  HashtagModel save(CreateHashtagModel createHashtagModel);

  List<HashtagModel> saveAll(String cardDeckId, List<CreateHashtagModel> createHashtagModel);
}
