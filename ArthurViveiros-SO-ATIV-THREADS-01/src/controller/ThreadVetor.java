package controller;

public class ThreadVetor extends Thread {
	private int[] vet = new int[100];
	private int numero;

	public ThreadVetor(int[] vetor, int num) {
		this.vet = vetor;
		this.numero = num;
	}

	@Override
	public void run() {
		calculaTempo(vet, numero);
	}

	private void calculaTempo(int[] vetor, int num) {
		double tInicial = 0;
		double tFinal = 0;
		double tTotal = 0;

		switch (num) {
		case 1:
			tInicial = System.nanoTime();

			for (int aux : vetor);

			tFinal = System.nanoTime();
			tTotal = tFinal - tInicial;

			System.out.println("Tempo:" + getId() + " com foreach " + tTotal + "ns");

			break;

		case 2:
			tInicial = System.nanoTime();

			for (int i = 0; i < vetor.length; i++) {
			}

			tFinal = System.nanoTime();
			tTotal = tFinal - tInicial;

			System.out.println("Tempo:" + getId() + " com for " + tTotal + "ns");

			break;
		}
	}

}