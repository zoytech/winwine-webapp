package com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks;

import com.zoytech.winwine.webapp.features.carddecks.models.CardDeckModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class GetCardDecksResponse implements Serializable {

  @Default
  List<CardDeckModel> data = new ArrayList<>();
}
