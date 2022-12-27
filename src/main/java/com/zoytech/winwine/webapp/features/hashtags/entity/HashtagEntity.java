package com.zoytech.winwine.webapp.features.hashtags.entity;


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
@Table(name = "hashtag")
public class HashtagEntity {

  @Id
  @NotNull
  @Column(length = 120)
  private String hashtagId;

  @NotNull
  @Column(length = 120)
  private String hashtagDescription;

}
