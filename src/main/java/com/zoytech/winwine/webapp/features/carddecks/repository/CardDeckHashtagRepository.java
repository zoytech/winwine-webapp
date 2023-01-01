package com.zoytech.winwine.webapp.features.carddecks.repository;


import com.zoytech.winwine.webapp.features.carddecks.entity.CardDeckHashtagEntity;
import com.zoytech.winwine.webapp.features.carddecks.entity.CardDeckHashtagPrimaryKey;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDeckHashtagRepository extends JpaRepository<CardDeckHashtagEntity, CardDeckHashtagPrimaryKey> {

  List<CardDeckHashtagEntity> findByCardDeckId(String cardDeckId);

}
