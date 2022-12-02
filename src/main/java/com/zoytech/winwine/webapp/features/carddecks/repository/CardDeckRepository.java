package com.zoytech.winwine.webapp.features.carddecks.repository;


import com.zoytech.winwine.webapp.features.carddecks.entity.CardDeckEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDeckRepository extends JpaRepository<CardDeckEntity, String> {

  List<CardDeckEntity> findAllByOwnerId(String ownerId);

  CardDeckEntity findByCardDeckId(String cardDeckId);

}
