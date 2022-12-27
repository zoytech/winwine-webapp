package com.zoytech.winwine.webapp.controller.http.api.carddecks;

import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.GetCardDeckByIdResponse;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.GetCardDecksResponse;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.PostCardDecksReqBody;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.PostCardDecksResp;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.mapper.CardDecksHttpMapper;
import com.zoytech.winwine.webapp.controller.http.constants.HttpPathConstants;
import com.zoytech.winwine.webapp.features.carddecks.service.CardDecksService;
import com.zoytech.winwine.webapp.features.cards.services.CardsService;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @Autowired
  private CardsService cardsService;

  @PostMapping
  public ResponseEntity<PostCardDecksResp> postCardDecks(@RequestBody PostCardDecksReqBody requestBody) {
    return new ResponseEntity<>(
        PostCardDecksResp.builder()
            .data(cardDecksService.save(CardDecksHttpMapper.INSTANCE.mapRequest(requestBody)))
            .build(),
        HttpStatus.CREATED);
  }

  @GetMapping
  public GetCardDecksResponse findAll() {
    return GetCardDecksResponse.builder()
        .data(cardDecksService.findAll().stream().map(cardDeckModel -> CardDecksHttpMapper.INSTANCE.map(cardDeckModel,
            cardsService.findPreview(cardDeckModel.getCardDeckId()))).collect(Collectors.toList()))
        .build();
  }

  @GetMapping(ResourceIdConstants.CARD_DECK_ID_PATH)
  public GetCardDeckByIdResponse getCardDeckById(
      @PathVariable(ResourceIdConstants.CARD_DECK_ID_VARIABLE) String cardDeckId) {
    return GetCardDeckByIdResponse.builder()
        .data(CardDecksHttpMapper.INSTANCE.map(cardDecksService.getByCardDeckId(cardDeckId),
            cardsService.findPreview(cardDeckId)))
        .build();
  }

  public static final class ResourceIdConstants {

    public static final String CARD_DECK_ID_VARIABLE = "cardDeckId";
    public static final String CARD_DECK_ID_PATH = "/{" + CARD_DECK_ID_VARIABLE + "}";
  }
}
