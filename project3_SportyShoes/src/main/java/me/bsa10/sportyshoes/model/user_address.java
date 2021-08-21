package me.bsa10.sportyshoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "user_address")
public class user_address  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Enter your address")
    private String address_line1;
    private String address_line2;
    @NotEmpty(message = "Enter your City")
    private String city;
    @NotEmpty(message = "Enter your Country")
    private String country;
    @Range(min = 10000 , max = 99999 , message = "Must be 5 digit")
    private int postal_code;

    private String phone;



    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @OneToOne(mappedBy = "user_address" , cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH}  )
    private user user;



}
