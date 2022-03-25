package org.greyhawk.ejercicio.services;

import org.greyhawk.ejercicio.domain.vos.Price;

import java.util.List;
import java.util.Optional;

public interface PricesService {

    Optional<Price> find();
}
