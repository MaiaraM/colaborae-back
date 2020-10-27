package com.galaxyware.colaborae.model;


import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE ratings SET deleted_at = NOW() , active = false WHERE uuid = ?", check = ResultCheckStyle.COUNT)
public class RatingModel extends BaseModel{

    @NotNull
    protected String comment;

    @NotNull
    protected Integer rating;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    protected ServiceModel service;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    protected UserModel evaluator;
}
