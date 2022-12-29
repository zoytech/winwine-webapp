package com.zoytech.winwine.webapp.controller.http.api.hashtags.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class GetHashtagsResponse implements Serializable {

  @Builder.Default
  List<String> data = new ArrayList<>();

}
