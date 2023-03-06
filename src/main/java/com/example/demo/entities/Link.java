package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Link {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "link_id")
    private int linkId;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "individuals_id")
    private Individuals individualsBySubjectId;
    @ManyToOne
    @JoinColumn(name = "predicate_id", referencedColumnName = "obj_prop_id")
    private ObjectProperties objectPropertiesByPredicateId;
    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "individuals_id")
    private Individuals individualsByObjectId;

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
        Link link = (Link) o;
        return linkId == link.linkId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId);
    }

    public Individuals getIndividualsBySubjectId() {
        return individualsBySubjectId;
    }

    public void setIndividualsBySubjectId(Individuals individualsBySubjectId) {
        this.individualsBySubjectId = individualsBySubjectId;
    }

    public ObjectProperties getObjectPropertiesByPredicateId() {
        return objectPropertiesByPredicateId;
    }

    public void setObjectPropertiesByPredicateId(ObjectProperties objectPropertiesByPredicateId) {
        this.objectPropertiesByPredicateId = objectPropertiesByPredicateId;
    }

    public Individuals getIndividualsByObjectId() {
        return individualsByObjectId;
    }

    public void setIndividualsByObjectId(Individuals individualsByObjectId) {
        this.individualsByObjectId = individualsByObjectId;
    }
}
