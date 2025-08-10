package com.example.controller;

import com.example.dto.DepartmentDto;
import com.example.dto.EmployeeDto;
import com.example.exception.DepartmentNotFoundException;
import com.example.exception.EmployeeNotFoundException;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class MultipleController {

    private final EmployeeService employeeService;
    private final DepartmentService deptService;

    public MultipleController(EmployeeService employeeService, DepartmentService deptService) {
        this.employeeService = employeeService;
        this.deptService = deptService;
    }

    @GetMapping("empall")
    public ResponseEntity<List<EmployeeDto>> findAllEmployees() {
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.findEmployeeById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee","id",id)), HttpStatus.OK);
    }
    @PostMapping("empcreate")
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }
    @PutMapping("empupdate/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee( @PathVariable Integer id,@Valid @RequestBody EmployeeDto employeeDto ) {
        return new ResponseEntity<>(employeeService.updateEmployee(id,employeeDto)
                .orElseThrow(()->new EmployeeNotFoundException("Employee","id",id)),
                HttpStatus.CREATED);
    }
    @DeleteMapping("empdelete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.deleteEmployeeById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee","id",id)),HttpStatus.OK);
    }


// *****************************************************************************************************************************

    @GetMapping("deptall")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return new ResponseEntity<>(deptService.findAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("dept/{id}")
    public ResponseEntity<DepartmentDto> getAllDepartmentsByIds(@PathVariable Integer id) {
        System.out.println("GET DEPARTMENT HIT");
        return new ResponseEntity<>(deptService.findDepartmentById(id)
                .orElseThrow(()->new DepartmentNotFoundException("Department","id",id)),HttpStatus.OK);
    }

    @PostMapping("deptcreate")
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        System.out.println("CREATE DEPARTMENT HIT");
        return new ResponseEntity<>(deptService.createDepartment(departmentDto), HttpStatus.CREATED);
    }
    @PutMapping("deptupdate/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment( @PathVariable Integer id,@Valid @RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(deptService.updateDepartment(id, departmentDto)
                .orElseThrow(()->new DepartmentNotFoundException("Department","id",id)),HttpStatus.CREATED);
    }
    @DeleteMapping("deptdelete/{id}")
    public ResponseEntity<String> deleteDepartment( @PathVariable Integer id) {
        return new ResponseEntity<>(deptService.deleteDepartmentById(id)
                .orElseThrow(()->new DepartmentNotFoundException("Department","id",id)),HttpStatus.OK);
    }
}
