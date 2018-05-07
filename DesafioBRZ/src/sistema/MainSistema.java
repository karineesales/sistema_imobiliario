package sistema;

import java.util.Scanner;

public class MainSistema {

	public static void main(String[] args) {
		
		String teste1 = "Casa em JP";
		
		System.out.println(teste1.toLowerCase().equals("casa em jp"));
//		GerenciadorImobiliarioSemBD gerente = new GerenciadorImobiliarioSemBD();
//		Scanner ledor = new Scanner(System.in);
//		System.out.println("Bem vindo ao Sistema Imobiliário \nO que desejas fazer? \n 1 - Cadastrar um novo imóvel\n 2 - Editar dados de um imóvel\n 3 - Excluir um imóvel \nDigite apenas o número correspondente a opçao que desejas! ");
//		int opcao = ledor.nextInt();
//		switch(opcao) {
//			case 1:
//				TipoDeImovel tipo = null;
//				System.out.println("Cadastro de Imóveis\n Digite os seguintes dados:");
//				System.out.println("Tipo de imóvel? 1 - Casa, 2 - Apartamento, 3 - Terreno, 4 - Loja\n Digite apenas o número correspondente a opçao desejada:");
//				int opTipo = ledor.nextInt();
//				if(opTipo==1) {
//					tipo = TipoDeImovel.CASA;
//				}
//				else if(opTipo==2) {
//					tipo = TipoDeImovel.APARTAMENTO;
//				}
//				else if(opTipo==3) {
//					tipo = TipoDeImovel.TERRENO;
//				}
//				else if(opTipo==4) {
//					tipo = TipoDeImovel.LOJA;
//				}
//							
//				System.out.println("Título:");
//				Scanner ledor01 = new Scanner(System.in);
//				String titulo = ledor01.nextLine();
//				
//				System.out.println("Valor:");
//				double valor = ledor01.nextDouble();
//				
//				System.out.println("Pretensão:");
//				Scanner ledor02 = new Scanner(System.in);
//				String pretensao = ledor02.nextLine();
//				
//				System.out.println("Detalhes:");
//				String detalhes = ledor02.nextLine();
//				
//				System.out.println("Quantidade de quartos: Caso não haja quartos digite o número 0.");
//				int quartos = ledor02.nextInt();
//				
//				gerente.cadastraImovel(tipo, pretensao, titulo, detalhes, valor, quartos);
//				System.out.println("Cadastrado com sucesso!");
//				break;
//				
//			case 2:
//				System.out.println("Qual o título do imóvel que desejas alterar?");
//				Scanner ledor03 = new Scanner(System.in);
//				String tituloBusca = ledor03.nextLine();
//				System.out.println("Qual opção você deseja alterar? 1 - Título, 2 - Valor, 3 - Pretensão, 4 - Detalhes, 5 - Quantidade de Quaartos.");
//				int op = ledor03.nextInt();
//				if(op==1) {
//					System.out.println("Digite um novo título:");
//					String alterar = ledor03.nextLine();
//					gerente.editarImovel_Titulo(tituloBusca, alterar);
//					System.out.println(gerente.buscarImovel(alterar).getTitulo());
//				}
//		}
//		
//
//	}

}}
