package com.galaxyware.colaborae.model;


import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "services")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE services SET deleted_at = NOW() , active = false WHERE uuid = ?", check = ResultCheckStyle.COUNT)
public class ServiceModel extends BaseModel{

    @NotNull
    protected String title;

    @NotNull
    protected String description;

    @NotNull
    protected Double value;

    protected Date time;

    @NotNull
    @ManyToOne
    protected UserModel user;

    @OneToMany(mappedBy = "service")
    private List<RatingModel> rating = new ArrayList<RatingModel>();
}
