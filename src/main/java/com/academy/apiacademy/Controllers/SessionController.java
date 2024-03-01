package com.academy.apiacademy.Controllers;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.academy.apiacademy.DTO.GenericResponse;
import com.academy.apiacademy.DTO.SessionDTO;
import com.academy.apiacademy.Models.Session;
import com.academy.apiacademy.Services.iSessionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final iSessionService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<SessionDTO> createSession(@Valid @RequestBody SessionDTO dto)  throws Exception{
        Session object = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(object), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SessionDTO>> readAll() throws Exception {
        List<SessionDTO> list = service.getAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<SessionDTO>> readById(@PathVariable("id") Integer id) throws Exception {
        Session object = service.getById(id);
        return new ResponseEntity<>(new GenericResponse<>(200, "Succes", Arrays.asList(convertToDTO(object))), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<SessionDTO>> updateSession(@PathVariable("id") Integer id, @Valid @RequestBody SessionDTO dto) throws Exception{
        Session object = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(new GenericResponse<>(200, "Succes", Arrays.asList(convertToDTO(object))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<SessionDTO>> deleteSession(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(new GenericResponse<>(308, "Succes", null), HttpStatus.OK);
    }

    private Session convertToEntity(SessionDTO sessionDTO) {
        return modelMapper.map(sessionDTO, Session.class);
    }

    private SessionDTO convertToDTO(Session session) {
        return modelMapper.map(session, SessionDTO.class);
    } 
}