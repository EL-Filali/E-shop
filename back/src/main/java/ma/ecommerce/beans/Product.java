package ma.ecommerce.beans;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Product {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private float price;
    private int countInStock;
    private String imgUrl;

    public Product(Long id, String name, String description, float price, int countInStock, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.countInStock = countInStock;
        this.imgUrl = imgUrl;
    }

    public Product() {
    }
}
