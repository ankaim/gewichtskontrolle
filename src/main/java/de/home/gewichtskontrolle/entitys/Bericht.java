package de.home.gewichtskontrolle.entitys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String data;
    private Integer weight;
}