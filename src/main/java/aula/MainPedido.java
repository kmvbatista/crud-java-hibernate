package aula;
import java.util.List;

import aula.dao.HibernatePedidoDAO;
import aula.dao.PedidoDAO;
import aula.entities.Pedido;
import aula.entities.Pessoa;

public class MainPedido {

	public static void imprimir(List<Pedido> lista) {
		System.out.println("Imprimindo lista...");
		for(Pedido pe : lista) {
			System.out.println("ID: " + pe.getId());
			System.out.println("Numero Pedido: "+pe.getNumeroPedido());
			System.out.println("Valor: " + pe.getValor());
			imprimirPessoa(pe.getPessoa());
			System.out.println("");
		}
		System.out.println("----------------------------");
	}

	public static void imprimirPessoa(Pessoa p) {
		System.out.print("Pessoa: ");
		System.out.print(p.getId() + " ");
		System.out.print(p.getPrimeiroNome()+ " ");
		System.out.print(p.getUltimoNome()+ " ");
		System.out.print(p.getIdade()+ " ");
		System.out.println(p.getProfissao());
	}

	
	public static void imprimirPedido(Pedido p) {
		System.out.print("Pedido: ");
		System.out.println("ID: " + p.getId());
		System.out.println("Numero Pedido: "+p.getNumeroPedido());
		System.out.println("Valor: " + p.getValor());
		imprimirPessoa(p.getPessoa());
	}

	public static void main(String[] args) {

		PedidoDAO banco = new HibernatePedidoDAO();
//		PedidoDAO banco = new JDBCPedidoDAO();

		imprimir(banco.listar());

		Pessoa p1 = new Pessoa();
		p1.setPrimeiroNome("Cris");
		p1.setProfissao("Jogador");
		p1.setUltimoNome("Ronaldo");
		p1.setIdade(30);		
		
		Pedido pedido = new Pedido();
		pedido.setPessoa(p1);
		pedido.setNumeroPedido(130);
		pedido.setValor(80000);
		banco.salvar(pedido);

		pedido = banco.buscarPorId(8);
		imprimirPedido(pedido);
		
		pedido.getPessoa().setPrimeiroNome("Cristiano");
		pedido.setValor(200000);
		
		banco.atualizar(pedido);

		imprimirPedido(banco.buscarPorId(8));

		imprimir(banco.listar());

		banco.remover(pedido);

		imprimir(banco.listar());

	}

}

//SAIDA ESPERADA
//Imprimindo lista...
//ID: 1
//Numero Pedido: 123
//Valor: 3123
//Pessoa: 1 Tamer Cavalcante 28 Professor
//
//ID: 2
//Numero Pedido: 124
//Valor: 13445
//Pessoa: 1 Tamer Cavalcante 28 Professor
//
//ID: 3
//Numero Pedido: 125
//Valor: 12344
//Pessoa: 1 Tamer Cavalcante 28 Professor
//
//ID: 4
//Numero Pedido: 126
//Valor: 87879
//Pessoa: 2 Lucas Bueno 25 Professor
//
//ID: 5
//Numero Pedido: 127
//Valor: 12266
//Pessoa: 2 Lucas Bueno 25 Professor
//
//ID: 6
//Numero Pedido: 128
//Valor: 223
//Pessoa: 3 Glaucio Wachinski 39 Professor
//
//ID: 7
//Numero Pedido: 129
//Valor: 77898
//Pessoa: 3 Glaucio Wachinski 39 Professor
//
//----------------------------
//Pedido: ID: 8
//Numero Pedido: 130
//Valor: 80000
//Pessoa: 11 Cris Ronaldo 30 Jogador
//Pedido: ID: 8
//Numero Pedido: 130
//Valor: 200000
//Pessoa: 11 Cristiano Ronaldo 30 Jogador
//Imprimindo lista...
//ID: 1
//Numero Pedido: 123
//Valor: 3123
//Pessoa: 1 Tamer Cavalcante 28 Professor
//
//ID: 2
//Numero Pedido: 124
//Valor: 13445
//Pessoa: 1 Tamer Cavalcante 28 Professor
//
//ID: 3
//Numero Pedido: 125
//Valor: 12344
//Pessoa: 1 Tamer Cavalcante 28 Professor
//
//ID: 4
//Numero Pedido: 126
//Valor: 87879
//Pessoa: 2 Lucas Bueno 25 Professor
//
//ID: 5
//Numero Pedido: 127
//Valor: 12266
//Pessoa: 2 Lucas Bueno 25 Professor
//
//ID: 6
//Numero Pedido: 128
//Valor: 223
//Pessoa: 3 Glaucio Wachinski 39 Professor
//
//ID: 7
//Numero Pedido: 129
//Valor: 77898
//Pessoa: 3 Glaucio Wachinski 39 Professor
//
//ID: 8
//Numero Pedido: 130
//Valor: 200000
//Pessoa: 11 Cristiano Ronaldo 30 Jogador
//
//----------------------------
//Imprimindo lista...
//ID: 1
//Numero Pedido: 123
//Valor: 3123
//Pessoa: 1 Tamer Cavalcante 28 Professor
//
//ID: 2
//Numero Pedido: 124
//Valor: 13445
//Pessoa: 1 Tamer Cavalcante 28 Professor
//
//ID: 3
//Numero Pedido: 125
//Valor: 12344
//Pessoa: 1 Tamer Cavalcante 28 Professor
//
//ID: 4
//Numero Pedido: 126
//Valor: 87879
//Pessoa: 2 Lucas Bueno 25 Professor
//
//ID: 5
//Numero Pedido: 127
//Valor: 12266
//Pessoa: 2 Lucas Bueno 25 Professor
//
//ID: 6
//Numero Pedido: 128
//Valor: 223
//Pessoa: 3 Glaucio Wachinski 39 Professor
//
//ID: 7
//Numero Pedido: 129
//Valor: 77898
//Pessoa: 3 Glaucio Wachinski 39 Professor
//
//----------------------------

