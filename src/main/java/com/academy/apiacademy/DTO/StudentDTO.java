package com.academy.apiacademy.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
    private Integer idStudent;

    @NotBlank
    @NotNull
    @NotEmpty
    private String firstName;

    @NotBlank
    @NotNull
    @NotEmpty
    private String lastName;

    @NotBlank
    @NotNull
    @NotEmpty
    private String dni;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;
}
