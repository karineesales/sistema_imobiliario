package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;


import bd.sistema.ConexaoDao;

public class GerenciadorImobiliarioDal{
	
	private Connection conexaoBD;
	
	//Cria conexão com Banco de Dados
	public GerenciadorImobiliarioDal() {
		conexaoBD = new ConexaoDao().conector();
	}

	//Cadastra um novo imóvel no Banco de Dados
	public void cadastraImovel(String tipo, String pretensao, String titulo, String detalhes, double valor, int qntdQuartos) {
		boolean imovelEncontrado = buscaImovel_BD(titulo);
		if(imovelEncontrado==false) {
			String sql = "INSERT INTO imovel(codImovel, tipoImovel, titulo, pretensao, detalhes, valor, quartos) VALUES(?,?,?,?,?,?,?)";
			try {  
	            PreparedStatement stmt = conexaoBD.prepareStatement(sql); 
	            stmt.setInt(1, 0);  
	            stmt.setString(2, tipo);  
	            stmt.setString(3, titulo );  
	            stmt.setString(4, pretensao); 
	            stmt.setString(5, detalhes );  
	            stmt.setDouble(6, valor);
	            stmt.setInt(7, qntdQuartos);
	            stmt.execute();
	            stmt.close();  
	            boolean testeCadastrou = buscaImovel_BD(titulo);
	            if(testeCadastrou == true) {
	            	JOptionPane.showMessageDialog(null, "Imóvel cadastrado com sucesso.");
	            }
	        } catch (SQLException e) {  
	           System.out.println(e.getMessage());  
	        }
		}else {
			JOptionPane.showMessageDialog(null, "Este título já consta em imóveis cadastrados.");
			
		}
	}

	//Verifica se existe um dado imóvel no Banco de Dados
	public boolean buscaImovel_BD (String titulo) {
		titulo = titulo.toLowerCase();
		boolean consulta = false;
		try{
			Statement cSQL = getConexaoBD().createStatement();
			ResultSet rs = cSQL.executeQuery(" SELECT * FROM imovel WHERE titulo = '"+titulo+"'");
			consulta = rs.next();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}return consulta;
		
	}
	
	//Altera o atributo pretensão no Banco de Dados
	public void editarImovel_Pretensao(String titulo, String novaPretensao) {
		boolean imovelEncontrado = buscaImovel_BD(titulo);
		if(imovelEncontrado==true) {
			String sql = "UPDATE imovel SET pretensao= '"+novaPretensao+"' WHERE titulo = '" +titulo+"'";
			try{
				PreparedStatement stmt = conexaoBD.prepareStatement(sql); 
				stmt.execute();
				stmt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());  
			}
		}else {
			JOptionPane.showMessageDialog(null, "Verifique o título do imóvel.");
		}
	}
	
	//Altera o atributo título no Banco de Dados
	public void editarImovel_Titulo(String titulo, String novoTitulo) {
		boolean imovelEncontrado = buscaImovel_BD(titulo);
		if(imovelEncontrado==false) {
			String sql = "UPDATE imovel SET titulo ='"+novoTitulo+"' WHERE titulo ='" +titulo+"'";
			try{
				PreparedStatement stmt = conexaoBD.prepareStatement(sql); 
				stmt.execute();
				stmt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());  
			}
		}else {
			JOptionPane.showMessageDialog(null, "Verifique o título do imóvel.");
		}
	}
	
	//Altera o atributo detalhes no Banco de Dados
	public void editarImovel_Detalhes(String titulo, String novoDetalhes) {
		String sql = "UPDATE imovel SET detalhes='"+novoDetalhes+"' WHERE titulo ='" +titulo+"'";
		boolean imovelEncontrado = buscaImovel_BD(titulo);
		if(imovelEncontrado==false) {
			try{
				PreparedStatement stmt = conexaoBD.prepareStatement(sql); 
				stmt.execute();
				stmt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());  
			}
		}else {
			JOptionPane.showMessageDialog(null, "Verifique o título do imóvel.");
		}
	}
	
	//Altera o atributo valor no Banco de Dados
	public void editarImovel_Valor(String titulo, double novoValor) {
		String sql = "UPDATE imovel SET valor='"+novoValor+"' WHERE titulo ='" +titulo+"'";
		boolean imovelEncontrado = buscaImovel_BD(titulo);
		if(imovelEncontrado==false) {
			try{
				PreparedStatement stmt = conexaoBD.prepareStatement(sql); 
				stmt.execute();
				stmt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());  
			}
		}else{
			JOptionPane.showMessageDialog(null, "Verifique o título do imóvel.");
		}
	}
	
	//Altera o atributo quartos no Banco de Dados
	public void editarImovel_QntdQuartos (String titulo, int novaQntdQuartos) {
		String sql = "UPDATE imovel SET quartos='"+novaQntdQuartos+"' WHERE titulo ='" +titulo+"'";
		boolean imovelEncontrado = buscaImovel_BD(titulo);
		if(imovelEncontrado==false) {
			try{
				PreparedStatement stmt = conexaoBD.prepareStatement(sql); 
				stmt.execute();
				stmt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());  
			}
		}else {
			JOptionPane.showMessageDialog(null, "Verifique o título do imóvel.");
		}
	}
	
	//Deleta um dado imóvel do Banco de Dados
	public void excluirImovel(String titulo) {
		String sql = "DELETE FROM imovel  WHERE titulo ='" +titulo+"'";
		boolean imovelEncontrado = buscaImovel_BD(titulo);
		if(imovelEncontrado==true) {
			try{
				PreparedStatement stmt = conexaoBD.prepareStatement(sql); 
				stmt.execute();
				stmt.close();
				JOptionPane.showMessageDialog(null, "Imóvel excluído.");
			}catch(Exception e) {
				System.out.println(e.getMessage());  
			}
		}else {
			JOptionPane.showMessageDialog(null, "Verifique o título do imóvel. Imóvel não encontrado.");
		}
	}	
	
	//retorna um objeto Imóvel a partir da busca no banco de dados pelo atributo título
	public Imovel getImovel_Titulo(String titulo) throws SQLException {
		titulo = titulo.toLowerCase();
		Imovel il=null;
		Statement SQL = getConexaoBD().createStatement();
		ResultSet rs = SQL.executeQuery("SELECT * FROM imovel where titulo ='"+titulo+"'");
		String result=null;
		while(rs.next()==true) {			
			int codImovel = rs.getInt(1);
			String tipoImovel = rs.getString(2);
			String tituloImovel = rs.getString(3);
			String pretensao = rs.getString(4);
			String detalhes = rs.getString(5);
			double valor = rs.getDouble(6);
			int qntdQuartos = rs.getInt(7);
			if(tipoImovel.toLowerCase().equals("casa")) {
				Imovel a = new Casa(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				il = a; 
			}
			else if(tipoImovel.toLowerCase().equals("apartamento")) {
				Imovel a = new Apartamento(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				il = a;
			}
			else if(tipoImovel.toLowerCase().equals("terreno")) {
				Imovel a = new Terreno(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				il = a;
			}
			else if(tipoImovel.toLowerCase().equals("loja")) {
				Imovel a = new Loja(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				il = a;
			}
		}
	
		return il;
	}

	//retorna o toString de um dado imóvel a partir da busca no banco de dados pelo atributo titulo
	public String pesquisarImovel_Titulo(String titulo) throws SQLException {
		List<Imovel> listaAux = new ArrayList<Imovel>();
		String buscaI = "Imóveis encontrados: \n";
		Statement SQL = getConexaoBD().createStatement();
		ResultSet rs = SQL.executeQuery("SELECT * FROM imovel where titulo='"+titulo+"'");
		String result=null;
		while(rs.next()==true) {			
			int codImovel = rs.getInt(1);
			String tipoImovel = rs.getString(2);
			String tituloImovel = rs.getString(3);
			String pretensao = rs.getString(4);
			String detalhes = rs.getString(5);
			double valor = rs.getDouble(6);
			int qntdQuartos = rs.getInt(7);
			if(tipoImovel.toLowerCase().equals("casa")) {
				Imovel a = new Casa(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("apartamento")) {
				Imovel a = new Apartamento(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("terreno")) {
				Imovel a = new Terreno(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("loja")) {
				Imovel a = new Loja(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
		}
	
		for(Imovel i: listaAux) {
			buscaI += i.toString()+"\n";
		}
		return buscaI;
	}

	//retorna o toString de um dado imóvel a partir da busca no banco de dados pelo atributo pretensão
	public String pesquisarImovel_Pretensao(String pretensao) throws SQLException {
		List<Imovel> listaAux = new ArrayList<Imovel>();
		String buscaI = "Imóveis encontrados: \n";
		Statement SQL = getConexaoBD().createStatement();
		ResultSet rs = SQL.executeQuery("SELECT * FROM imovel where pretensao='"+pretensao+"'");
		String result=null;
		while(rs.next()==true) {			
			int codImovel = rs.getInt(1);
			String tipoImovel = rs.getString(2);
			String tituloImovel = rs.getString(3);
			String pretensaoI = rs.getString(4);
			String detalhes = rs.getString(5);
			double valor = rs.getDouble(6);
			int qntdQuartos = rs.getInt(7);
			if(tipoImovel.toLowerCase().equals("casa")) {
				Imovel a = new Casa(pretensaoI, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("apartamento")) {
				Imovel a = new Apartamento(pretensaoI, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("terreno")) {
				Imovel a = new Terreno(pretensaoI, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("loja")) {
				Imovel a = new Loja(pretensaoI, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
		}
	
		for(Imovel i: listaAux) {
			buscaI += i.toString()+"\n";
		}
		return buscaI;
	}


	//retorna o toString de um dado imóvel a partir da busca no banco de dados pelo atributo quartos
	public String pesquisarImovel_QntdQuartos(int qntdQuartos) throws SQLException {
		List<Imovel> listaAux = new ArrayList<Imovel>();
		String buscaI = "Imóveis encontrados: \n";
		Statement SQL = getConexaoBD().createStatement();
		ResultSet rs = SQL.executeQuery("SELECT * FROM imovel where quartos='"+qntdQuartos+"'");
		String result=null;
		while(rs.next()==true) {			
			int codImovel = rs.getInt(1);
			String tipoImovel = rs.getString(2);
			String tituloImovel = rs.getString(3);
			String pretensao = rs.getString(4);
			String detalhes = rs.getString(5);
			double valor = rs.getDouble(6);
			int qQuartos = rs.getInt(7);
			if(tipoImovel.toLowerCase().equals("casa")) {
				Imovel a = new Casa(pretensao, tituloImovel, detalhes, valor, qQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("apartamento")) {
				Imovel a = new Apartamento(pretensao, tituloImovel, detalhes, valor, qQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("terreno")) {
				Imovel a = new Terreno(pretensao, tituloImovel, detalhes, valor, qQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("loja")) {
				Imovel a = new Loja(pretensao, tituloImovel, detalhes, valor, qQuartos);
				listaAux.add(a);
			}
		}
	
		for(Imovel i: listaAux) {
			buscaI += i.toString()+"\n";
		}
		return buscaI;
	}


	//retorna o toString de um dado imóvel a partir da busca no banco de dados pelo atributo valor
	public String pesquisarImovel_FaixaDePreco(double valorInicial, double valorFinal) throws SQLException {
		List<Imovel> listaAux = new ArrayList<Imovel>();
		String buscaI = "Imóveis encontrados: \n";
		Statement SQL = getConexaoBD().createStatement();
		ResultSet rs = SQL.executeQuery("SELECT * FROM imovel WHERE valor >='"+valorInicial+"'AND valor <='"+valorFinal+"'");
		String result=null;
		while(rs.next()==true) {			
			int codImovel = rs.getInt(1);
			String tipoImovel = rs.getString(2);
			String tituloImovel = rs.getString(3);
			String pretensao = rs.getString(4);
			String detalhes = rs.getString(5);
			double valor = rs.getDouble(6);
			int qntdQuartos = rs.getInt(7);
			if(tipoImovel.toLowerCase().equals("casa")) {
				Imovel a = new Casa(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("apartamento")) {
				Imovel a = new Apartamento(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("terreno")) {
				Imovel a = new Terreno(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
			else if(tipoImovel.toLowerCase().equals("loja")) {
				Imovel a = new Loja(pretensao, tituloImovel, detalhes, valor, qntdQuartos);
				listaAux.add(a);
			}
		}
	
		for(Imovel i: listaAux) {
			buscaI += i.toString()+"\n";
		}
		return buscaI;
	}
	
	//retorna o toString dos imóveis encontrados a partir da busca de interessados no banco de dados pelo atributo nome
	public String imoveisPorInteressado_Nome(String nome) throws SQLException{
		List<Imovel> listaAux = new ArrayList<Imovel>();
		String buscaI = "Imóveis encontrados: \n";
		Statement SQL = getConexaoBD().createStatement();
		ResultSet rs = SQL.executeQuery("SELECT * FROM interesse WHERE nomeInteressado ='"+nome+"'");
		String result=null;
		while(rs.next()==true) {			
			String tituloImovel = rs.getString(3);
			listaAux.add(getImovel_Titulo(tituloImovel));
		}
		
		for(Imovel i: listaAux) {
			buscaI += i.toString()+"\n";
		}
		return buscaI;
	}
	
	//retorna o toString dos imóveis encontrados a partir da busca de interessados no banco de dados pelo atributo email
	public String imoveisPorInteressado_Email(String email) throws SQLException{
		List<Imovel> listaAux = new ArrayList<Imovel>();
		String buscaI = "Imóveis encontrados: \n";
		Statement SQL = getConexaoBD().createStatement();
		ResultSet rs = SQL.executeQuery("SELECT * FROM interesse WHERE emailInteressado = '"+email+"'");
		String result=null;
		while(rs.next()==true) {			
			String tituloImovel = rs.getString(3);
			listaAux.add(getImovel_Titulo(tituloImovel));
		}
		
		for(Imovel i: listaAux) {
			buscaI += i.toString()+"\n";
		}
		return buscaI;
	}
	
	//Cadastra no Banco de dados um novo interessado
	public void cadastrarInteressado(String nome, String email) throws SQLException {
			boolean consulta = buscaInteressado(nome, email);
			if(consulta==false) {
				String sql = "INSERT INTO interessado(nomeInteressado, emailInteressado) VALUES(?,?)";
				try {  
		            PreparedStatement stmt = conexaoBD.prepareStatement(sql); 
		            stmt.setString(1, nome);  
		            stmt.setString(2, email);  
		            stmt.execute();
		            stmt.close();
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	
	//Cadastra no Banco de dados um novo interesse
	public void cadastrarInteresse(String nome, String email, String tituloImovel) throws SQLException {		
		if(buscaInteressado(nome, email) == true) {
			String sql = "INSERT INTO interesse(nomeInteressado, emailInteressado, titulo) VALUES(?,?,?)";
			try {  
	            PreparedStatement stmt = conexaoBD.prepareStatement(sql);  
	            stmt.setString(1, nome);  
	            stmt.setString(2, email);  
	            stmt.setString(3, tituloImovel); 
	            stmt.execute();
	            stmt.close();  
	            JOptionPane.showMessageDialog(null, "Interesse cadastrado com sucesso!");
	        } catch (SQLException e) {  
	           System.out.println(e.getMessage());  
	        }	
		}else {
			if(verificarEmail(email)==false) {
				cadastrarInteressado(nome, email);
				String sql = "INSERT INTO interesse(nomeInteressado, emailInteressado, titulo) VALUES(?,?,?)";
				try {  
		            PreparedStatement stmt = conexaoBD.prepareStatement(sql);  
		            stmt.setString(1, nome);  
		            stmt.setString(2, email);  
		            stmt.setString(3, tituloImovel); 
		            stmt.execute();
		            stmt.close();  
		            JOptionPane.showMessageDialog(null, "Interesse cadastrado com sucesso!");
				} catch (SQLException e) {  
			           System.out.println(e.getMessage());  
			    }
			}
			else {
			    	JOptionPane.showMessageDialog(null, "Este email já está cadastrado, favor utilizar outro.");
		    }
		}
	}
	
	//Verifica no banco de dados se existe um determinado interessado
	public boolean buscaInteressado (String nome, String email) throws SQLException {
		boolean encontrou = false;
		try{
			Statement cSQL = getConexaoBD().createStatement();
			ResultSet rs = cSQL.executeQuery(" SELECT * FROM interessado WHERE emailInteressado = '"+email+"'");
			String resultadoNome = rs.getString(1);
			if(resultadoNome==nome) {
				encontrou = true;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return encontrou;
	}
	
	//Verifica se um email já consta no banco de dados
	public boolean verificarEmail (String email) throws SQLException {
		boolean emailUtilizado = false;
		try{
			Statement cSQL = getConexaoBD().createStatement();
			ResultSet rs = cSQL.executeQuery(" SELECT * FROM interessado WHERE emailInteressado = '"+email+"'");
			emailUtilizado = rs.next();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return emailUtilizado;
	}
	
	//Deleta do banco de dados um determinado interesse a partir dos atributos nome e titulo
	public void excluirInteresse(String nome, String tituloImovel) {
		String sql = "DELETE FROM interesse WHERE titulo ='" +tituloImovel+"' AND nomeInteressado ='"+nome+"'";
		try{
			PreparedStatement stmt = conexaoBD.prepareStatement(sql); 
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Interesse excluído");
		}catch(Exception e) {
			System.out.println(e.getMessage());  
		}
	}
	
	//retorna os nomes das pessoas interessadas por um determinado imóvel a partir da busca no banco de dados através do atributo título
	public String interessadosPorImovel(String titulo) throws SQLException{
		String buscaI = "Interessados encontrados: \n";
		Statement SQL = getConexaoBD().createStatement();
		ResultSet rs = SQL.executeQuery("SELECT * FROM interesse WHERE titulo = '"+titulo+"'");
		String result=null;
		while(rs.next()==true) {			
			String nome = rs.getString(1)+"\n";
			buscaI+=nome;
		}
		
		return buscaI;
	}

    //retorna a conexão com o banco de dados
	private Connection getConexaoBD() {
		return this.conexaoBD;
	}
	
}
