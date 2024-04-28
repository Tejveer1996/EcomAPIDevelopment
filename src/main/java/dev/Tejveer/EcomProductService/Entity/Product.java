package dev.Tejveer.EcomProductService.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int productID;
    private String title;
    private String description;
    private String category;
    private double price;
    private String imageUrl;
    private double rating;
}
