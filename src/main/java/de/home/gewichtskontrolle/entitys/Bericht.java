package de.home.gewichtskontrolle.entitys;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Implementation of {@link javax.persistence.Entity}
 *
 * @author Anatoly Ekert
 * @version 1.0
* */

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