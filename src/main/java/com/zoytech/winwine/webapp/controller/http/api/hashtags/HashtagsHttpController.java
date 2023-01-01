package com.zoytech.winwine.webapp.controller.http.api.hashtags;

import com.zoytech.winwine.webapp.controller.http.api.hashtags.dtos.GetHashtagsResponse;
import com.zoytech.winwine.webapp.controller.http.constants.HttpPathConstants;
import com.zoytech.winwine.webapp.features.hashtags.model.HashtagModel;
import com.zoytech.winwine.webapp.features.hashtags.services.HashtagService;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("${http.api.prefix}" + HttpPathConstants.HASHTAGS)
public class HashtagsHttpController {

  @Autowired
  private HashtagService hashtagService;

  @GetMapping
  public ResponseEntity<GetHashtagsResponse> getHashtags() {
    return new ResponseEntity<>(
        GetHashtagsResponse.builder()
            .data(hashtagService.findAll().stream().map(HashtagModel::getHashtagId).collect(Collectors.toList()))
            .build(),
        HttpStatus.OK);
  }


}
