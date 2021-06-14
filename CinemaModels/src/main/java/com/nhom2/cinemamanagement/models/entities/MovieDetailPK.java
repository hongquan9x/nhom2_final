package com.nhom2.cinemamanagement.models.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
public class MovieDetailPK implements Serializable {

    private Integer movieID;
    private String image;

}
