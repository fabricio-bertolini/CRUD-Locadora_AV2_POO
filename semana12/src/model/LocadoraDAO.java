package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Produtora;
import bo.Titulo;
import jdbc.ConnectionFactory;

public class LocadoraDAO {
	public void create(Titulo titulo)
	{
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try {
			String sql = "insert into titulo(id_titulo,nome,genero,qtd_copias) values (?,?,?,?)";
			stmt = banco.prepareStatement(sql);
			
			stmt.setString(1, titulo.getId_titulo());
			stmt.setString(2, titulo.getNome());
			stmt.setString(3, titulo.getGenero());
			stmt.setString(4, titulo.getQtd_copias());
			
			stmt.executeUpdate();
			
			System.out.println("Titulo incluido com sucesso!");
		}
		catch (SQLException e){
			System.out.println("Erro ao tentar incluir titulo");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
	}
	
	public void create(Produtora produtora)
	{
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try {
			String sql = "insert into produtora(id_produtora,nome) values (?,?)";
			stmt = banco.prepareStatement(sql);
			
			stmt.setString(1, produtora.getId_produtora());
			stmt.setString(2, produtora.getNome());
			
			stmt.executeUpdate();
			
			System.out.println("Produtora incluido com sucesso!");
		}
		catch (SQLException e){
			System.out.println("Erro ao tentar incluir produtora");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
	}
	
	public List<Titulo> readTitulo()
	{
		List<Titulo> listaTitulos = new ArrayList<Titulo>();
		
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select id_titulo, nome, genero, qtd_copias from titulo";
		
		try
		{
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Titulo titulo = new Titulo();
				
				titulo.setId_titulo(rs.getString("id_titulo"));
				titulo.setNome(rs.getString("nome"));
				titulo.setGenero(rs.getString("genero"));
				titulo.setQtd_copias(rs.getString("qtd_copias"));
				
				listaTitulos.add(titulo);
			}
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao tentar ler titulo...");
		}
		finally
		{
			ConnectionFactory.closeConnection(banco, stmt);
		}
		return listaTitulos;
	}
	
	public List<Produtora> readProdutora()
	{
		List<Produtora> listaProdutoras = new ArrayList<Produtora>();
		
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select id_produtora,nome from produtora";
		
		try
		{
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Produtora produtora = new Produtora();
				
				produtora.setId_produtora(rs.getString("id_produtora"));
				produtora.setNome(rs.getString("nome"));
				
				listaProdutoras.add(produtora);
			}
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao tentar ler produtora...");
		}
		finally
		{
			ConnectionFactory.closeConnection(banco, stmt);
		}
		return listaProdutoras;
	}


	public void update(Titulo titulo,String id)
	{
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try {
			String sql = "UPDATE titulo SET id_titulo = ?"
					+ ",nome = ?"
					+ ",genero = ?"
					+ ",qtd_copias = ? WHERE id_titulo = " + id;
			stmt = banco.prepareStatement(sql);
			
			stmt.setString(1, titulo.getId_titulo());
			stmt.setString(2, titulo.getNome());
			stmt.setString(3, titulo.getGenero());
			stmt.setString(4, titulo.getQtd_copias());
			
			stmt.executeUpdate();
			
			System.out.println("Titulo atualizado com sucesso!");
		}
		catch (SQLException e){
			System.out.println("Erro ao tentar atualizar titulo");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
	}
	
	public void update(Produtora produtora,String id)
	{
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try {
			String sql = "UPDATE produtora SET id_produtora = ?"
					+ ",nome = ? WHERE id_produtora = " + id;
			stmt = banco.prepareStatement(sql);
			
			stmt.setString(1, produtora.getId_produtora());
			stmt.setString(2, produtora.getNome());
			
			stmt.executeUpdate();
			
			System.out.println("Produtora atualizado com sucesso!");
		}
		catch (SQLException e){
			System.out.println("Erro ao tentar atualizar produtora");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
	}
	
	public void deleteTitulo(String id)
	{
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try {
			String sql = "DELETE FROM titulo WHERE id_titulo = "+ id;
			stmt = banco.prepareStatement(sql);
			
			stmt.executeUpdate();
			
			System.out.println("Titulo deletado com sucesso!");
		}
		catch (SQLException e){
			System.out.println("Erro ao tentar deletar titulo");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
	}
	
	public void deleteProdutora(String id)
	{
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try {
			String sql = "DELETE FROM produtora WHERE id_produtora = "+ id;
			stmt = banco.prepareStatement(sql);
			
			stmt.executeUpdate();
			
			System.out.println("Produtora deletado com sucesso!");
		}
		catch (SQLException e){
			System.out.println("Erro ao tentar deletar produtora");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
	}
}
