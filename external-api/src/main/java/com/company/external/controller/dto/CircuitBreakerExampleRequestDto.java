package com.company.external.controller.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CircuitBreakerExampleRequestDto {

    @NotBlank
    @Size(min = 3, max = 50)
    @Parameter(description = "사용자 이름", example = "JohnDoe")
    private String username;

    @NotBlank
    @Email
    @Parameter(description = "사용자 이메일 주소", example = "johndoe@example.com")
    private String email;

    @NotBlank
    @Size(min = 6, max = 12)
    @Parameter(description = "사용자 비밀번호 (6자 이상 12자 이하)", example = "abcd1234")
    private String password;

}
