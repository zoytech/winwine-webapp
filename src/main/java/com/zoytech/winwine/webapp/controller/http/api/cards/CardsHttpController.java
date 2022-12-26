package com.zoytech.winwine.webapp.controller.http.api.cards;

import com.zoytech.winwine.webapp.controller.http.api.carddecks.CardDecksHttpController.ResourceIdConstants;
import com.zoytech.winwine.webapp.controller.http.api.cards.dtos.cards.PostCardsResponse;
import com.zoytech.winwine.webapp.controller.http.constants.HttpPathConstants;
import com.zoytech.winwine.webapp.features.cards.model.CardModel;
import com.zoytech.winwine.webapp.features.cards.model.CreateCardModel;
import com.zoytech.winwine.webapp.features.cards.services.CardsService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("${http.api.prefix}" + HttpPathConstants.CARD_DECKS + ResourceIdConstants.CARD_DECK_ID_PATH)
public class CardsHttpController {

  @Autowired
  private CardsService cardsService;

  @PostMapping(ResourceIdConstants.CARD_DECK_ID_PATH)
  public ResponseEntity<PostCardsResponse> postCards(
      @PathVariable(ResourceIdConstants.CARD_DECK_ID_VARIABLE) String cardDeckId,
      @RequestBody List<CreateCardModel> cards) {
    return new ResponseEntity<>(
        PostCardsResponse.builder().data(cardsService.saveAll(cardDeckId, cards)).build(),
        HttpStatus.CREATED);
  }

  @PostMapping(ResourceIdConstants.CARD_DECK_ID_PATH)
  public ResponseEntity<CardModel> postCard(
      @PathVariable(ResourceIdConstants.CARD_DECK_ID_VARIABLE) String cardDeckId,
      @RequestBody CreateCardModel card) {
    return new ResponseEntity<>(cardsService.save(cardDeckId, card), HttpStatus.CREATED);
  }

  public static final class ResourceNameConstants {

    public static final String CARDS = "/cards";
  }

  public static final class ResourceIdConstants {

    public static final String CARD_DECK_ID_VARIABLE = "cardDeckId";
    public static final String CARD_DECK_ID_PATH = "/{" + CARD_DECK_ID_VARIABLE + "}";

    public static final String CARD_ID = "cardId";
    public static final String CARD_ID_PATH = "/{" + CARD_ID + "}";
  }
}
