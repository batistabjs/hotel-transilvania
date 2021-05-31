package io.github.hoteltransilvania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.hoteltransilvania.prices.model.Prices;

public interface PricesRepository extends JpaRepository<Prices, String> {

}