package com.galaxyware.colaborae.model;


import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deletedAt = NOW()::timestamp, active = false WHERE uuid = ?", check = ResultCheckStyle.COUNT)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel extends BaseModel{

    @NotNull
    protected String name;
}
