package org.greyhawk.ejercicio.outbounds.kafka;

public interface ProductChangesTopic {

  void sendMessage(String message);
}
