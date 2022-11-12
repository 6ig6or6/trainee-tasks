package org.example.shop.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "Password shouldn't be empty!")
    private String password;
}
