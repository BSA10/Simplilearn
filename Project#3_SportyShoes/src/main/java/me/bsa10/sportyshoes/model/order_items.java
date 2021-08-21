package me.bsa10.sportyshoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "order_items")
public class order_items  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double quantity;
    private long created_at;


}
