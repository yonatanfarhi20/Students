package org.example.students.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentDTO {

    @Size(max = 30)
    private String username;

    @Min(18)
    @Max(60)
    private int age;
}