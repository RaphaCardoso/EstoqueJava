package Controller;

import Model.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Scanner;

import Model.Alimentos;
import Model.Eletronicos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		
		System.out.println("");
		System.out.println("Qual o Código:");
		int cod = sc.nextInt();
		System.out.println("");
		
		System.out.println("");
		System.out.println("Qual o Nome:");
		String nome = sc.next();
		System.out.println("");
		
		System.out.println("");
		System.out.println("Qual a Descrição:");
		String descricao = sc.next();
		System.out.println("");
		
		System.out.println("");
		System.out.println("Qual a Quantidade em estoque:");
		int quantidade = sc.nextInt();
		System.out.println("");
		
		System.out.println("");
		System.out.println("Qual o Preço:");
		int preco = sc.nextInt();
		System.out.println("");
		
		System.out.println("");
		System.out.println("o que você está cadastrando?");
		System.out.println("[1] - Produto [2] - Alimento [3] - Eletronico");
		int opcao = sc.nextInt();
		
		switch (opcao) {
		case 1: 
			Produto produto1 = new Produto (cod, nome, descricao, quantidade, preco);
		produto1.gravaEstoque(produto1.getCodigo(), produto1.getNome(), produto1.getDescricao(), produto1.getQntdEstoque(), produto1.getPreco());
		break;
		case 2: 
			System.out.println("");
			System.out.println("Escreva a data de validade: ");
			System.out.println("Ano:");
			int ano = sc.nextInt();
			System.out.println("Mês:");
			int mes = sc.nextInt();
			System.out.println("Dia:");
			int dia = sc.nextInt();
			
			Alimentos alimento = new Alimentos (cod, nome, descricao, quantidade, preco, LocalDate.of(ano, mes, dia));
		alimento.gravaEstoque(alimento.getCodigo(), alimento.getNome(), alimento.getDescricao(),
				alimento.getQntdEstoque(), alimento.getPreco());
		break;
		case 3: 
			
			System.out.println("");
			System.out.println("Escreva a Marca:");
			String marca = sc.next();
			
			System.out.println("");
			System.out.println("Escreva a Modelo:");
			String modelo = sc.next();
			
			Eletronicos eletronico = new Eletronicos (cod, nome, descricao, quantidade, preco, marca, modelo);
			eletronico.gravaEstoque(eletronico.getCodigo(), eletronico.getNome(), eletronico.getDescricao(), eletronico.getQntdEstoque(), eletronico.getPreco());
			break;
			
			default: 
				System.out.println("Opção inválida");
			break;
		}
		
		
		


		
		lerArquivo();

		sc.close();
	}

	private static String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return content.toString();


    }
	
	public static void lerArquivo () {
		String content = readFromFile("estoque.txt");
        System.out.println("Conteúdo lido do arquivo: " + content);
	}
	
}
