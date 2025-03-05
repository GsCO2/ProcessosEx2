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
}
