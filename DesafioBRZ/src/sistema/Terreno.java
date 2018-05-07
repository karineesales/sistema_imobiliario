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
		return "Terreno:\nCódigo: "+super.getCodImovel()+"\nTítulo: "+super.getTitulo()+"\nPretensão: "+super.getPretensao()+"\nDetalhes: "+super.getDetalhes()+"\nValor: "+super.getValor();
	}
	
	
}
