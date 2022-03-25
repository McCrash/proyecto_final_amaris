package org.greyhawk.ejercicio.services;

import org.greyhawk.ejercicio.domain.vos.Price;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PricesServiceComponent implements PricesService {

    @Override
    public Optional<Price> find() {
        return Optional.empty();
    }
}
