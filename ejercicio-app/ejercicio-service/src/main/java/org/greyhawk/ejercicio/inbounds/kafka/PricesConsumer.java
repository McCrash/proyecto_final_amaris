package org.greyhawk.ejercicio.inbounds.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.greyhawk.ejercicio.domain_connectors.connectors.PriceDomainConnector;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PricesConsumer {

  private final PriceDomainConnector priceDomainConnector;

  @KafkaListener(topics = { "pricechanges" })
  public void onPriceChange(final ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
    priceDomainConnector.updatePriceByConsumerRecordValue(consumerRecord.value());
  }

}
