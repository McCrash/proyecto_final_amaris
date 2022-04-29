package org.greyhawk.ejercicio.outbounds.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductChangesTopicComponent implements ProductChangesTopic {

  private KafkaTemplate<String, String> kafkaTemplate;

  private static final String DEFAULT_TOPIC = "productchanges";

  @Override
  public void sendMessage(final String message) {
    kafkaTemplate.setDefaultTopic(DEFAULT_TOPIC);
    kafkaTemplate.sendDefault(message);
  }
}
