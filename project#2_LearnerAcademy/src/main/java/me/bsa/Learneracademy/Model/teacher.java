package me.bsa.Learneracademy.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.Id;

import javax.persistence.*;
import javax.security.auth.Subject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "teacher")
public class teacher implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;


//    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinColumn(name = "teacher_id")
//    private List<classes> classes;



    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "teacher_id")
    private List<subject> subject;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "teacher_class",
            joinColumns = { @JoinColumn(name = "teacher_id") },
            inverseJoinColumns = { @JoinColumn(name = "class_id") }
    )
    private List<classes> classes;



    public void addClass(classes tempClasses){
        if(classes == null)
            classes = new ArrayList<>();

        classes.add(tempClasses);
    }

    public void addSubject(subject tempSubject){
        if(subject == null)
            subject = new ArrayList<>();

        subject.add(tempSubject);
    }

    public boolean getCheckedClass(){
        return classes != null;
    }

}
