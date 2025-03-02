package com.springbootproject.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "web_order_quantities")
public class WebOrderQuantities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name ="product_id", nullable = false)
    private Product product;

    @Column(name = "quantity")
    private Double quantities;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name ="order_id", nullable = false)
    private WebOrder order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getQuantities() {
        return quantities;
    }

    public void setQuantities(Double quantities) {
        this.quantities = quantities;
    }


    public WebOrder getOrder() {
        return order;
    }

    public void setOrder(WebOrder order) {
        this.order = order;
    }
}
