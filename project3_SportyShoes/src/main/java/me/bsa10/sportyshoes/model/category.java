package me.bsa10.sportyshoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table
public class category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;




    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "category_product"
            ,joinColumns = @JoinColumn(name = "category_id")
            ,inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<product> products;


    public void addProduct(product product){
        if(products == null)
            products = new ArrayList<>();
        products.add(product);
    }


}
