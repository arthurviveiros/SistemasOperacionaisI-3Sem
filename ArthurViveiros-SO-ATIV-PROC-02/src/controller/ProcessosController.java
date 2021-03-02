package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class ProcessosController {

	public ProcessosController() {
		super();
	}

	public String identiSO() {
		return System.getProperty("os.name");
	}

	public void ver(String osName) {

		if (osName.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();

				while (linha != null) {

					System.out.println(linha);

					linha = buffer.readLine();
				}
				System.out.println();

				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Um erro ocorrou, não foi possível ver a lista de tasks\nErro: " + e.getMessage());
				e.printStackTrace();
			}

		} else {

			try {
				Process p = Runtime.getRuntime().exec("ps");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();

				while (linha != null) {

					System.out.println(linha);

					linha = buffer.readLine();
				}
				System.out.println();

				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Um erro ocorrou, não foi possível ver a lista de tasks\nErro: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public void matarPID(String osName, int PID) {

		if (osName.contains("Windows")) {
			String cmdPID = "TASKKILL /PID";
			StringBuffer buffer = new StringBuffer();

			try {
				buffer.append(cmdPID);
				buffer.append(" ");
				buffer.append(PID);
				JOptionPane.showMessageDialog(null, "Tarefa de PID "+PID+" foi morta");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Um erro ocorrou, não foi possível matar o processo com PID\nErro: " + e.getMessage());
				e.printStackTrace();
			}

		} else {
			String cmdPID = "kill";
			StringBuffer buffer = new StringBuffer();

			try {
				buffer.append(cmdPID);
				buffer.append(" ");
				buffer.append(PID);
				JOptionPane.showMessageDialog(null, "Tarefa de PID "+PID+" foi morta");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Um erro ocorrou, não foi possível matar o processo com PID\nErro: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

	public void matarNome(String osName, String NAME) {

		if (osName.contains("Windows")) {
			String cmdPID = "TASKKILL /IM";
			StringBuffer buffer = new StringBuffer();

			try {
				buffer.append(cmdPID);
				buffer.append(" ");
				buffer.append(NAME);
				JOptionPane.showMessageDialog(null, "Tarefa de NOME "+NAME+" foi morta");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Um erro ocorrou, não foi possível matar o processo com NOME\nErro: " + e.getMessage());
				e.printStackTrace();
			}

		} else {
			String cmdPID = "pkill";
			StringBuffer buffer = new StringBuffer();

			try {
				buffer.append(cmdPID);
				buffer.append(" ");
				buffer.append(NAME);
				JOptionPane.showMessageDialog(null, "Tarefa de NOME "+NAME+" foi morta");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Um erro ocorrou, não foi possível matar o processo com NOME\nErro: " + e.getMessage());
				e.printStackTrace();
			}
		}

	}

}
