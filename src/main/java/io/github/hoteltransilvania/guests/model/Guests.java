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
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long id;
	
	@Column
	private String nome;
	
	@Id		
	@Column
	private String documento;
	
	@Column	
	private String telefone;	
	
	/*@Column	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data_cadastro;
	
	@PrePersist
	public void beforeSave(){
		setData_cadastro(LocalDateTime.now());
		
	} */
	
}
