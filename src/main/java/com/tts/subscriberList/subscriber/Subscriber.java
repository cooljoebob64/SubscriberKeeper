package com.tts.subscriberList.subscriber;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Subscriber {

    public Long getId() {
        return id;
    }

    // set the id as the primary key
    @Id
    // allows the id to be generated by the underlying database
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @NotNull
    @Size(min=2, max=30)
    private String userName;

    @Column
    // Allows the date to be generated by the system
    @CreationTimestamp
    private Date signedUp;

    public Subscriber(){
        // non-argument constructor needed for JPA
    }

    public Subscriber(String firstName, String lastName, String userName, Date signedUp){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.signedUp = signedUp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getSignedUp() {
        return signedUp;
    }

    public void setSignedUp(Date signedUp) {
        this.signedUp = signedUp;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", signedUp=" + signedUp +
                '}';
    }
}