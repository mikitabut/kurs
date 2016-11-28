package com.kursach1.domains;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "chapters")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Chapter {

    @Id
    @GeneratedValue
    @JsonProperty
    private Integer id;

    @Column(name = "chapterName")
    @JsonProperty
    private String chapterName;

    @Column(name = "chapterText")
    @JsonProperty
    private String chapterText;

    @ManyToOne(optional = false)
    @JoinColumn(name = "creative_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Creative creative;

}
