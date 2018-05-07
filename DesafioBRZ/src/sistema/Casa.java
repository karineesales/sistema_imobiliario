package sistema;

public class Casa extends Imovel{
	
	public Casa( String pretensao, String titulo, String detalhes, double valor, int qntdQuartos) {
		super.setTipoImovel(TipoDeImovel.CASA);
		super.setPretensao(pretensao);
		super.setTitulo(titulo);
		super.setDetalhes(detalhes);
		super.setValor(valor);
		super.setQntdQuartos(qntdQuartos);
	}
	
	public String toString() {
		return "Casa:\nC�digo: "+super.getCodImovel()+"\nT�tulo: "+super.getTitulo()+"\nPretens�o: "+super.getPretensao()+"\nDetalhes: "+super.getDetalhes()+"\nValor: "+super.getValor()+"\nQuartos: "+super.getQntdQuartos()+".";
	}

}
