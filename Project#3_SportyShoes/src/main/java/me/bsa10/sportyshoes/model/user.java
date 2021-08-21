package me.bsa10.sportyshoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "user")
public class user  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Enter your username")
    private String username;
    @NotEmpty(message = "Enter your password")
    private String password;
    @NotEmpty(message = "Enter your firstname")
    private String first_name;
    private String last_name;
    @NotEmpty(message = "Enter your Email")
    private String email;
    private boolean enable;
    private String role;
    private String phone;
    private long created_at;



    @Valid
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "user_address_id" )
    private user_address user_address;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<cart> cart;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<order_details> order_details;


    public void addCart(cart tempCart){
        if(cart == null)
            cart = new ArrayList<>();
        cart.add(tempCart);
    }
    public void addOrder_details(order_details tempOrder_details){
        if(order_details == null)
            order_details = new ArrayList<>();
        order_details.add(tempOrder_details);
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", enable=" + enable +
                ", role='" + role + '\'' +
                ", phone='" + phone + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (user) o;
        return id == user.id && enable == user.enable && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(first_name, user.first_name) && Objects.equals(last_name, user.last_name) && Objects.equals(email, user.email) && Objects.equals(role, user.role) && Objects.equals(phone, user.phone) && Objects.equals(created_at, user.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, first_name, last_name, email, enable, role, phone, created_at);
    }
}
