package aula.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "Pedido" )
public class Pedido {

  @Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
  private int id;
  private int numeroPedido;
  private int valor;
  @JoinColumn(name = "pessoaId")
  @OneToOne
  private Pessoa pessoa;

  public int getId() {
    return id;
  }
  public int getValor() {
    return valor;
  }
  public void setValor(int valor) {
    this.valor = valor;
  }
  public int getPessoaId() {
    return pessoa.getId();
  }

  public int getNumeroPedido() {
    return numeroPedido;
  }
  public void setNumeroPedido(int numeroPedido) {
    this.numeroPedido = numeroPedido;
  }
  public void setId(int id) {
    this.id = id;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa= pessoa;
  }

  public Pessoa getPessoa() {
    return this.pessoa;
  }
}