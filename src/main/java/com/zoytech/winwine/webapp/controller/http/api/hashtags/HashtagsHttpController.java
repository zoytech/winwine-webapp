package com.zoytech.winwine.webapp.controller.http.api.hashtags;

import com.zoytech.winwine.webapp.controller.http.api.hashtags.dtos.GetHashtagsResponse;
import com.zoytech.winwine.webapp.controller.http.constants.HttpPathConstants;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("${http.api.prefix}" + HttpPathConstants.HASHTAGS)
public class HashtagsHttpController {
  @GetMapping
  public ResponseEntity<GetHashtagsResponse> getHashtags() {
    return new ResponseEntity<>(
        GetHashtagsResponse.builder()
            .data(Arrays.asList("#18+", "#BạnThân", "#MớiQuen", "#TớiBến"))
            .build(),
        HttpStatus.OK);
  }


}
