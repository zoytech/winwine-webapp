package com.zoytech.winwine.webapp.controller.http.api.carddecks;

import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.GetCardDeckByIdResponse;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.GetCardDecksResponse;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.PostCardDecksReqBody;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.dtos.carddecks.PostCardDecksResp;
import com.zoytech.winwine.webapp.controller.http.api.carddecks.mapper.CardDecksHttpMapper;
import com.zoytech.winwine.webapp.controller.http.constants.HttpPathConstants;
import com.zoytech.winwine.webapp.features.carddecks.service.CardDecksService;
import com.zoytech.winwine.webapp.features.cards.services.CardsService;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
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
  public ResponseEntity<PostCardDecksResp> postCardDecks(@Valid @RequestBody PostCardDecksReqBody requestBody) {
    var cardDeck = cardDecksService.save(CardDecksHttpMapper.INSTANCE.mapRequest(requestBody));
    var cards =  cardsService.saveAll(cardDeck.getCardDeckId(), requestBody.getCards()) ;
    cardDeck.setCards(cards);
    return new ResponseEntity<>(
        PostCardDecksResp.builder()
            .data(cardDeck)
            .build(),
        HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<GetCardDecksResponse> findAll() {
    return new ResponseEntity<>(GetCardDecksResponse.builder()
        .data(cardDecksService.findAll().stream().map(cardDeckModel -> CardDecksHttpMapper.INSTANCE.map(cardDeckModel,
                cardDeckModel.getNumberOfCards() <= 0 ? new ArrayList<>() :
                    cardsService.findPreview(cardDeckModel.getCardDeckId())))
            .collect(Collectors.toList()))
        .build(), HttpStatus.OK);
  }

  @GetMapping(ResourceIdConstants.CARD_DECK_ID_PATH)
  public ResponseEntity<GetCardDeckByIdResponse> getCardDeckById(
      @PathVariable(ResourceIdConstants.CARD_DECK_ID_VARIABLE) String cardDeckId) {
    var cardDeck = CardDecksHttpMapper.INSTANCE.map(cardDecksService.getByCardDeckId(cardDeckId));
    cardDeck.setPreviewCards(cardDeck.getNumberOfCards() <= 0 ? new ArrayList<>() :
        cardsService.findPreview(cardDeckId));
    return new ResponseEntity<>(GetCardDeckByIdResponse.builder()
        .data(cardDeck)
        .build(), HttpStatus.OK);
  }

  public static final class ResourceIdConstants {

    private ResourceIdConstants() {

    }

    public static final String CARD_DECK_ID_VARIABLE = "cardDeckId";
    public static final String CARD_DECK_ID_PATH = "/{" + CARD_DECK_ID_VARIABLE + "}";
  }
}
