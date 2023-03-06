package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "domains_data_prop_link", schema = "owl", catalog = "postgres")
public class DomainsDataPropLink {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "link_id")
    private int linkId;

    @ManyToOne
    @JoinColumn(name = "data_prop_id", referencedColumnName = "data_prop_id")
    private DataProperties dataPropertiesByDataPropId;
    @ManyToOne
    @JoinColumn(name = "domains_class_id", referencedColumnName = "class_id")
    private Classes classesByDomainsClassId;

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
        DomainsDataPropLink that = (DomainsDataPropLink) o;
        return linkId == that.linkId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId);
    }

    public DataProperties getDataPropertiesByDataPropId() {
        return dataPropertiesByDataPropId;
    }

    public void setDataPropertiesByDataPropId(DataProperties dataPropertiesByDataPropId) {
        this.dataPropertiesByDataPropId = dataPropertiesByDataPropId;
    }

    public Classes getClassesByDomainsClassId() {
        return classesByDomainsClassId;
    }

    public void setClassesByDomainsClassId(Classes classesByDomainsClassId) {
        this.classesByDomainsClassId = classesByDomainsClassId;
    }
}
