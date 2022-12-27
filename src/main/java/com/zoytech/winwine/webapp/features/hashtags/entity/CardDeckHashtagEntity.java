package com.zoytech.winwine.webapp.features.hashtags.entity;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class CardDeckHashtagEntity {

  @Id
  @NotNull
  @Column(length = 50)
  private String cardId;

  @NotNull
  @Column(length = 50)
  private String cardDeckId;

  @NotNull
  private String cardTitle;

  @NotNull
  private String cardDescription;

  private String cardImage;


  private Timestamp createdAt;

  private Timestamp updatedAt;


}
