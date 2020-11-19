package com.galaxyware.colaborae.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    protected String username;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String password;


    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="user_authorities",
            joinColumns = {@JoinColumn(name = "userUuid")},
            inverseJoinColumns = {@JoinColumn(name="authorityUuid")})
    protected Set<Authority> authorities = new HashSet<>();

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
    @JsonBackReference
    private List<ServiceModel> services = new ArrayList<ServiceModel>();

    public void addAuthority(Authority a){
        authorities.add(a);
    }

}
