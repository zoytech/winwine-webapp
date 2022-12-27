package com.zoytech.winwine.webapp.features.hashtags.repository;


import com.zoytech.winwine.webapp.features.hashtags.entity.HashtagEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepository extends JpaRepository<HashtagEntity, String> {


  List<HashtagEntity> findAllByCardDeckId(String cardDeckId);

}
