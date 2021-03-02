package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {

	public RedesController() {
		super();
	}

	String res;

	public void ip(String osName) {

		if (osName.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();

				while (linha != null) {

					if (linha.contains("Adaptador")) {
						res = res + linha + "\n";
					}
					if (linha.contains("IPv4")) {
						res = res + linha + "\n\n";
					}

					linha = buffer.readLine();

				}

				JOptionPane.showMessageDialog(null, res);
				res = " ";

				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Um erro ocorrou, não foi possível obter suas configurações de IP\nErro: " + e.getMessage());
				e.printStackTrace();
			}

		} else {

			try {
				Process p = Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();

				while (linha != null) {

					if (linha.contains("flags")) {
						res = res + linha + "\n";
					}
					if (linha.contains("netmask")) {
						res = res + linha + "\n";
					}

					linha = buffer.readLine();

				}

				JOptionPane.showMessageDialog(null, res);
				res = " ";

				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Um erro ocorrou, não foi possível obter suas configurações de IP\nErro: " + e.getMessage());
				e.printStackTrace();
			}
		}

	}

	public void ping(String osName) {

		int total = 0;

		if (osName.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("ping -n 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();

				JOptionPane.showMessageDialog(null, "Aguarde um momento, este processo pode demorar alguns segundos");

				while (linha != null) {
					if (linha.contains("tempo=")) {
						int beginIndex = linha.indexOf("tempo=");
						int endIndex = linha.indexOf("ms");

						total = total + Integer.parseInt(linha.substring(beginIndex + 6, endIndex));
					}

					linha = buffer.readLine();
				}

				JOptionPane.showMessageDialog(null, "A média de ping foi de: " + (total / 10) + " ms");

				fluxo.close();
				leitor.close();
				buffer.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Um erro ocorrou, não foi possível realizar o Ping\nErro: " + e.getMessage());
				e.printStackTrace();
			}

		} else {

			try {
				Process p = Runtime.getRuntime().exec("ping -c 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();

				JOptionPane.showMessageDialog(null, "Aguarde um momento, este processo pode demorar alguns segundos");

				while (linha != null) {
					if (linha.contains("tempo=")) {
						int beginIndex = linha.indexOf("tempo=");
						int endIndex = linha.indexOf("ms");

						total = total + Integer.parseInt(linha.substring(beginIndex + 6, endIndex));
					}

					linha = buffer.readLine();
				}

				JOptionPane.showMessageDialog(null, "A média de ping foi de: " + (total / 10) + " ms");

				fluxo.close();
				leitor.close();
				buffer.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Um erro ocorrou, não foi possível realizar o Ping\nErro: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
