package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController() {
		super();
	}
	private String os() {
		return System.getProperty("os.name"); 
	} 
	public void listaProcessos() {
		String os = os();
		String proc;
		if(os.contains("Windows")) {
			proc = "TASKLIST /FO TABLE";
		} else if(os.contains("Linux")) {
			proc = "ps -ef";
		} else {
			System.out.println("SO não reconhecido");
			return;
		}
		String[] procarr = proc.split(" ");
		try {
			Process p = Runtime.getRuntime().exec(procarr);
			InputStream flow = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String linha;
			while((linha = buffer.readLine()) != null) {
				System.out.println(linha);
			}
			buffer.close();
			reader.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public void mataPid(int pid) {
		String os = os();
		StringBuffer m = new StringBuffer();
		if(os.contains("Windows")) {
			m.append("TASKKILL /PID");
			m.append(" ");
			m.append(pid);
		} else if(os.contains("Linux")) {
			m.append("kill -9");
			m.append(" ");
			m.append(pid);
		} else {
			System.out.println("OS não identificado.");
		}
		String[] matar = m.toString().split(" ");
		try {
			Runtime.getRuntime().exec(matar);
			System.out.println("MORTO!");
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public void mataNome(String nome) {
		String os = os();
		StringBuffer m = new StringBuffer();
		if(os.contains("Windows")) {
			m.append("TASKKILL /IM");
			m.append(" ");
			m.append(nome);
		} else if(os.contains("Linux")) {
			m.append("pkill -f");
			m.append(" ");
			m.append(nome);
		} else {
			System.out.println("OS não identificado");
		}
		String[] matar = m.toString().split(" ");
		try {
			Runtime.getRuntime().exec(matar);
			System.out.println("MORTO!");
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
