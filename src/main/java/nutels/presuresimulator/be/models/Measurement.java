package nutels.presuresimulator.be.models;
import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "maesurement", schema = "public")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double upperPresure;
    private double bottomPresure;
    private double pulse;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    @JsonIgnore
    private Person person;

    //constructor

    public Measurement() {
        this.date = Date.from(Instant.now());
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUpperPresure(double upperPresure) {
        this.upperPresure = upperPresure;
    }

    public void setBottomPresure(double bottomPresure) {
        this.bottomPresure = bottomPresure;
    }

    public void setPulse(double pulse) {
        this.pulse = pulse;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPerson(Person person) {this.person = person;}



    //getters
    public Date getDate() {
        return date;
    }

    public double getPulse() {
        return pulse;
    }

    public double getBottomPresure() {
        return bottomPresure;
    }

    public double getUpperPresure() {
        return upperPresure;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() { return person; }

}

