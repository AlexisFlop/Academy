package com.academy.apiacademy.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericResponse<T> {
    private Integer Status;
    private String message;
    private List<T> data;  
}
