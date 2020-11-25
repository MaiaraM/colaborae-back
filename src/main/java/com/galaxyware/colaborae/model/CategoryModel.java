package com.galaxyware.colaborae.model;


import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE categories SET deleted_at = NOW() , active = false WHERE uuid = ?", check = ResultCheckStyle.COUNT)
public class CategoryModel extends BaseModel{

    @NotNull
    @Column(unique = true)
    protected String name;

    @NotNull
    protected String descricao;

    @OneToMany(mappedBy = "category")
    private List<ServiceModel> services = new ArrayList<ServiceModel>();


}
