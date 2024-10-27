package com.mhk.edj.validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Positive
    private int id;
    @NotBlank
    private String name;
    @Range(min = 10, max = 35)
    private int age;
    @Positive
    private float cgpa;
    @Email
    private String email;
    //@BdPhoneNumber
    private String phone;
}
