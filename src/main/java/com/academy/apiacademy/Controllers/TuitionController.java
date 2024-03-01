package com.academy.apiacademy.Controllers;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.academy.apiacademy.DTO.GenericResponse;
import com.academy.apiacademy.DTO.TuitionDTO;
import com.academy.apiacademy.Models.Tuition;
import com.academy.apiacademy.Services.iTuitionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/tuitions")
@RequiredArgsConstructor
public class TuitionController {

    private final iTuitionService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<TuitionDTO> createTuition(@Valid @RequestBody TuitionDTO dto)  throws Exception{
        Tuition object = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(object), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TuitionDTO>> readAll() throws Exception {
        List<TuitionDTO> list = service.getAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<TuitionDTO>> readById(@PathVariable("id") Integer id) throws Exception {
        Tuition object = service.getById(id);
        return new ResponseEntity<>(new GenericResponse<>(200, "Succes", Arrays.asList(convertToDTO(object))), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<TuitionDTO>> updateTuition(@PathVariable("id") Integer id, @Valid @RequestBody TuitionDTO dto) throws Exception{
        Tuition object = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(new GenericResponse<>(200, "Succes", Arrays.asList(convertToDTO(object))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<TuitionDTO>> deleteTuition(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(new GenericResponse<>(200, "Succes", null), HttpStatus.OK);
    }

    private Tuition convertToEntity(TuitionDTO tuitionDTO) {
        return modelMapper.map(tuitionDTO, Tuition.class);
    }

    private TuitionDTO convertToDTO(Tuition tuition) {
        return modelMapper.map(tuition, TuitionDTO.class);
    }
}
