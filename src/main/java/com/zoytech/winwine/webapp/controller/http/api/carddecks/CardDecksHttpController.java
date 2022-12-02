package com.zoytech.winwine.webapp.controller.http.api.carddecks;

import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.GetCardDeckByIdRequest;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.GetCardDeckByIdResponse;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.GetCardDecksRequest;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.GetCardDecksResponse;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.PostCardDecksRequest;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.PostCardDecksResponse;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.mapper.CardDecksHttpMapper;
import com.zoytech.winwine.webapp.controller.http.constants.HttpPathConstants;
import com.zoytech.winwine.webapp.features.carddecks.service.CardDecksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("${http.api.prefix}" + HttpPathConstants.CARD_DECKS)
public class CardDecksHttpController {
  @Autowired
  private CardDecksService cardDecksService;


  @PostMapping
  public PostCardDecksResponse postCardDecks(@RequestBody PostCardDecksRequest requestBody) {
    return PostCardDecksResponse.builder()
        .data(cardDecksService.createCardDeck(CardDecksHttpMapper.INSTANCE.mapRequest(requestBody)))
        .build();
  }

  @GetMapping
  public GetCardDeckByIdResponse getCardDeckById(@RequestBody GetCardDeckByIdRequest requestBody) {
    return null;
  }

  @GetMapping
  public GetCardDecksResponse getCardDeckById(@RequestBody GetCardDecksRequest requestBody) {
    return null;
  }


  private static final class ResourceNameConstants {

    public static final String CARDS = "/cards";
  }

  private static final class ResourceIdConstants {

    public static final String CARD_DECK_ID_VARIABLE = "cardDeckId";
    public static final String CARD_DECK_ID_PATH = "/{" + CARD_DECK_ID_VARIABLE + "}";

    public static final String CARD_ID = "cardId";
    public static final String CARD_ID_PATH = "/{" + CARD_ID + "}";
  }
}
