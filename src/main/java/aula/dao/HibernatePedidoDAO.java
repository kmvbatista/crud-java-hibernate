package aula.dao;

import java.util.List;

import org.hibernate.Session;

import aula.entities.Pedido;

public class HibernatePedidoDAO implements PedidoDAO {

  Session session;
  public HibernatePedidoDAO() {
    Hibernate hibernate = new Hibernate();
    this.session = hibernate.getSessionFactory().openSession();
  }

	@Override
	public void salvar(Pedido pedido) {
		session.beginTransaction();
		session.save(pedido.getPessoa());
		session.save( pedido );
		session.getTransaction().commit();
	}

	@Override
	public void remover(Pedido pedido) {
		session.beginTransaction();
    session.remove( pedido );
    session.getTransaction().commit();
	}

	@Override
	public void atualizar(Pedido pedido) {
		session.beginTransaction();
    session.update( pedido );
    session.getTransaction().commit();
		
	}

	@Override
	public List<Pedido> listar() {
		List<Pedido> result = session.createQuery( "from Pedido" ).list();
    return result;
	}

	@Override
	public Pedido buscarPorId(int id) {
		Pedido endereco = session.get(Pedido.class, id);
    return endereco;
	}
  
}