package com.zoytech.winwine.webapp.features.carddecks.repository;


import com.zoytech.winwine.webapp.features.carddecks.entity.CardDeckEntity;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDeckRepository extends JpaRepository<CardDeckEntity, String> {

  List<CardDeckEntity> findAllByOwnerId(String ownerId);

  CardDeckEntity findByCardDeckId(String cardDeckId);

  @Transactional
  @Modifying(clearAutomatically = true)
  @Query(value = "UPDATE `card_deck` SET `number_of_cards` = :numberOfCards WHERE `card_deck_id` = :cardDeckId", nativeQuery = true)
  void updateNumberOfCards(@Param("cardDeckId") String cardDeckId,
      @Param("numberOfCards") int numberOfCards);
}
