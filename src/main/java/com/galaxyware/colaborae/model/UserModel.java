package com.galaxyware.colaborae.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE users SET deleted_at = NOW() , active = false WHERE uuid = ?", check = ResultCheckStyle.COUNT)
public class UserModel extends BaseModel{

    @NotNull
    protected String firstName;

    @NotNull
    protected String lastName;

    @NotNull
    protected String email;

    @NotNull
    @Column(unique = true)
    protected String document;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_uuid", referencedColumnName = "uuid")
    protected AddressModel address;

    @Column(length = 800)
    protected String description;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_favorite", joinColumns = @JoinColumn(name = "user_uuid"), inverseJoinColumns = @JoinColumn(name = "service_uuid"))
    private List<ServiceModel> favorites = new ArrayList<ServiceModel>();

    @OneToMany(mappedBy = "user")
    private List<ServiceModel> services = new ArrayList<ServiceModel>();

}
