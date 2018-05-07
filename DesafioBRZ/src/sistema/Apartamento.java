package sistema;

public class Apartamento extends Imovel{
	
	public Apartamento( String pretensao, String titulo, String detalhes, double valor, int qntdQuartos) {
		super.setTipoImovel(TipoDeImovel.APARTAMENTO);
		super.setPretensao(pretensao);
		super.setTitulo(titulo);
		super.setDetalhes(detalhes);
		super.setValor(valor);
		super.setQntdQuartos(qntdQuartos);
	}


	public String toString() {
		return "Apartamento:\nCódigo: "+super.getCodImovel()+"\nTítulo: "+super.getTitulo()+"\nPretensão: "+super.getPretensao()+"\nDetalhes: "+super.getDetalhes()+"\nValor: "+super.getValor()+"\nQuartos: "+super.getQntdQuartos()+".";
	}
	
	
	

}
