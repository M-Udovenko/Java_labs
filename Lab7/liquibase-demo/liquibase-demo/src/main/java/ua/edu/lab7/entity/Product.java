package ua.edu.lab7.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_code", length = 50)
    private String productCode;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    // Конструктори
    public Product() {}

    public Product(String productCode, Integer cost, String description) {
        this.productCode = productCode;
        this.cost = cost;
        this.description = description;
    }

    // Getters and Setters
    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public Integer getCost() { return cost; }
    public void setCost(Integer cost) { this.cost = cost; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}