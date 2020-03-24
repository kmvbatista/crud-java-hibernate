package aula.dao;

import java.util.List;

import aula.entities.Pessoa;

public interface PessoaDAO {
	public void salvar (Pessoa pessoa);    
	public void remover (Pessoa pessoa);   
	public void atualizar (Pessoa pessoa);	
	public List<Pessoa> listar();    
	public Pessoa buscarPorId(int id);
}
