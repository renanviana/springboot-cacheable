package app;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import model.IPessoa;

@Component
@ComponentScan({"service"})
public class AppRunner implements CommandLineRunner {

	private final IPessoa ipessoa;
	String nome = "";
	int idade = 0;
	Scanner scn = new Scanner(System.in);
	
	public AppRunner(IPessoa ipessoa) {
		this.ipessoa = ipessoa;
	}
	
	public void run(String... args) throws Exception {
		do {
			System.out.println("nome:");
			nome = scn.nextLine();
			if (nome.equals("exit")) System.exit(0);
			System.out.println("idade:");
			idade = Integer.parseInt(scn.nextLine());
			if (Integer.toString(idade).equals("exit")) System.exit(0);
			System.out.println(ipessoa.getPessoa(nome, idade));
		} while (!nome.equals("exit"));
	}
}