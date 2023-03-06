package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "object_properties", schema = "owl", catalog = "postgres")
public class ObjectProperties {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "obj_prop_id")
    private int objPropId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "functional")
    private Boolean functional;
    @Basic
    @Column(name = "inv_functional")
    private Boolean invFunctional;
    @Basic
    @Column(name = "transitive")
    private Boolean transitive;
    @Basic
    @Column(name = "sym")
    private Boolean sym;
    @Basic
    @Column(name = "asym")
    private Boolean asym;
    @Basic
    @Column(name = "reflexive")
    private Boolean reflexive;
    @Basic
    @Column(name = "irreflexive")
    private Boolean irreflexive;
    @OneToMany(mappedBy = "objectPropertiesByObjPropId")
    private Collection<DisjointObjPropLink> disjointObjPropLinksByObjPropId;
    @OneToMany(mappedBy = "objectPropertiesByDisjointObjPropId")
    private Collection<DisjointObjPropLink> disjointObjPropLinksByObjPropId_0;
    @OneToMany(mappedBy = "objectPropertiesByObjPropId")
    private Collection<DomainsObjPropLink> domainsObjPropLinksByObjPropId;
    @OneToMany(mappedBy = "objectPropertiesByObjPropId")
    private Collection<InverseObjPropLink> inverseObjPropLinksByObjPropId;
    @OneToMany(mappedBy = "objectPropertiesByInverseObjPropId")
    private Collection<InverseObjPropLink> inverseObjPropLinksByObjPropId_0;
    @OneToMany(mappedBy = "objectPropertiesByPredicateId")
    private Collection<Link> linksByObjPropId;
    @OneToMany(mappedBy = "objectPropertiesByObjPropId")
    private Collection<RangesObjPropLink> rangesObjPropLinksByObjPropId;
    @OneToMany(mappedBy = "objectPropertiesByObjPropId")
    private Collection<SubObjPropLink> subObjPropLinksByObjPropId;
    @OneToMany(mappedBy = "objectPropertiesBySubObjPropId")
    private Collection<SubObjPropLink> subObjPropLinksByObjPropId_0;

    public int getObjPropId() {
        return objPropId;
    }

    public void setObjPropId(int objPropId) {
        this.objPropId = objPropId;
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

    public Boolean getInvFunctional() {
        return invFunctional;
    }

    public void setInvFunctional(Boolean invFunctional) {
        this.invFunctional = invFunctional;
    }

    public Boolean getTransitive() {
        return transitive;
    }

    public void setTransitive(Boolean transitive) {
        this.transitive = transitive;
    }

    public Boolean getSym() {
        return sym;
    }

    public void setSym(Boolean sym) {
        this.sym = sym;
    }

    public Boolean getAsym() {
        return asym;
    }

    public void setAsym(Boolean asym) {
        this.asym = asym;
    }

    public Boolean getReflexive() {
        return reflexive;
    }

    public void setReflexive(Boolean reflexive) {
        this.reflexive = reflexive;
    }

    public Boolean getIrreflexive() {
        return irreflexive;
    }

    public void setIrreflexive(Boolean irreflexive) {
        this.irreflexive = irreflexive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectProperties that = (ObjectProperties) o;
        return objPropId == that.objPropId && Objects.equals(title, that.title) && Objects.equals(functional, that.functional) && Objects.equals(invFunctional, that.invFunctional) && Objects.equals(transitive, that.transitive) && Objects.equals(sym, that.sym) && Objects.equals(asym, that.asym) && Objects.equals(reflexive, that.reflexive) && Objects.equals(irreflexive, that.irreflexive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objPropId, title, functional, invFunctional, transitive, sym, asym, reflexive, irreflexive);
    }

    public Collection<DisjointObjPropLink> getDisjointObjPropLinksByObjPropId() {
        return disjointObjPropLinksByObjPropId;
    }

    public void setDisjointObjPropLinksByObjPropId(Collection<DisjointObjPropLink> disjointObjPropLinksByObjPropId) {
        this.disjointObjPropLinksByObjPropId = disjointObjPropLinksByObjPropId;
    }

    public Collection<DisjointObjPropLink> getDisjointObjPropLinksByObjPropId_0() {
        return disjointObjPropLinksByObjPropId_0;
    }

    public void setDisjointObjPropLinksByObjPropId_0(Collection<DisjointObjPropLink> disjointObjPropLinksByObjPropId_0) {
        this.disjointObjPropLinksByObjPropId_0 = disjointObjPropLinksByObjPropId_0;
    }

    public Collection<DomainsObjPropLink> getDomainsObjPropLinksByObjPropId() {
        return domainsObjPropLinksByObjPropId;
    }

    public void setDomainsObjPropLinksByObjPropId(Collection<DomainsObjPropLink> domainsObjPropLinksByObjPropId) {
        this.domainsObjPropLinksByObjPropId = domainsObjPropLinksByObjPropId;
    }

    public Collection<InverseObjPropLink> getInverseObjPropLinksByObjPropId() {
        return inverseObjPropLinksByObjPropId;
    }

    public void setInverseObjPropLinksByObjPropId(Collection<InverseObjPropLink> inverseObjPropLinksByObjPropId) {
        this.inverseObjPropLinksByObjPropId = inverseObjPropLinksByObjPropId;
    }

    public Collection<InverseObjPropLink> getInverseObjPropLinksByObjPropId_0() {
        return inverseObjPropLinksByObjPropId_0;
    }

    public void setInverseObjPropLinksByObjPropId_0(Collection<InverseObjPropLink> inverseObjPropLinksByObjPropId_0) {
        this.inverseObjPropLinksByObjPropId_0 = inverseObjPropLinksByObjPropId_0;
    }

    public Collection<Link> getLinksByObjPropId() {
        return linksByObjPropId;
    }

    public void setLinksByObjPropId(Collection<Link> linksByObjPropId) {
        this.linksByObjPropId = linksByObjPropId;
    }

    public Collection<RangesObjPropLink> getRangesObjPropLinksByObjPropId() {
        return rangesObjPropLinksByObjPropId;
    }

    public void setRangesObjPropLinksByObjPropId(Collection<RangesObjPropLink> rangesObjPropLinksByObjPropId) {
        this.rangesObjPropLinksByObjPropId = rangesObjPropLinksByObjPropId;
    }

    public Collection<SubObjPropLink> getSubObjPropLinksByObjPropId() {
        return subObjPropLinksByObjPropId;
    }

    public void setSubObjPropLinksByObjPropId(Collection<SubObjPropLink> subObjPropLinksByObjPropId) {
        this.subObjPropLinksByObjPropId = subObjPropLinksByObjPropId;
    }

    public Collection<SubObjPropLink> getSubObjPropLinksByObjPropId_0() {
        return subObjPropLinksByObjPropId_0;
    }

    public void setSubObjPropLinksByObjPropId_0(Collection<SubObjPropLink> subObjPropLinksByObjPropId_0) {
        this.subObjPropLinksByObjPropId_0 = subObjPropLinksByObjPropId_0;
    }
}
