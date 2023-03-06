package com.example.demo.repositories;

import com.example.demo.entities.DataProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataPropertiesRepository extends JpaRepository<DataProperties, Integer> {
}
