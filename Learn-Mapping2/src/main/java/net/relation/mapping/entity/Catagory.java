package net.relation.mapping.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "catagory")
public class Catagory {
    @Id
    private String cId;
    private String title;
    @ManyToMany(mappedBy = "catagories",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();
    public Catagory() {
    }

    public Catagory(String cId, String title, List<Product> products) {
        this.cId = cId;
        this.title = title;
        this.products = products;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
