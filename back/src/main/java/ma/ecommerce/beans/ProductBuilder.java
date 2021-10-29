package ma.ecommerce.beans;

import org.springframework.stereotype.Component;

public class ProductBuilder {

    private Long id;
    private String name;
    private String description;
    private float price;
    private int countInStock;
    private String imgUrl;

    public  Product build(){
        return new Product(id,name,description,price,countInStock,imgUrl);
    }

    public ProductBuilder setName(String name){
        this.name=name;
        return this;
    }
    public ProductBuilder setId(Long id){
        this.id=id;
        return this;
    }
    public ProductBuilder setDescription(String description){
        this.description=description;
        return this;
    }
    public ProductBuilder setPrice(float price){
        this.price=price;
        return this;
    }
    public ProductBuilder setImgUrl(String imgUrl){
        this.imgUrl=imgUrl;
        return this;
    }
    public ProductBuilder setCountInStock(Integer countInStock){
        this.countInStock=countInStock;
        return this;
    }
}
