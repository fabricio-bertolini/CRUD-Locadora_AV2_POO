//Equipe: Fabrício Valladares Bertolini ; Louise Laclau

package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import bo.Produtora;
import bo.Titulo;
import controller.LocadoraController;

public class LocadoraView extends JFrame implements ActionListener {
    private JFrame frame;
    
    private JPanel panel;

    private JLabel lblTxt1;
    private JLabel lblTitle2;
    private JLabel lblTitle;
    private JTextField lblTable;
    
    private String table_selected;
    
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnRead;
	
	public LocadoraView()
	{
        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        
        lblTitle = new JLabel("CRUD");
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 40));
        panel.add(lblTitle);
        
        lblTitle2 = new JLabel("Grupo: Fabrício Bertolini || Louise Laclau");
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 30));
        panel.add(lblTitle2);
        
        lblTxt1 = new JLabel("Tabela:");
        panel.add(lblTxt1);
        lblTable = new JTextField();
        panel.add(lblTable);
        
        btnInsert = new JButton("Insert");
        btnInsert.addActionListener(this);
        
        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this);
        
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this);
        
        btnRead = new JButton("Read");
        btnRead.addActionListener(this);
   
        panel.add(btnInsert);
        panel.add(btnUpdate);
        panel.add(btnRead);
        panel.add(btnDelete);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CRUD");
        frame.setSize(400,600);
        //frame.pack();
        frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		table_selected = lblTable.getText();
		try 
		{
			//Titulo select
			if(e.getActionCommand().equalsIgnoreCase("insert") && table_selected.equalsIgnoreCase("titulo"))
			{
				new FrameInsertTitulo();
				frame.dispose();
			}
			else if (e.getActionCommand().equalsIgnoreCase("delete") && table_selected.equalsIgnoreCase("titulo"))
			{
				new FrameDeleteTitulo();
				frame.dispose();
			}
			else if (e.getActionCommand().equalsIgnoreCase("update") && table_selected.equalsIgnoreCase("titulo"))
			{
				new FrameUpdateTitulo();
				frame.dispose();
			}
			
			//Produtora select
			else if(e.getActionCommand().equalsIgnoreCase("insert") && table_selected.equalsIgnoreCase("produtora"))
			{
				new FrameInsertProdutora();
				frame.dispose();
			}
			else if (e.getActionCommand().equalsIgnoreCase("delete") && table_selected.equalsIgnoreCase("produtora"))
			{
				new FrameDeleteProdutora();
				frame.dispose();
			}
			else if (e.getActionCommand().equalsIgnoreCase("update") && table_selected.equalsIgnoreCase("produtora"))
			{
				new FrameUpdateProdutora();
				frame.dispose();
			}
			
			//Read
			else if (e.getActionCommand().equalsIgnoreCase("read"))
			{
				new Read();
			}	
		}
		catch (Exception e2)
		{
			System.out.println(e2);
		}
	}
	
	public static void main(String[] args) {
		new LocadoraView();
	}


}
