package me.bsa.Learneracademy.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "subject")
@JsonIgnoreType
public class subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "subject_class",
            joinColumns = { @JoinColumn(name = "subject_id") },
            inverseJoinColumns = { @JoinColumn(name = "class_id") }
    )
    private List<classes> classes;


    public void addClass(classes tempClasses){
        if(classes == null)
            classes = new ArrayList<>();

        classes.add(tempClasses);
    }


}
