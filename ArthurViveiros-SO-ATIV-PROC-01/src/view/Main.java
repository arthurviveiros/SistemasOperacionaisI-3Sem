package view;

import controller.RedesController;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		RedesController redes = new RedesController();
		
		int choose = 0;

		System.out.print("Arthur Viveiros - RA: 1110482012024\n"); 
		System.out.print("Sistemas Operacionais I - Fatec ZL");
		System.out.print("Exercícios_Processos - Exercício 01");
		
		do {
			choose = Integer.parseInt(JOptionPane.showInputDialog("----------------------------------------------------------------------"
					+ "\nDigite 1 para saber seu Adaptador Ethernet e IPv4."
					+ "\nDigite 2 para ver o seu tempo médio de ping."
					+ "\nCaso você quiser encerrar o programa, digite 0"
					+ "\n----------------------------------------------------------------------", JOptionPane.QUESTION_MESSAGE));
			
			switch(choose) {
			case 1: redes.ip(System.getProperty("os.name")); break;
			case 2: redes.ping(System.getProperty("os.name")); break;
			}
		} while(choose != 0);
	}

}
