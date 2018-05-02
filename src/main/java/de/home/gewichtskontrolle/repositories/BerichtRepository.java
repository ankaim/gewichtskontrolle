package de.home.gewichtskontrolle.repositories;

import de.home.gewichtskontrolle.entitys.Bericht;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
* Implementation of{@link org.springframework.stereotype.Repository}
 *
 * @author Anatoly Ekert
 * @version 1.0
* */

@Repository
public interface BerichtRepository extends JpaRepository<Bericht, Integer> {
}
