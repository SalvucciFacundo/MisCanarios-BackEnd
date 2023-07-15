package com.fdsdevs.miscanarios.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Couples {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date year;
    private Long idMale;
    private Long idFemale;
    private String code;
    private int stanceNum;
    private int eggNum;
    private int bornNum;
    private int fertilizedEggs;
    private Date creationDate;
    private Date updateDate;

}
