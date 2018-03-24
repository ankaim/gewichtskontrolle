package de.home.gewichtskontrolle.entitys;


import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Bericht {

    @Id
    @GeneratedValue
    @Column
    Integer id;
    @Column
    String data;
    @Column
    Integer weight;
}