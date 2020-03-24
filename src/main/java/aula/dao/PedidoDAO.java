package aula.dao;
import java.util.List;

import aula.entities.Pedido;

public interface PedidoDAO {
	
	public void salvar (Pedido pedido);    
	public void remover (Pedido pedido);   
	public void atualizar (Pedido pedido);	
	public List<Pedido> listar();    
	public Pedido buscarPorId(int id);
	
}
