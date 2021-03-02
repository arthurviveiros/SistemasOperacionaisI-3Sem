package view;

import javax.swing.JOptionPane;

import controller.ProcessosController;

public class Main {

	public static void main(String[] args) {
		ProcessosController procController = new ProcessosController();
		
		int choose = 0;

		System.out.print("Arthur Viveiros - RA: 1110482012024\n"); 
		System.out.print("Sistemas Operacionais I - Fatec ZL");
		System.out.print("Exercícios_Processos - Exercício 02");
		
		do {
			choose = Integer.parseInt(JOptionPane.showInputDialog("----------------------------------------------------------------------"
					+ "\nDigite 1 para ver os processos ativos."
					+ "\nDigite 2 para utilizar o PID para matar um processo."
					+ "\nDigite 3 para utilizar o NOME para matar um processo"
					+ "\nCaso você quiser encerrar o programa, digite 0"
					+ "\n----------------------------------------------------------------------", JOptionPane.QUESTION_MESSAGE));
			
			switch(choose) {
			case 1: procController.ver(procController.identiSO()); break;
			case 2: procController.matarPID(procController.identiSO(),Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo que você deseja matar."))); break;
			case 3: procController.matarNome(procController.identiSO(),JOptionPane.showInputDialog("Digite o NOME do processo que você deseja matar.")); break;
			}
		} while(choose != 0);
	}

}