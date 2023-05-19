package model;

public class Produto {
	private int andar;
	private String nomeDepartamento;
	private String descriscao;
	
	//Get e set
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	public String getNomeDepartamento() {
		return nomeDepartamento;
	}
	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	public String getDescriscao() {
		return descriscao;
	}
	public void setDescriscao(String descriscao) {
		this.descriscao = descriscao;
	}
	
	@Override
	public String toString() {
		return "Produto [andar=" + andar + ", nomeDepartamento=" + nomeDepartamento + ", descriscao=" + descriscao
				+ "]";
	}
	
}
