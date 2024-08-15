package com.simayuygur.springbootlearning.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;

    @NotEmpty(message = "the name and surname cannot be empty! ")
    @Size(min = 1, max = 255 )
    private String teacherFullName;

    @NotEmpty(message = "the email cannot be empty ")
    @Email(message = "email you entered doesnt have the desired format")
    private String teacherEmail;

    @NotEmpty(message = "password cannot be empty")
    @Size(min = 10, max = 18   )
    private String teacherPassword;
}
