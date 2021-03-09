package controller;

public class ThreadSomaMatriz extends Thread {

	int [][] matriz;
	int linha;
	 
	public ThreadSomaMatriz(int[][] matriz, int linha) {
		this.matriz = matriz;
		this.linha = linha;
	}

	@Override
	public void run() {
		soma(matriz, linha);
	}

	private void soma(int[][] matriz, int linha) {
		int soma = 0;
		
		for (int coluna = 0; coluna < 5; coluna++) {
			soma = soma + matriz[linha][coluna];
		}
		
		System.out.println("ThreadId: " + getId() + "\nA soma da linha " + (linha + 1) + " da matriz é: " + soma);
	}
	
}