package dev.kush.countrycity.repository;

import dev.kush.countrycity.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State,Long> {

    @Query(value = "select * from state s where s.country_id=?1",nativeQuery = true)
    List<State> getStatesByCountryId(Long countryId);

    Optional<State> findByStateName(String stateName);
}
