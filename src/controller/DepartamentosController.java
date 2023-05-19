package controller;

import javax.swing.JOptionPane;

import br.com.KauanPaulino.ListaObject.Lista_Object;
import model.Produto;

public class DepartamentosController {
	Lista_Object[] vtlista = new Lista_Object[4];

	public DepartamentosController() {

		for (int i = 0; i < 4; i++) {
			vtlista[i] = new Lista_Object();
		}
	}

	public void run(int n) {
		switch (n) {
		case 1:
			inserir();
			break;
		case 2:
			consulta();
			break;
		case 3:
			excluirP();
			break;
		default:
			break;
		}
	}

	private void inserir() {
		Produto p = new Produto();
		// Verifica andar
		int andar;
		do {
			andar = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite o andar do produto\n0-Terreo\n1-Primeiro Andar\n2-Segundo Andar\n3-Terceiro Andar"));
			switch (andar) {
			case 0:
				andar = 0;
				break;
			case 1:
				andar = 1;
				break;
			case 2:
				andar = 2;
				break;
			case 3:
				andar = 3;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Andar Invalido");
				break;
			}
		} while (andar != 0 && andar != 1 && andar != 2 && andar != 3);

		// Monta Produto
		p.setAndar(andar);
		p.setDescriscao(JOptionPane.showInputDialog("Digite o nome do produto"));
		p.setNomeDepartamento(JOptionPane.showInputDialog("Digite o nome do Departamento"));

		// recebe hash
		int hash = Hashcode(andar);

		// Monta Tabela
		GeraTabela(p, hash);
	}

	// Gera Tabela
	private void GeraTabela(Produto p, int hash) {
		if (vtlista[hash].isEmpty()) {
			vtlista[hash].addFirst(p);
		} else {
			try {
				vtlista[hash].addLast(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Hashcode
	private int Hashcode(int n) {
		int pos = n % 4;
		return pos;
	}

	private void consulta() {
		int andar = Integer.parseInt(JOptionPane.showInputDialog("Digite o andar que deseja consultar os produtos"));
		if (andar >= 0 && andar < 4) {
			int hash = Hashcode(andar);
			int tamanho = vtlista[hash].size();
			System.out.println("\nAndar:" + hash);
			for (int i = 0; i < tamanho; i++) {
				Produto p = new Produto();
				try {
					p = (Produto) vtlista[hash].get(i);
					System.out.println(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Andar Invalido");
		}

	}

	private void excluirP() {
		int andar = Integer
				.parseInt(JOptionPane.showInputDialog("Digite o andar que deseja consultar para exclui o produto"));
		int tamanho = vtlista[andar].size();
		int hash = Hashcode(andar);
		for (int i = 0; i < tamanho; i++) {
			Produto p = new Produto();
			try {
				p = (Produto) vtlista[hash].get(i);
				System.out.println(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String nome = JOptionPane.showInputDialog("Digite o nome do produto que deseja excluir");
		Boolean status = false;
		for (int i = 0; i < tamanho; i++) {
			Produto p = new Produto();
			try {
				p = (Produto) vtlista[hash].get(i);
				if (p.getDescriscao().equals(nome)) {
					System.out.println("O " + p + " Foi Excluido!!!!!");
					vtlista[hash].remove(i);
					status = true;
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (!status) {
			JOptionPane.showMessageDialog(null, "O produto não existe");
		}
	}

}
