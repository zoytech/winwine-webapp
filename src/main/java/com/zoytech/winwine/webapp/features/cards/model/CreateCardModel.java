package com.zoytech.winwine.webapp.features.cards.model;


import java.io.Serializable;
import javax.validation.constraints.Size;
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
public class CreateCardModel implements Serializable {

  @Size(max = 200, min = 1)
  private String cardTitle;

  @Size(max = 120)
  private String cardDescription;

  @Size(max = 200)
  private String cardImage;


}
