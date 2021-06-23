package view;

import bo.Produtora;
import bo.Titulo;
import controller.LocadoraController;

public class Read{
	public Read()
	{
		LocadoraController controller = new LocadoraController();

		System.out.println("Listagem de Titulos");
		System.out.println("******************");
		
		for(Titulo titulo:controller.readTitulo())
		{
			System.out.println("Titulo id: " + titulo.getId_titulo());
			System.out.println("Titulo nome: " + titulo.getNome());
			System.out.println("Titulo gênero: " + titulo.getGenero());
			System.out.println("Titulo qtd cópias: " + titulo.getQtd_copias());
			System.out.println("-------------------------------------");
		}
		
		System.out.println("Listagem de Produtoras");
		System.out.println("******************");
		
		for(Produtora produtora:controller.readProdutora())
		{
			System.out.println("Produtora id: " + produtora.getId_produtora());
			System.out.println("Produtora nome: " + produtora.getNome());
			System.out.println("-------------------------------------");
		}
		
	}
}
