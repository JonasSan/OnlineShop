package com.example.vidajoni.domain;


import lombok.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;


@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
public class ad extends Auditable{
    @Id
    @GeneratedValue
    private int id;

   // private LocalDateTime created;

   @ManyToOne
   private user createdBy;

    @NonNull
    private String title;

    private String description;

    private String size;

    private String picture;

    private String price;

//    @ManyToOne
//    private int idBuyer;

    private Boolean isForSale = true;


    public ad(@NonNull String title, String description, String size, String picture, String price) {
        this.title = title;
        this.description = description;
        this.size = size;
        this.picture = picture;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
}
