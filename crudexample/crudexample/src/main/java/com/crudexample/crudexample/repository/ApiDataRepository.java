package com.crudexample.crudexample.repository;

import com.crudexample.crudexample.entity.ApiData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiDataRepository extends JpaRepository<ApiData, Long> {
}
