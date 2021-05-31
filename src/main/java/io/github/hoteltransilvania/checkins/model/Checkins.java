package io.github.hoteltransilvania.checkins.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Checkins {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String fk_hospede;
		
	@Column
	private LocalDateTime dataEntrada;
	
	@Column
	private LocalDateTime dataSaida;	
	
	@Column
	private boolean veiculo;
}
