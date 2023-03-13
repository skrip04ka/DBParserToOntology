package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "data_properties", schema = "owl", catalog = "postgres")
public class DataProperties {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "data_prop_id")
    private long dataPropId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "functional")
    private Boolean functional;
    @OneToMany(mappedBy = "dataPropertiesByDataPropId")
    private Collection<DataPropertyValue> dataPropertyValuesByDataPropId;
    @OneToMany(mappedBy = "dataPropertiesByDataPropId")
    private Collection<DomainsDataPropLink> domainsDataPropLinksByDataPropId;

    public long getDataPropId() {
        return dataPropId;
    }

    public void setDataPropId(long dataPropId) {
        this.dataPropId = dataPropId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        DataProperties that = (DataProperties) o;
        return dataPropId == that.dataPropId && Objects.equals(title, that.title) && Objects.equals(type, that.type) && Objects.equals(functional, that.functional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataPropId, title, type, functional);
    }

    public Collection<DataPropertyValue> getDataPropertyValuesByDataPropId() {
        return dataPropertyValuesByDataPropId;
    }

    public void setDataPropertyValuesByDataPropId(Collection<DataPropertyValue> dataPropertyValuesByDataPropId) {
        this.dataPropertyValuesByDataPropId = dataPropertyValuesByDataPropId;
    }

    public Collection<DomainsDataPropLink> getDomainsDataPropLinksByDataPropId() {
        return domainsDataPropLinksByDataPropId;
    }

    public void setDomainsDataPropLinksByDataPropId(Collection<DomainsDataPropLink> domainsDataPropLinksByDataPropId) {
        this.domainsDataPropLinksByDataPropId = domainsDataPropLinksByDataPropId;
    }
}
