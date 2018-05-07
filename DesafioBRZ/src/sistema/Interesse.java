package sistema;

public class Interesse {
	private Interessado interessado;
	private Imovel imovel;
	
	public Interesse(Interessado interessado, Imovel imovel) {
		this.interessado=interessado;
		this.imovel=imovel;
	}

	public Interessado getInteressado() {
		return interessado;
	}

	public void setInteressado(Interessado interessado) {
		this.interessado = interessado;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

}
