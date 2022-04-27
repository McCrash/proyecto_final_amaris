package org.greyhawk.ejercicio.inbounds.rest;

import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain_connectors.connectors.ProductDomainConnector;
import org.greyhawk.ejercicio.inbounds.rest.api.apidoc.products.ProductCommandApi;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.request.ProductRequestDto;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.response.ProductResponseDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocDelete;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocInsert;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocUpdate;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
public class ProductCrudController implements ProductCommandApi {

    private final ProductDomainConnector productDomainConnector;

    @Override
    public ResponseEntity<SimpleResponseDto<ProductResponseDto>> insert(final ProductRequestDto dto) {
        return SimpleResponseDto.success(ApiDocInsert.Response.Success.SC, productDomainConnector.insert(dto));
    }

    @Override
    public ResponseEntity<SimpleResponseDto<ProductResponseDto>> update(final String id, final ProductRequestDto dto) {
        return SimpleResponseDto.success(ApiDocUpdate.Response.Success.SC, productDomainConnector.update(dto));
    }

    @Override
    public ResponseEntity<SimpleResponseDto<Void>> delete(final String id) {
        productDomainConnector.delete(id);
        return SimpleResponseDto.success(ApiDocDelete.Response.Success.SC);
    }
}
