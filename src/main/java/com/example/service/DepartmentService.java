package com.example.service;

import com.example.dto.DepartmentDto;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<DepartmentDto> findAllDepartments();
    Optional<DepartmentDto> findDepartmentById(Integer id);
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    Optional<DepartmentDto> updateDepartment( Integer id,DepartmentDto departmentDto);
    Optional<String> deleteDepartmentById(Integer id);
}
