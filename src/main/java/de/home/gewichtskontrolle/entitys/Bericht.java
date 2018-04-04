package de.home.gewichtskontrolle.entitys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementation of {@link javax.persistence.Entity}
 *
 * @author Anatoly Ekert
 * @version 1.0
* */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bericht {

    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private Date date;
    @Column
    private Integer weight;

    public Bericht(Date date, Integer weight) {


        this.date = date;
        this.weight = weight;
    }
}