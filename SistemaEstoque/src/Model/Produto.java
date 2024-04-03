package Model;

import java.io.FileWriter;
import java.io.IOException;

public class Produto {
	
	private int codigo;
	private String nome;
	private String descricao;
	private int qntdEstoque;
	private double preco;
	
	public Produto(int codigo, String nome, String descricao, int qntdEstoque, double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.qntdEstoque = qntdEstoque;
		this.preco = preco;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQntdEstoque() {
		return qntdEstoque;
	}
	public void setQntdEstoque(int qntdEstoque) {
		this.qntdEstoque = qntdEstoque;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String exibirDetalhes() {
		
		String conteudo = "Código: " + codigo + ", Nome: " + nome + ", Descrição: " + descricao + ", Quantidade: " + qntdEstoque
				+ ", Preço: " + preco;
		return conteudo;
	}

	public void gravaEstoque(int codigo, String nome, String descricao, int qntdEstoque, double preco) {
		try {
			FileWriter writer = new FileWriter("estoque.txt", true);
			writer.write(exibirDetalhes() + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
