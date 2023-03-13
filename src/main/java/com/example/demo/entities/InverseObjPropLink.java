package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "inverse_obj_prop_link", schema = "owl", catalog = "postgres")
public class InverseObjPropLink {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "link_id")
    private long linkId;
    @ManyToOne
    @JoinColumn(name = "obj_prop_id", referencedColumnName = "obj_prop_id")
    private ObjectProperties objectPropertiesByObjPropId;
    @ManyToOne
    @JoinColumn(name = "inverse_obj_prop_id", referencedColumnName = "obj_prop_id")
    private ObjectProperties objectPropertiesByInverseObjPropId;

    public long getLinkId() {
        return linkId;
    }

    public void setLinkId(long linkId) {
        this.linkId = linkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InverseObjPropLink that = (InverseObjPropLink) o;
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

    public ObjectProperties getObjectPropertiesByInverseObjPropId() {
        return objectPropertiesByInverseObjPropId;
    }

    public void setObjectPropertiesByInverseObjPropId(ObjectProperties objectPropertiesByInverseObjPropId) {
        this.objectPropertiesByInverseObjPropId = objectPropertiesByInverseObjPropId;
    }
}
