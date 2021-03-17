package controller;

public class Cliente extends Thread{
		
	private int idCliente;
	private int ingressosRestantes = 100;
	
	public Cliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void run() {
		login();
		processo();
		compra();
 }

	private void login() {
		long tempoLogin = (int) Math.floor(Math.random() * 2000) + 50;
		System.out.println("O Cliente #" + idCliente + " está fazendo login!");
		System.out.println(tempoLogin);
		
		try {
			sleep(tempoLogin);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (tempoLogin > 1000) {
			System.out.println("O Cliente #" + idCliente + " sofreu timeout no login!");
			Thread.currentThread().interrupt();
		}
		System.out.println("O Cliente #" + idCliente + " fez login!");
	}
	
	private void processo() {
		long tempoCompra = (int) Math.floor(Math.random() * 3000) + 1000;
		System.out.println("O Cliente #" + idCliente + " está comprando!");
		
		try {
			sleep(tempoCompra);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (tempoCompra > 2500) {
			System.out.println("O Cliente #" + idCliente + " sofreu timeout na compra!");
			Thread.currentThread().interrupt();
		}
		
	}
	
	private void compra() {
		int qtdIngressos = (int) Math.floor(Math.random() * 4) + 1;
		int ingressosRestantes = getIngressosRestantes();
		System.out.println(ingressosRestantes);
		if (ingressosRestantes >= 0) {
			if ((ingressosRestantes - qtdIngressos) < 0) {
				System.out.println("O Cliente #" + idCliente + " não conseguiu comprar a tempo, acabou os ingressos!");
			} else {
				setIngressosRestantes(ingressosRestantes - qtdIngressos);
				System.out.println("O Cliente #" + idCliente + " comprou " + qtdIngressos + " ingressos!");
				System.out.println("Restam: " + (ingressosRestantes - qtdIngressos) + " ingressos");
			}

		} else {
			System.out.println("O Cliente #" + idCliente + " não conseguiu comprar a tempo, acabou os ingressos!");
		}
	}

	public int getIngressosRestantes() {
		return ingressosRestantes;
	}

	public void setIngressosRestantes(int ingressosRestantes) {
		this.ingressosRestantes = ingressosRestantes;
	}

}
