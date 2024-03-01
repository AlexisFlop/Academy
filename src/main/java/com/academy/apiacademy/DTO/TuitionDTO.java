package com.academy.apiacademy.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TuitionDTO {

    private Integer idTuition;

    private LocalDateTime date = LocalDateTime.now();

    @NotNull
    private StudentDTO student;

    @JsonManagedReference
    @NotNull
    private List<TuitionDetailDTO> tuitionDetails;

    @NotNull
    private boolean status;


    
}
