package com.academy.apiacademy.Controllers;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.academy.apiacademy.DTO.GenericResponse;
import com.academy.apiacademy.DTO.StudentDTO;
import com.academy.apiacademy.Models.Student;
import com.academy.apiacademy.Services.iStudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {

    private final iStudentService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO dto)  throws Exception{
        Student object = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(object), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception {
        List<StudentDTO> list = service.getAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDTO>> readById(@PathVariable("id") Integer id) throws Exception {
        Student object = service.getById(id);
        return new ResponseEntity<>(new GenericResponse<>(200, "Succes", Arrays.asList(convertToDTO(object))), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDTO>> updateStudent(@PathVariable("id") Integer id, @Valid @RequestBody StudentDTO dto) throws Exception{
        Student object = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(new GenericResponse<>(200, "Succes", Arrays.asList(convertToDTO(object))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDTO>> deleteStudent(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(new GenericResponse<>(200, "Succes", null), HttpStatus.OK);
    }

    private Student convertToEntity(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }

    private StudentDTO convertToDTO(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    
}
