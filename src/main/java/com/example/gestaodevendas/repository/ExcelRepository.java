package com.example.gestaodevendas.repository;

import com.example.gestaodevendas.domain.entity.Excel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExcelRepository extends JpaRepository<Excel,Long> {
   
}
