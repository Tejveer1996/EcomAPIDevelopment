package dev.Tejveer.EcomProductService.Client;

import dev.Tejveer.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.Tejveer.EcomProductService.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakeStore.api.base.url}")   // this annotation fetch the required url from the app. properties.
    private String fakeStoreAPIBaseURl;
    @Value(("${fakeStore.api.products.path}"))
    private String fakeStoreAPIProductPath;

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreProductURl = fakeStoreAPIBaseURl.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> responseEntity = restTemplate.
                getForEntity(fakeStoreProductURl,FakeStoreProductResponseDTO[].class);
                // return the entity by converting JSON to an object
        return List.of(responseEntity.getBody());
    }
}
