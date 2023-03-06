package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "disjoint_obj_prop_link", schema = "owl", catalog = "postgres")
public class DisjointObjPropLink {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "link_id")
    private int linkId;

    @ManyToOne
    @JoinColumn(name = "obj_prop_id", referencedColumnName = "obj_prop_id")
    private ObjectProperties objectPropertiesByObjPropId;
    @ManyToOne
    @JoinColumn(name = "disjoint_obj_prop_id", referencedColumnName = "obj_prop_id")
    private ObjectProperties objectPropertiesByDisjointObjPropId;

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
        DisjointObjPropLink that = (DisjointObjPropLink) o;
        return linkId == that.linkId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId);
    }

    public ObjectProperties getObjectPropertiesByObjPropId() {
        return objectPropertiesByObjPropId;
    }

    public void setObjectPropertiesByObjPropId(ObjectProperties objectPropertiesByObjPropId) {
        this.objectPropertiesByObjPropId = objectPropertiesByObjPropId;
    }

    public ObjectProperties getObjectPropertiesByDisjointObjPropId() {
        return objectPropertiesByDisjointObjPropId;
    }

    public void setObjectPropertiesByDisjointObjPropId(ObjectProperties objectPropertiesByDisjointObjPropId) {
        this.objectPropertiesByDisjointObjPropId = objectPropertiesByDisjointObjPropId;
    }
}
