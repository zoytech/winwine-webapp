package com.zoytech.winwine.webapp.features.carddecks.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(name = "card_deck", uniqueConstraints = {@UniqueConstraint(columnNames = {"ownerId"})})
public class CardDeckEntity {

  @Id
  @NotNull
  @Column(length = 96)
  private String cardDeckId;

  @NotNull
  @Column(length = 96)
  private String ownerId;

  @NotNull
  private String cardDeckName;

  private String cardDeckImage;

  private String cardDeckDescription;

  private int numberOfCards;


}
