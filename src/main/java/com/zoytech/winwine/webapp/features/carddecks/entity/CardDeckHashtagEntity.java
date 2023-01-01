package com.zoytech.winwine.webapp.features.carddecks.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "card_deck_hashtag")
@IdClass(CardDeckHashtagPrimaryKey.class)
public class CardDeckHashtagEntity {

  @Id
  @NotNull
  @Column(name = "card_deck_id", length = 96)
  private String cardDeckId;

  @NotNull
  @Id
  @Column(name = "hash_tag_id", length = 120)
  private String hashtagId;


}
