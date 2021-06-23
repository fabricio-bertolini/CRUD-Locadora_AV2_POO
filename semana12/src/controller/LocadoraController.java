package controller;

import java.util.ArrayList;
import java.util.List;

import bo.Produtora;
import bo.Titulo;
import model.LocadoraDAO;

public class LocadoraController {
	public void create(Titulo titulo) {
		LocadoraDAO model = new LocadoraDAO();
		model.create(titulo);
	}
	
	public void create(Produtora produtora) {	
		LocadoraDAO model = new LocadoraDAO();
		model.create(produtora);
	}
	
	public List<Titulo> readTitulo()
	{
		List<Titulo> listaTitulos = new ArrayList<Titulo>();
		
		try
		{
			LocadoraDAO model = new LocadoraDAO();
			listaTitulos = model.readTitulo();
		}
		catch (Exception e)
		{
			System.out.println("Erro no controller read");
		}
		return listaTitulos;
	}
	
	public List<Produtora> readProdutora()
	{
		List<Produtora> listaProdutoras = new ArrayList<Produtora>();
		
		try
		{
			LocadoraDAO model = new LocadoraDAO();
			listaProdutoras = model.readProdutora();
		}
		catch (Exception e)
		{
			System.out.println("Erro no controller read");
		}
		return listaProdutoras;
	}
	
	public void update(Titulo titulo,String id)
	{
		LocadoraDAO model = new LocadoraDAO();
		model.update(titulo,id);
	}
	
	public void update(Produtora produtora,String id)
	{
		LocadoraDAO model = new LocadoraDAO();
		model.update(produtora,id);
	}
	
	public void deleteTitulo(String id)
	{
		LocadoraDAO model = new LocadoraDAO();
		model.deleteTitulo(id);
	}
	
	public void deleteProdutora(String id)
	{
		LocadoraDAO model = new LocadoraDAO();
		model.deleteProdutora(id);
	}
}
