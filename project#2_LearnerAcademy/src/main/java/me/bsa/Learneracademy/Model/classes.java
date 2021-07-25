package me.bsa.Learneracademy.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "classes")
public class classes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "class_id" , referencedColumnName = "id")
    private List<student> student;

    @ManyToMany(mappedBy = "classes")
    private List<teacher> teachers;

    @ManyToMany(mappedBy = "classes")
    private List<subject> subject;

//    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinColumn(name = "class_id" , referencedColumnName = "id")
//    private List<teacher> teacher;

}
