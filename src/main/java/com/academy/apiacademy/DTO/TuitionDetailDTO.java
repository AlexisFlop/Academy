package com.academy.apiacademy.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TuitionDetailDTO {

    @JsonBackReference
    private TuitionDTO tuition;

    @NotNull
    private SessionDTO session;

    @NotNull
    @NotEmpty
    @NotBlank
    private String classroom;
    
}
