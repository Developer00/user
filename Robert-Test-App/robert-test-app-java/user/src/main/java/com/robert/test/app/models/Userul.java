package com.robert.test.app.models;

import javax.persistence.*;

@Entity
@Table
public class Userul {

    // generate the id
    // this is use in when adding a new User
    @Id
    @SequenceGenerator(
            name = "userul_index",
            sequenceName = "userul_index",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userul_index"
    )
    private Long id;
    private String name;
    private String email;

    public Userul() {
    }

    public Userul(Long id, String name, Integer age, String dob, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Userul(String name, Integer age, String dob, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
