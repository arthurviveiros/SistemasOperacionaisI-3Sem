package view;

import controller.Cliente;

public class Main {

	public static void main(String[] args) {

		for (int idCliente = 0; idCliente < 100; idCliente++) {
			Cliente threadCompraIngresso = new Cliente(idCliente);
			threadCompraIngresso.start();
		}

	}

}