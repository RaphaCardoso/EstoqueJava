package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Alimentos extends Produto {

	private LocalDate dataValidade;
	
	public Alimentos(int codigo, String nome, String descricao, int qntdEstoque, double preco, LocalDate dataValidade) {
		super(codigo, nome, descricao, qntdEstoque, preco);
		this.dataValidade = dataValidade;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	@Override
	public String exibirDetalhes() {
		String conteudo = super.exibirDetalhes() + ", Data de Validade: " + dataValidade;
		return conteudo;
	}

	@Override
	public void gravaEstoque(int codigo, String nome, String descricao, int qntdEstoque, double preco) {
		try {
			FileWriter writer = new FileWriter("estoque.txt", true);
			writer.write(
					exibirDetalhes() + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
