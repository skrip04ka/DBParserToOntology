package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "disjoint_classes_link", schema = "owl", catalog = "postgres")
public class DisjointClassesLink {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "link_id")
    private int linkId;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Classes classesByClassId;
    @ManyToOne
    @JoinColumn(name = "disjoint_class_id", referencedColumnName = "class_id")
    private Classes classesByDisjointClassId;

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
        DisjointClassesLink that = (DisjointClassesLink) o;
        return linkId == that.linkId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId);
    }

    public Classes getClassesByClassId() {
        return classesByClassId;
    }

    public void setClassesByClassId(Classes classesByClassId) {
        this.classesByClassId = classesByClassId;
    }

    public Classes getClassesByDisjointClassId() {
        return classesByDisjointClassId;
    }

    public void setClassesByDisjointClassId(Classes classesByDisjointClassId) {
        this.classesByDisjointClassId = classesByDisjointClassId;
    }
}
