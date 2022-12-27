package com.zoytech.winwine.webapp.features.hashtags.services;

import com.zoytech.winwine.webapp.features.hashtags.model.HashtagModel;
import com.zoytech.winwine.webapp.features.hashtags.model.CreateHashtagModel;
import java.util.List;

public interface HashtagService {


  List<HashtagModel> findAll(String cardDeckId);

  HashtagModel save(String cardDeckId, CreateHashtagModel createHashtagModel);

  List<HashtagModel> saveAll(String cardDeckId, List<CreateHashtagModel> createHashtagModel);
}
