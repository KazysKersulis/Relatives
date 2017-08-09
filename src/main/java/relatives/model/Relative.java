package relatives.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "r_relatives")
public class Relative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name="relative_type")
    private String relative_type;

    public Relative() {
    }

    public Relative(String first_name, String last_name, Date date_of_birth, String relative_type) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.relative_type = relative_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getRelative_type() {
        return relative_type;
    }

    public void setRelative_type(String relative_type) {
        this.relative_type = relative_type;
    }

    @Override
    public String toString() {
        return "Relative{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", relative_type='" + relative_type + '\'' +
                '}';
    }
}
