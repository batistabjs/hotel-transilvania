package io.github.hoteltransilvania.checkins.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="checkins")
public class Checkins {
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "hospede")
	private String hospede;
		
	@Column(name = "dataentrada")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm")
	private LocalDateTime dataentrada;
	
	@Column(name = "datasaida")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm")
	private LocalDateTime datasaida;	
	
	@Column(name = "adicionalveiculo")
	private Boolean adicionalveiculo;
}
