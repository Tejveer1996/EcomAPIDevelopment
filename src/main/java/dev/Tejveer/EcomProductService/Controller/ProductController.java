package dev.Tejveer.EcomProductService.Controller;

import dev.Tejveer.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.Tejveer.EcomProductService.DTO.ProductResponseDTO;
import dev.Tejveer.EcomProductService.Entity.Product;
import dev.Tejveer.EcomProductService.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
        List<FakeStoreProductResponseDTO> products = productServices.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
