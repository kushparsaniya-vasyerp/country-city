package dev.kush.countrycity.repository;

import dev.kush.countrycity.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    @Query(value = "select * from city c where state_id=?1",nativeQuery = true)
    List<City> getCitiesByStateId(Long stateId);
}
