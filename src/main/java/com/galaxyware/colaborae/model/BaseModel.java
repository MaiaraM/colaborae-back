package com.galaxyware.colaborae.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {

    @Id
    @GeneratedValue(generator = "UUID")
    protected UUID uuid;

    @CreatedDate
    protected Date createAt;

    @LastModifiedDate
    protected Date modifiedAt;

    protected Date deletedAt;

    protected Boolean active = true;


}
