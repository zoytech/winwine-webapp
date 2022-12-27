package com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks;

import com.zoytech.winwine.webapp.features.carddecks.models.CardDeckModel;
import java.io.Serializable;
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
public class PostCardDecksResp implements Serializable {
  CardDeckModel data;
}
