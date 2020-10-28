package com.galaxyware.colaborae.model;


import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE addresses SET deleted_at = NOW() , active = false WHERE uuid = ?", check = ResultCheckStyle.COUNT)
public class AddressModel extends BaseModel{

    @NotNull
    protected String address;

    @NotNull
    protected String block;

    @NotNull
    protected Integer number;

    @NotNull
    protected String city;

    @NotNull
    protected String state;

    @NotNull
    protected String zipcode;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "address")
    protected UserModel user;
}
