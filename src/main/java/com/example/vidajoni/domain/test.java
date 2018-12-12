package com.example.vidajoni.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class test {
    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String name;

    private String description;

    private String size;

    private String picture;

/*    @ManyToOne
    private int idBuyer;*/

}



//
//    private String picture;
//
//    private int idBuyer;