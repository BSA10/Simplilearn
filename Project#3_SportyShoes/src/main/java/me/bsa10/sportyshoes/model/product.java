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
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "product")
public class product  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double price;

    private String picture_url;
    private long created_at;


    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @ManyToMany(mappedBy = "products" , cascade = CascadeType.ALL)
    private List<order_details> order_details;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private List<cart> cart;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @ManyToMany(mappedBy = "products",cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST})
    private List<category> categories;


    public void addCart(cart tempcart){
        if (cart == null)
            cart = new ArrayList<>();
        cart.add(tempcart);
    }

    public void addOrder(order_details order_detail){
        if(order_details == null)
            order_details = new ArrayList<>();
        order_details.add(order_detail);
    }

    public void addCategory(category category){
        if(categories == null)
            categories = new ArrayList<>();
        categories.add(category);
    }

    public void addOrderDetails(order_details order_detail){
        if(order_details ==null)
            order_details = new ArrayList<>();
        order_details.add(order_detail);
    }





}
