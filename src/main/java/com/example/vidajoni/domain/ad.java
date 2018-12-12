package com.example.vidajoni.domain;


import lombok.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;


@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
public class ad {
    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String description;

    private String size;

    private String picture;

    private int idBuyer;
}
