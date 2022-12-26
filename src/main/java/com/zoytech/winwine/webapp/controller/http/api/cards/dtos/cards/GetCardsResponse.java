package com.zoytech.winwine.webapp.controller.http.api.cards.dtos.cards;

import com.zoytech.winwine.webapp.features.cards.model.CardModel;
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
public class GetCardsResponse implements Serializable {

  @Builder.Default
  List<CardModel> data = new ArrayList<>();

}
