package org.greyhawk.ejercicio.outbound_connectors.message_producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain.vos.Product;
import org.greyhawk.ejercicio.outbounds.kafka.ProductChangesTopic;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductsMessageProducerComponent implements ProductsMessageProducer {

  private final ProductChangesTopic productChangesTopic;
  private final ObjectMapper mapper;

  private enum Action {
    INSERTED, UPDATED, DELETED
  };

  public void productInserted(final Product product) {
    try {
      productChangesTopic.sendMessage(Action.INSERTED + " :" + mapper.writeValueAsString(product));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  public void productUpdated(final Product product) {
    try {
      productChangesTopic.sendMessage(Action.UPDATED + " :" + mapper.writeValueAsString(product));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  public void productDeleted(final Optional<Product> product) {
    try {
      productChangesTopic.sendMessage(Action.DELETED + " :" + mapper.writeValueAsString(product));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}