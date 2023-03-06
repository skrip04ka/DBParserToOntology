package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "individuals_types_link", schema = "owl", catalog = "postgres")
public class IndividualsTypesLink {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "link_id")
    private int linkId;
    @ManyToOne
    @JoinColumn(name = "individuals_id", referencedColumnName = "individuals_id")
    private Individuals individualsByIndividualsId;
    @ManyToOne
    @JoinColumn(name = "types_class_id", referencedColumnName = "class_id")
    private Classes classesByTypesClassId;

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndividualsTypesLink that = (IndividualsTypesLink) o;
        return linkId == that.linkId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId);
    }

    public Individuals getIndividualsByIndividualsId() {
        return individualsByIndividualsId;
    }

    public void setIndividualsByIndividualsId(Individuals individualsByIndividualsId) {
        this.individualsByIndividualsId = individualsByIndividualsId;
    }

    public Classes getClassesByTypesClassId() {
        return classesByTypesClassId;
    }

    public void setClassesByTypesClassId(Classes classesByTypesClassId) {
        this.classesByTypesClassId = classesByTypesClassId;
    }
}
