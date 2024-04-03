package Model;

import java.io.FileWriter;
import java.io.IOException;

public class Eletronicos extends Produto {
    
     private String marca;
	 private String modelo;
	 
	 
	 public Eletronicos(int codigo, String nome, String descricao, int qntdEstoque, double preco, String marca,
				String modelo) {
			super(codigo, nome, descricao, qntdEstoque, preco);
			this.marca = marca;
			this.modelo = modelo;
		}
	 
	 
	 
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	 
	@Override
	public String exibirDetalhes() {
		
		String conteudo = super.exibirDetalhes() + ", Marca: " + marca + ", Modelo: " + modelo;
		
		return conteudo;
	}

	@Override
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
