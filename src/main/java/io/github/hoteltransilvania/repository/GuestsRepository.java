package io.github.hoteltransilvania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.hoteltransilvania.guests.model.Guests;

public interface GuestsRepository extends JpaRepository<Guests, String> {

}
