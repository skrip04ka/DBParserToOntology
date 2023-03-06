package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "data_property_value", schema = "owl", catalog = "postgres")
public class DataPropertyValue {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "data_property_value")
    private int dataPropertyValue;

    @Basic
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "individuals_id", referencedColumnName = "individuals_id")
    private Individuals individualsByIndividualsId;
    @ManyToOne
    @JoinColumn(name = "data_prop_id", referencedColumnName = "data_prop_id")
    private DataProperties dataPropertiesByDataPropId;

    public int getDataPropertyValue() {
        return dataPropertyValue;
    }

    public void setDataPropertyValue(int dataPropertyValue) {
        this.dataPropertyValue = dataPropertyValue;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataPropertyValue that = (DataPropertyValue) o;
        return dataPropertyValue == that.dataPropertyValue && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataPropertyValue, value);
    }

    public Individuals getIndividualsByIndividualsId() {
        return individualsByIndividualsId;
    }

    public void setIndividualsByIndividualsId(Individuals individualsByIndividualsId) {
        this.individualsByIndividualsId = individualsByIndividualsId;
    }

    public DataProperties getDataPropertiesByDataPropId() {
        return dataPropertiesByDataPropId;
    }

    public void setDataPropertiesByDataPropId(DataProperties dataPropertiesByDataPropId) {
        this.dataPropertiesByDataPropId = dataPropertiesByDataPropId;
    }
}
