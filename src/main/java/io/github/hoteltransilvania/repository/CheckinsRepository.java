package io.github.hoteltransilvania.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.hoteltransilvania.checkins.model.Checkins;

public interface CheckinsRepository extends JpaRepository<Checkins, Long> {

}