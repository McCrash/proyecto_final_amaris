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
@Document("Products")
public class ProductEntity {

  @Id
  private String id;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String name;
  private String category;
  private LocalDateTime endOfSalesDate;
}
