package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Individuals {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "individuals_id")
    private int individualsId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "functional")
    private Boolean functional;
    @OneToMany(mappedBy = "individualsByIndividualsId")
    private Collection<DataPropertyValue> dataPropertyValuesByIndividualsId;
    @OneToMany(mappedBy = "individualsByIndividualsId")
    private Collection<IndividualsTypesLink> individualsTypesLinksByIndividualsId;
    @OneToMany(mappedBy = "individualsBySubjectId")
    private Collection<Link> linksByIndividualsId;
    @OneToMany(mappedBy = "individualsByObjectId")
    private Collection<Link> linksByIndividualsId_0;

    public int getIndividualsId() {
        return individualsId;
    }

    public void setIndividualsId(int individualsId) {
        this.individualsId = individualsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getFunctional() {
        return functional;
    }

    public void setFunctional(Boolean functional) {
        this.functional = functional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Individuals that = (Individuals) o;
        return individualsId == that.individualsId && Objects.equals(title, that.title) && Objects.equals(functional, that.functional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(individualsId, title, functional);
    }

    public Collection<DataPropertyValue> getDataPropertyValuesByIndividualsId() {
        return dataPropertyValuesByIndividualsId;
    }

    public void setDataPropertyValuesByIndividualsId(Collection<DataPropertyValue> dataPropertyValuesByIndividualsId) {
        this.dataPropertyValuesByIndividualsId = dataPropertyValuesByIndividualsId;
    }

    public Collection<IndividualsTypesLink> getIndividualsTypesLinksByIndividualsId() {
        return individualsTypesLinksByIndividualsId;
    }

    public void setIndividualsTypesLinksByIndividualsId(Collection<IndividualsTypesLink> individualsTypesLinksByIndividualsId) {
        this.individualsTypesLinksByIndividualsId = individualsTypesLinksByIndividualsId;
    }

    public Collection<Link> getLinksByIndividualsId() {
        return linksByIndividualsId;
    }

    public void setLinksByIndividualsId(Collection<Link> linksByIndividualsId) {
        this.linksByIndividualsId = linksByIndividualsId;
    }

    public Collection<Link> getLinksByIndividualsId_0() {
        return linksByIndividualsId_0;
    }

    public void setLinksByIndividualsId_0(Collection<Link> linksByIndividualsId_0) {
        this.linksByIndividualsId_0 = linksByIndividualsId_0;
    }
}
