package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SteamController {

	
	public void verificaTxt(String absolutePath,String ano,String mes,int media) throws IOException {
		File arquivo = new File(absolutePath);
		escreveTxt("\nPedido: "+ano+" , "+mes+" , "+media+"\n");
		if (arquivo.exists()){
			FileInputStream fluxo =
				new FileInputStream(arquivo);
			InputStreamReader leitor = 
				new InputStreamReader(fluxo);
			BufferedReader buffer = 
				new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			
			while (linha != null){
				linha = buffer.readLine();
				if (linha != null) {
					String[] separado = linha.split(",");
					if (separado[1].contains(ano) && separado[2].contains(mes) && Float.parseFloat(separado[3]) <= media) {
						escreveTxt(linha);
					}
				}
			}
			escreveTxt("\n\n");
			System.out.println("Linhas salvas e colocadas no arquivo:\n C:\\TEMP\\SteamEnd");
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

	private void escreveTxt(String linha) throws IOException {
		String path = "C:\\TEMP\\";
		String nome = "SteamEnd";
		File dir = new File(path);
		File arquivo = new File(path, nome + ".txt");
		if (dir.exists()){
			boolean arquivoExiste = false;
			if (arquivo.exists()){
				arquivoExiste = true;
			}
			System.out.println(linha);
			String conteudo = linha + "\n";
			FileWriter fw;
			try {
				fw = new FileWriter(arquivo, arquivoExiste);
				PrintWriter pw = new PrintWriter(fw);
				pw.write(conteudo);
				pw.flush();
				pw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw new IOException("Diretório Inválido");
		}
		
	}

	public boolean tentaCriarArquivo(String absolutePath) throws IOException {
		File arquivo = new File(absolutePath);
		if (arquivo.exists()){
			if (arquivo.canRead()){
				if (arquivo.canWrite()){
					return true;
				}
			} 
		} else {
			throw new IOException("Arquivo inválido");
		}
		return false;
	}
	
	public void abreArquivoApp(String absolutePath) throws IOException {
		File arquivo = new File(absolutePath);
		if (arquivo.exists()){
			Desktop desk = Desktop.getDesktop();
			desk.open(arquivo);
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}

}
