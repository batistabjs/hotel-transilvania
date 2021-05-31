package io.github.hoteltransilvania.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.hoteltransilvania.checkins.model.Checkins;

public interface CheckinsRepository extends JpaRepository<Checkins, Long> {
    @Query(value = "select * from checkins where documento like %:val% ", nativeQuery = true)
    List<Checkins> findGuestsByDocLike(@Param("val") String val);
    
	@Query(value = "select * from checkins where nome like %:val% ", nativeQuery = true)
    List<Checkins> findGuestsByNameLike(@Param("val") String val);
    
    @Query(value = "select * from checkins where telefone like %:val% ", nativeQuery = true)
    List<Checkins> findGuestsByTelLike(@Param("val") String val); 
}