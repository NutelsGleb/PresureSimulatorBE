package nutels.presuresimulator.be.models;
import java.text.SimpleDateFormat;
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
    private double systolicPressure;
    private double diastolicPressure;
    private double heartRate;
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

    public void setSystolicPressure(double systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public void setDiastolicPressure(double diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPerson(Person person) {this.person = person;}



    //getters
    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy HH:mm");
        return formatter.format(date);
    }

    public double getHeartRate() {
        return heartRate;
    }

    public double getDiastolicPressure() {
        return diastolicPressure;
    }

    public double getSystolicPressure() {
        return systolicPressure;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() { return person; }

}

