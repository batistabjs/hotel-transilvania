package io.github.hoteltransilvania.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.hoteltransilvania.guests.model.Guests;

public interface GuestsRepository extends JpaRepository<Guests, String> {
    @Query(value = "select * from guests where documento like %:val% ", nativeQuery = true)
    List<Guests> findGuestsByDocLike(@Param("val") String val);
    
	@Query(value = "select * from guests where nome like %:val% ", nativeQuery = true)
    List<Guests> findGuestsByNameLike(@Param("val") String val);
    
    @Query(value = "select * from guests where telefone like %:val% ", nativeQuery = true)
    List<Guests> findGuestsByTelLike(@Param("val") String val); 
}
