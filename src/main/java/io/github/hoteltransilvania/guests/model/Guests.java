package io.github.hoteltransilvania.guests.model;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

//em tempo de compilação, o lombok vai gerar nossos getters e setters
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Guests {	
	@Column
	private String nome;
	
	@Id		
	@Column
	private String documento;
	
	@Column	
	private String telefone;		
}
