package com.fdsdevs.miscanarios.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Canary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message ="Este campo es obligatorio")
    @NotBlank(message="El campo no puede estar en blanco")
    private String origin;
    private int ringNumber;
    @NotNull(message ="Este campo es obligatorio")
    @NotBlank(message="El campo no puede estar en blanco")
    private String gender;
    private String nomenclature;
    private String ringColor;
    @NotNull(message ="Este campo es obligatorio")
    @NotBlank(message="El campo no puede estar en blanco")
    private String status;
    private String statusNotes;
    private Long idFather;
    private Long idMother;
    private String notes;
    @NotNull(message ="Este campo es obligatorio")
    @NotBlank(message="El campo no puede estar en blanco")
    private Date year;
    @NotNull(message ="Este campo es obligatorio")
    @NotBlank(message="El campo no puede estar en blanco")
    private int stance;
    private boolean available;
    private Date dateCreation;
    private Date dateUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;


}
