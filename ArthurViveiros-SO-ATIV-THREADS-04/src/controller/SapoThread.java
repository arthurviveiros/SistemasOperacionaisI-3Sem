package controller;

public class SapoThread extends Thread {

	private int distancia;
	private int saltoParcial;
	private int saltoTotal;
	private boolean fimCorrida;
	private int totalCorrida = 80;
	private int posicao = 1;
	
	public SapoThread(int i) {
		this.distancia = 0;
		this.saltoParcial = 0;
		this.saltoTotal = 0;
		this.fimCorrida = false;
	}

	@Override
	public void run() {
		corrida();
	}

	public void corrida() {
		while (!fimCorrida) {
			saltoParcial = getRandomNumber();
			saltoTotal++;
			distancia += saltoParcial;
			System.out.println("O sapo " + getId() + " saltou " + saltoParcial + " metros e percorreu no total " + distancia + " metros");
			System.out.println();
			fimCorrida = ranking(distancia, getId(), fimCorrida, saltoTotal);
			aguardar();
		}

	}

	public boolean ranking(int distanciaMaxima, long sapoId, boolean fimCorrida, int saltoTotal) {
		if (distanciaMaxima >= totalCorrida) {
				System.out.println("O Sapo " +  sapoId + " terminou em " + posicao + "° lugar");
				System.out.println("\nO Sapo " + sapoId + " chegou na " +  posicao + "° posicao com " + saltoTotal+ " saltos e percorreu " + distanciaMaxima + " metros");
				posicao = posicao + 1;
				return true;        
		}
		return false;
	}
	
	private void aguardar() {
		int aguardar = (int) ((Math.random() * (50 - 1) + 50));
		try {
			sleep(aguardar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static int getRandomNumber() {
		return (int) ((Math.random() * (10 - 1) + 1));
	}

}