package view;
import controller.KillController;

import javax.swing.JOptionPane;
public class Main {
	public static void main(String[] args) {
		KillController kc = new KillController();
		int opc = 0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Lista Processos\n2 - Mata PID\n3 - Mata Nome \n9 - FIM"));
			switch(opc) {
			case 1:
				kc.listaProcessos();
				break;
			case 2:
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID a ser morto"));
				kc.mataPid(pid);
				break;
			case 3:
				String nome = JOptionPane.showInputDialog("Digite o nome a ser morto(com a extensão .exe .txt, etc)");
				kc.mataNome(nome);
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
