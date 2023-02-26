package com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks;

import com.zoytech.winwine.webapp.features.cards.model.CreateCardModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.Size;
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
public class PostCardDecksReqBody implements Serializable {
  @Size(max = 120, min = 1)
  private String cardDeckName;

  @Size(max = 200)
  private String cardDeckImage;

  @Size(max = 200)
  private String cardDeckDescription;

  private Set<String> hashtags;

  private List<CreateCardModel> cards = new ArrayList<>();
}
