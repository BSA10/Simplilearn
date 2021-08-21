package me.bsa10.sportyshoes.model;

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
@Table(name = "cart")
public class cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;
    private long created_at;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @ManyToOne
    @JoinColumn(name = "product_id")
    private product product;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;



}
