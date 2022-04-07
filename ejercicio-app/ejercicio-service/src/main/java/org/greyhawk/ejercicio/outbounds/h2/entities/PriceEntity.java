package org.greyhawk.ejercicio.outbounds.h2.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prices")
public class PriceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private Long brandId;

  @Column
  private LocalDateTime startDate;

  @Column
  private LocalDateTime endDate;

  @Column
  private Long priceList;

  @Column
  private Long productId;

  private Integer priority;

  private Double price;

  private String curr;
}
