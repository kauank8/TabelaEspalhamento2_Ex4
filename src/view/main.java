package view;

import javax.swing.JOptionPane;

import controller.DepartamentosController;

public class main {

	public static void main(String[] args) {
		int opc=0;
		DepartamentosController dp = new DepartamentosController();
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog("1-Inserir Produto\n2-Consultar Andar\n3-Ecluir Produto\n9-Finalizar"));
			switch(opc) {
			case 1: dp.run(opc);
					break;
			case 2: dp.run(opc);
			break;
			case 3: dp.run(opc);
			break;
			case 9: JOptionPane.showMessageDialog(null, "Sistema Finalizado");
			break;
			default : JOptionPane.showMessageDialog(null, "Opção Invalida");
			}
		}while(opc!=9);
	}

}
