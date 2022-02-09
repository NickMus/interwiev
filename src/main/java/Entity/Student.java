package Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Student")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    @Getter
    @Setter
    private int id;


    @Getter
    @Setter
    @Column(name = "student_name")
    private String name;

    @Getter
    @Setter
    @Column(name = "student_age")
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
