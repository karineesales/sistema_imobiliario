package sistema;

public class Loja extends Imovel {
	
	public Loja(String pretensao, String titulo, String detalhes, double valor, int qntdQuartos) {
		super.setTipoImovel(TipoDeImovel.LOJA);
		super.setPretensao(pretensao);
		super.setTitulo(titulo);
		super.setDetalhes(detalhes);
		super.setValor(valor);
		super.setQntdQuartos(qntdQuartos);
	}


	public String toString() {
		return "Loja:\nCódigo: "+super.getCodImovel()+"\nTítulo: "+super.getTitulo()+"\nPretensão: "+super.getPretensao()+"\nDetalhes: "+super.getDetalhes()+"\nValor: "+super.getValor();
	}

}
