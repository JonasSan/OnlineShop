package com.example.vidajoni.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class user {
    @Id
    @GeneratedValue
    private int idUser;

    @NonNull
    private String name;

    @NonNull
    private String userName;

    @NonNull
    private String email;

    private String address;

    private String billingInfo;

    private String phoneNumber;

    @NonNull
    private String password;

    @OneToMany(mappedBy = "createdBy")
    private List<ad> ads = new ArrayList<>();

    public user(@NonNull String name, @NonNull String userName, @NonNull String email, String address, String phoneNumber, @NonNull String password) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    //    @OneToMany(mappedBy = "idBuyer")
//    private List<ad> adsBought = new ArrayList<>();


}

