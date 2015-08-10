package model;

import javax.persistence.*;

/**
 * Created by Vitaliy on 21.07.2015.
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_product;
    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    @Column
    private ProductType productType;
    @Column
    private int price;


    public Product(){
    }

    public Product(String name, ProductType productType, int price) {
        this.name = name;
        this.productType = productType;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_Product) {
        this.id_product = id_Product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_Product=" + id_product +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                ", price=" + price +
                '}';
    }
}
