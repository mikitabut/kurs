package com.kursach1.domains;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

/**
 * @author Vlad Fefelov
 */
@Entity
@Table(name = "creatives")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Creative {

    @Id
    @GeneratedValue
    @JsonProperty
    private Integer id;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @Column
    @JsonProperty
    private Calendar date;

    @Column(name = "mark")
    @JsonProperty
    private float mark;

    @OneToMany(mappedBy = "creative", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private Set<Chapter> chapters;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Set<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }
}
