package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Classes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "class_id")
    private int classId;
    @Basic
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "classesByClassId")
    private Collection<DisjointClassesLink> disjointClassesLinksByClassId;
    @OneToMany(mappedBy = "classesByDisjointClassId")
    private Collection<DisjointClassesLink> disjointClassesLinksByClassId_0;
    @OneToMany(mappedBy = "classesByDomainsClassId")
    private Collection<DomainsDataPropLink> domainsDataPropLinksByClassId;
    @OneToMany(mappedBy = "classesByDomainsClassId")
    private Collection<DomainsObjPropLink> domainsObjPropLinksByClassId;
    @OneToMany(mappedBy = "classesByTypesClassId")
    private Collection<IndividualsTypesLink> individualsTypesLinksByClassId;
    @OneToMany(mappedBy = "classesByRangesClassId")
    private Collection<RangesObjPropLink> rangesObjPropLinksByClassId;
    @OneToMany(mappedBy = "classesByClassId")
    private Collection<SubClassesLink> subClassesLinksByClassId;
    @OneToMany(mappedBy = "classesBySubClassId")
    private Collection<SubClassesLink> subClassesLinksByClassId_0;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes classes = (Classes) o;
        return classId == classes.classId && Objects.equals(title, classes.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, title);
    }

    public Collection<DisjointClassesLink> getDisjointClassesLinksByClassId() {
        return disjointClassesLinksByClassId;
    }

    public void setDisjointClassesLinksByClassId(Collection<DisjointClassesLink> disjointClassesLinksByClassId) {
        this.disjointClassesLinksByClassId = disjointClassesLinksByClassId;
    }

    public Collection<DisjointClassesLink> getDisjointClassesLinksByClassId_0() {
        return disjointClassesLinksByClassId_0;
    }

    public void setDisjointClassesLinksByClassId_0(Collection<DisjointClassesLink> disjointClassesLinksByClassId_0) {
        this.disjointClassesLinksByClassId_0 = disjointClassesLinksByClassId_0;
    }

    public Collection<DomainsDataPropLink> getDomainsDataPropLinksByClassId() {
        return domainsDataPropLinksByClassId;
    }

    public void setDomainsDataPropLinksByClassId(Collection<DomainsDataPropLink> domainsDataPropLinksByClassId) {
        this.domainsDataPropLinksByClassId = domainsDataPropLinksByClassId;
    }

    public Collection<DomainsObjPropLink> getDomainsObjPropLinksByClassId() {
        return domainsObjPropLinksByClassId;
    }

    public void setDomainsObjPropLinksByClassId(Collection<DomainsObjPropLink> domainsObjPropLinksByClassId) {
        this.domainsObjPropLinksByClassId = domainsObjPropLinksByClassId;
    }

    public Collection<IndividualsTypesLink> getIndividualsTypesLinksByClassId() {
        return individualsTypesLinksByClassId;
    }

    public void setIndividualsTypesLinksByClassId(Collection<IndividualsTypesLink> individualsTypesLinksByClassId) {
        this.individualsTypesLinksByClassId = individualsTypesLinksByClassId;
    }

    public Collection<RangesObjPropLink> getRangesObjPropLinksByClassId() {
        return rangesObjPropLinksByClassId;
    }

    public void setRangesObjPropLinksByClassId(Collection<RangesObjPropLink> rangesObjPropLinksByClassId) {
        this.rangesObjPropLinksByClassId = rangesObjPropLinksByClassId;
    }

    public Collection<SubClassesLink> getSubClassesLinksByClassId() {
        return subClassesLinksByClassId;
    }

    public void setSubClassesLinksByClassId(Collection<SubClassesLink> subClassesLinksByClassId) {
        this.subClassesLinksByClassId = subClassesLinksByClassId;
    }

    public Collection<SubClassesLink> getSubClassesLinksByClassId_0() {
        return subClassesLinksByClassId_0;
    }

    public void setSubClassesLinksByClassId_0(Collection<SubClassesLink> subClassesLinksByClassId_0) {
        this.subClassesLinksByClassId_0 = subClassesLinksByClassId_0;
    }
}
