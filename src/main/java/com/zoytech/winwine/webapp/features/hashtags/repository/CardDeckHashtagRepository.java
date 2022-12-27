package com.zoytech.winwine.webapp.features.hashtags.repository;


import com.zoytech.winwine.webapp.features.hashtags.entity.CardDeckHashtagEntity;
import com.zoytech.winwine.webapp.features.hashtags.entity.CardDeckHashtagPrimaryKey;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDeckHashtagRepository extends JpaRepository<CardDeckHashtagEntity, CardDeckHashtagPrimaryKey> {


  List<CardDeckHashtagEntity> findAll(CardDeckHashtagPrimaryKey key);

}
