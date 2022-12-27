package com.zoytech.winwine.webapp.features.cards.repository;


import com.zoytech.winwine.webapp.features.cards.entity.CardEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, String> {


  List<CardEntity> findAllByCardDeckId(String cardDeckId);


}
