package io.github.hoteltransilvania.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.hoteltransilvania.checkins.model.Checkins;
import io.github.hoteltransilvania.guests.model.Guests;

public interface CheckinsRepository extends JpaRepository<Checkins, Long> {
    @Query(value = "select * from checkins where CURRENT_DATE >= \"dataentrada\" and  CURRENT_DATE <= \"datasaida\"", nativeQuery = true)
    List<Checkins> findCurrentCheckins();
    
    @Query(value = "select * from checkins where CURRENT_DATE < \"dataentrada\" or  CURRENT_DATE > \"datasaida\" ", nativeQuery = true)
    List<Checkins> findOldCheckins();  
    
    @Query(value = "select (max(id)+1) as nextid from checkins ", nativeQuery = true)
    Integer findLastId();
    
    @Query(value = "select * from guests where documento = :val ", nativeQuery = true)
    Guests findGuestById(@Param("val") String val); 
    
    /* Calcular direto na consulta os dias e os valores do checkin e retornar
    @Query(value = "
    "select a.nome, a.documento, b.id as Cod_Checkin, 
    (SELECT DATE_PART('day', "dataentrada"::timestamp) - DATE_PART('day', "datasaida"::timestamp)) as "Qtde Dias", 
    (SELECT DATE_PART('day', "dataentrada"::timestamp) - DATE_PART('day', "datasaida"::timestamp)) * 
    (select valor from prices where tipo='diasuteis')
    as "Valor Gasto"
    from guests a
    inner join checkins b
    on (a.documento=b.hospede)
    order by a.nome  
    List<Checkins> findAllCheckins();  */
}
