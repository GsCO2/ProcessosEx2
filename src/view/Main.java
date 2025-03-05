package view;
import controller.KillController;

import javax.swing.JOptionPane;
public class Main {
	public static void main(String[] args) {
		KillController kc = new KillController();
		int opc = 0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Configuração de IP\n2 - Tempo médio do ping\n9 - FIM"));
			switch(opc) {
			case 1:
				kc.listaProcessos();
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "FIM");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida");
				break;
			}
		}
	}
}
