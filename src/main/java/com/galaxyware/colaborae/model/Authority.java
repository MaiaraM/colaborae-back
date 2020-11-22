package com.galaxyware.colaborae.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@SQLDelete(sql = "UPDATE authorities SET deleted_at = NOW() , active = false WHERE uuid=?")
public class Authority extends BaseModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuthority;

    @NotNull
    protected String name;

}
