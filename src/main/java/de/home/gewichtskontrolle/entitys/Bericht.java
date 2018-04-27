package de.home.gewichtskontrolle.entitys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class Bericht {

    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private String data;
    @Column
    private Integer weight;
}