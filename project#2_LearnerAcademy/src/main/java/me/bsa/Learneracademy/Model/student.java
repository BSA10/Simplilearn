package me.bsa.Learneracademy.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "student")
public class student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;

//    private int class_id;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "class_id" , referencedColumnName = "id")
    private classes classes;


    /*
    ● Set up a master list of all the subjects for all the classes
    ● Set up a master list of all the teachers
    ● Set up a master list of all the classes
    ● Assign classes for subjects from the master list
    ● Assign teachers to a class for a subject (A teacher can be assigned to different classes for different subjects)
    ● Get a master list of students (Each student must be assigned to a single class)
     */
}
