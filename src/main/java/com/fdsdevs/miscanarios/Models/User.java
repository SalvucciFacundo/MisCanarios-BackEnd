package com.fdsdevs.miscanarios.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message ="Este campo es obligatorio")
    @NotBlank(message="El campo no puede estar en blanco")
    private String name;
    @NotNull(message ="Este campo es obligatorio")
    @NotBlank(message="El campo no puede estar en blanco")
    @Email(message = "El formato no es correcto")
    private String email;
    @NotNull(message ="Este campo es obligatorio")
    @NotBlank(message="El campo no puede estar en blanco")
    @Size(min = 6, max = 12,message = "Debe ser mínimo 6 caracteres y máximo 12 caractes")
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Canary>canaries;

}
