package com.kursach1.domains;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Vlad Fefelov
 */
@Entity
@Table(name = "users")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class User {

    @Id
    @GeneratedValue
    @JsonProperty
    private Integer id;

    @Column(name = "first_name")
    @JsonProperty
    private String firstName;

    @Column(name = "last_name")
    @JsonProperty
    private String lastName;

    @Column(name = "password")
    @JsonProperty
    private String password;

    @Column(name="userName")
    @JsonProperty
    private String email;

    @Column(name="enabled")
    @JsonProperty
    private Integer enabled;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private Set<Creative> creatives;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Set<Creative> getCreatives() {
        return creatives;
    }

    public void setCreatives(Set<Creative> creatives) {
        this.creatives = creatives;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }


}
