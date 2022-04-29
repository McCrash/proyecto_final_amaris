package org.greyhawk.ejercicio.outbounds.mongo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Prices")
public class PriceEntity {

  @Id
  private String id;

  private Long brandId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Long priceList;
  private Long productId;
  private Integer priority;
  private Double price;
  private String curr;
}
