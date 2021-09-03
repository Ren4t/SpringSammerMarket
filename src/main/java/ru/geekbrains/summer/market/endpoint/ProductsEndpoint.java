package ru.geekbrains.summer.market.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.summer.market.dto.ProductDto;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductService;
import ru.geekbrains.summer.market.soap.products.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

@Endpoint
@RequiredArgsConstructor
public class ProductsEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/products";
    private final ProductService productService;

    private static final Function<Product, SoapProductDto> mapEntityToDto = product -> {
        SoapProductDto soapProductDto = new SoapProductDto();
        soapProductDto.setId(product.getId());
        soapProductDto.setTitle(product.getTitle());
        soapProductDto.setCategoryTitle(product.getCategory().getTitle());
        soapProductDto.setPrice(product.getPrice().doubleValue());
        return soapProductDto;
    };

//    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.example.com/products">
//            <soapenv:Header/>
//            <soapenv:Body>
//                <f:findProductByIdRequest>
//                    <f:id>5</f:id>
//                </f:findProductByIdRequest>
//            </soapenv:Body>
//        </soapenv:Envelope>

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findProductByIdRequest")
    @ResponsePayload
    public FindProductByIdResponse findProductById(@RequestPayload FindProductByIdRequest request) {
        FindProductByIdResponse response = new FindProductByIdResponse();
        response.setProductDto(mapEntityToDto.apply(productService.findById(request.getId()).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + request.getId()))));
        return response;
    }

    /*
        Пример запроса: POST http://localhost:8189/ws

        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.example.com/products">
            <soapenv:Header/>
            <soapenv:Body>
                <f:findAllProductsRequest/>
            </soapenv:Body>
        </soapenv:Envelope>
     */

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findAllProductsRequest")
    @ResponsePayload
    public FindAllProductsResponse findAllProducts(@RequestPayload FindAllProductsRequest request) {
        FindAllProductsResponse response = new FindAllProductsResponse();
        productService.findAll().forEach(product -> response.getProductsDto().add(mapEntityToDto.apply(product)));
//        List<SoapProductDto> productDtos = response.getProductsDto();
//        for (Product product : productService.findAll()) {
//            productDtos.add(mapEntityToDto.apply(product));
//        }
//        System.out.println(productDtos.size());
        return response;
    }
}
