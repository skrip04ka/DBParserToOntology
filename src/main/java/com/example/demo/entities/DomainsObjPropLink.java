package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "domains_obj_prop_link", schema = "owl", catalog = "postgres")
public class DomainsObjPropLink {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "link_id")
    private long linkId;
    @ManyToOne
    @JoinColumn(name = "obj_prop_id", referencedColumnName = "obj_prop_id")
    private ObjectProperties objectPropertiesByObjPropId;
    @ManyToOne
    @JoinColumn(name = "domains_class_id", referencedColumnName = "class_id")
    private Classes classesByDomainsClassId;

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
        DomainsObjPropLink that = (DomainsObjPropLink) o;
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

    public Classes getClassesByDomainsClassId() {
        return classesByDomainsClassId;
    }

    public void setClassesByDomainsClassId(Classes classesByDomainsClassId) {
        this.classesByDomainsClassId = classesByDomainsClassId;
    }
}
