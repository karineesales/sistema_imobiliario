package sistema;

public abstract class Imovel {
	
	private int codImovel;
	private TipoDeImovel tipoImovel;
	private String titulo;
	private String detalhes;
	private double valor;
	private String pretensao;
	private int qntdQuartos;
	
	public int getQntdQuartos() {
		return qntdQuartos;
	}
	
	public void setQntdQuartos(int qntdQuartos) {
		this.qntdQuartos = qntdQuartos;
	}
	
	public int getCodImovel() {
		return codImovel;
	}
	
	public void setCodImovel(int codImovel) {
		this.codImovel = codImovel;
	}
	
	public TipoDeImovel getTipoImovel() {
		return tipoImovel;
	}
	
	public void setTipoImovel(TipoDeImovel tipoImovel) {
		this.tipoImovel = tipoImovel;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDetalhes() {
		return detalhes;
	}
	
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getPretensao() {
		return pretensao;
	}
	
	public void setPretensao(String pretensao) {
		this.pretensao = pretensao;
	}
	
	public abstract String toString();
	
	

}
//(código, tipo, pretensão, título, detalhes, quartos e valor)