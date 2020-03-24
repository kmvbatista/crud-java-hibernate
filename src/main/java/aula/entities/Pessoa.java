package aula.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "Pessoa" )
public class Pessoa {
  @Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
  private int id;
  private String primeiroNome;
  private String ultimoNome;
  private String profissao;
  private int idade;

  public int getId() {
    return id;
  }

  public String getPrimeiroNome() {
    return primeiroNome;
  }

  public String getUltimoNome() {
    return ultimoNome;
  }

  public String getProfissao() {
    return profissao;
  }

  public int getIdade() {
    return idade;
  }
  
  public void setId(int id) {
    this.id = id;
  }

  public void setPrimeiroNome(String primeiroNome) {
    this.primeiroNome = primeiroNome;
  }

  public void setUltimoNome(String ultimoNome) {
    this.ultimoNome = ultimoNome;
  }

  public void setProfissao(String profissao) {
    this.profissao = profissao;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }
}