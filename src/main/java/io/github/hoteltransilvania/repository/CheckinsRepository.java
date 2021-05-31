package io.github.hoteltransilvania.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.hoteltransilvania.checkins.model.Checkins;
import io.github.hoteltransilvania.guests.model.Guests;

public interface CheckinsRepository extends JpaRepository<Checkins, Long> {
    @Query(value = "select * from checkins where CURRENT_DATE >= \"dataEntrada\" and  CURRENT_DATE <= \"dataSaida\"", nativeQuery = true)
    List<Checkins> findCurrentCheckins();
    
    @Query(value = "select * from checkins where CURRENT_DATE < \"dataEntrada\" or  CURRENT_DATE > \"dataSaida\" ", nativeQuery = true)
    List<Checkins> findOldCheckins();  
    
    @Query(value = "select * from checkins ", nativeQuery = true)
    List<Checkins> findAllCheckins();
    
    @Query(value = "select (max(id)+1) as nextid from checkins ", nativeQuery = true)
    Integer findLastId();
    
    @Query(value = "select * from guests where documento = :val ", nativeQuery = true)
    Guests findGuestById(@Param("val") String val); 
}
