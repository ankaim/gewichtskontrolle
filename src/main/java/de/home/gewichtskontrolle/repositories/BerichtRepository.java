package de.home.gewichtskontrolle.repositories;

import de.home.gewichtskontrolle.entitys.Bericht;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BerichtRepository extends JpaRepository<Bericht, Integer> {
}
