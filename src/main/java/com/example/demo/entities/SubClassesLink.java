package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sub_classes_link", schema = "owl", catalog = "postgres")
public class SubClassesLink {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "link_id")
    private int linkId;
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Classes classesByClassId;
    @ManyToOne
    @JoinColumn(name = "sub_class_id", referencedColumnName = "class_id")
    private Classes classesBySubClassId;

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
        SubClassesLink that = (SubClassesLink) o;
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

    public Classes getClassesBySubClassId() {
        return classesBySubClassId;
    }

    public void setClassesBySubClassId(Classes classesBySubClassId) {
        this.classesBySubClassId = classesBySubClassId;
    }
}
