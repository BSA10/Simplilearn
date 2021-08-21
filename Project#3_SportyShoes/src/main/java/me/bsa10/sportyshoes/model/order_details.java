package me.bsa10.sportyshoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "order_details")
public class order_details implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private double total;
    private long created_at;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "order_product",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    private List<product> products;



    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;


    public void addProduct(product product){
        if(products == null)
            products = new ArrayList<>();
        products.add(product);
    }


}
