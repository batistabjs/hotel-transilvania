package io.github.hoteltransilvania.guests.model;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

//em tempo de compilação, o lombok vai gerar nossos getters e setters
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Guests {	
	@Column
	@NotBlank(message = "Nome é obrigatório")	
	private String nome;
	
	@Id		
	@Column
	@NotBlank(message = "Documento é obrigatório")
	private String documento;
	
	@Column	
	@NotBlank(message = "Telefone é obrigatório")
	private String telefone;		
}
