package aula.dao;

import java.util.List;

import aula.entities.Pessoa;

import org.hibernate.Session;

public class HibernatePessoaDAO implements PessoaDAO {

  Session session;
  Hibernate hibernate = new Hibernate();
  public HibernatePessoaDAO() {
    this.session = hibernate.getSessionFactory().openSession();
  }

	@Override
	public void salvar(Pessoa pessoa) {
    session.beginTransaction();
		session.save( pessoa );
		session.getTransaction().commit();
	}

	@Override
	public void remover(Pessoa pessoa) {
		session.beginTransaction();
    session.remove( pessoa );
    session.getTransaction().commit();
	}

	@Override
	public void atualizar(Pessoa pessoa) {
		session.beginTransaction();
    session.update( pessoa );
    session.getTransaction().commit();
		
	}

	@Override
	public List<Pessoa> listar() {
		List<Pessoa> result = session.createQuery( "from Pessoa" ).list();
    return result;
	}

	@Override
	public Pessoa buscarPorId(int id) {
		Pessoa endereco = session.get(Pessoa.class, id);
    return endereco;
	}

}