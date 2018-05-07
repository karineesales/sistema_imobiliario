package sistema;

public class Terreno extends Imovel{
	
	public Terreno(String pretensao, String titulo, String detalhes, double valor, int qntdQuartos) {
	super.setTipoImovel(TipoDeImovel.TERRENO);
	super.setPretensao(pretensao);
	super.setTitulo(titulo);
	super.setDetalhes(detalhes);
	super.setValor(valor);
	super.setQntdQuartos(qntdQuartos);
	}

	public String toString() {
		return "Terreno:\nC�digo: "+super.getCodImovel()+"\nT�tulo: "+super.getTitulo()+"\nPretens�o: "+super.getPretensao()+"\nDetalhes: "+super.getDetalhes()+"\nValor: "+super.getValor();
	}
	
	
}
