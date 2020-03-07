/**
 * This file was generated by the Jeddict
 */
package jpafinal.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author mrgum
 */
@Entity

public class SoccerPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @Basic
    private String Firstname;

    @Basic
    private String Lastname;

    @Basic
    private int Age;

    @Basic
    private float ShoeSize;

    @Basic
    private int JerseyNumber;

    @Basic
    private Double salary;

    @Basic
    private String position;

    @ManyToOne
    private Address address;

    @ManyToOne
    private FootballClubb footballClubb;

    public SoccerPlayer() {
    }

    public SoccerPlayer(String Firstname, String Lastname, int Age, float ShoeSize, int JerseyNumber, Double salary, String position) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Age = Age;
        this.ShoeSize = ShoeSize;
        this.JerseyNumber = JerseyNumber;
        this.salary = salary;
        this.position = position;
    }


    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return this.Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public int getAge() {
        return this.Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public float getShoeSize() {
        return this.ShoeSize;
    }

    public void setShoeSize(float ShoeSize) {
        this.ShoeSize = ShoeSize;
    }

    public int getJerseyNumber() {
        return this.JerseyNumber;
    }

    public void setJerseyNumber(int JerseyNumber) {
        this.JerseyNumber = JerseyNumber;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
        
    }

    public FootballClubb getFootballClubb() {
        return this.footballClubb;
    }

    public void setFootballClubb(FootballClubb footballClubb) {
        this.footballClubb = footballClubb;
    }
    
    public void addFootballClubb(FootballClubb footballClubb) {
        getFootballClubb().add(footballClubb);
        footballClubb.setFootballClubb(footballClubb);
    }

    
   public void removeSoccerPlayer(FootballClubb footballClubb) {
        getFootballClubb().remove(footballClubb);
        footballClubb.setFootballClubb(null);
    }

    public void getId(SoccerPlayer s) {
    }

    
    
}