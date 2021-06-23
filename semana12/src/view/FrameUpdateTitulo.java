package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bo.Titulo;
import controller.LocadoraController;

public class FrameUpdateTitulo extends JFrame implements ActionListener{
    private JFrame frame;
    private JPanel panel;

    private JLabel lblTitle;
    
    private JTextField lblId1;
    private JTextField lblId2;
    private JTextField lblNome;
    private JTextField lblGenero;
    private JTextField lblQtd_copias;

    private JLabel lblTxt1;
    private JLabel lblTxt2;
    private JLabel lblTxt3;
    private JLabel lblTxt4;
    private JLabel lblTxt5;
    
    private JButton btnSend;
    
    public FrameUpdateTitulo()
    {
		frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CRUD");
        frame.setSize(800,900);
        
        lblTitle = new JLabel("Update Titulo");
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 30));
        panel.add(lblTitle);
 
        lblTxt1 = new JLabel("Id_titulo para atualizar:");
        panel.add(lblTxt1);
        lblId1 = new JTextField();
        panel.add(lblId1);
        
        lblTxt2 = new JLabel("Id_titulo:");
        panel.add(lblTxt2);
        lblId2 = new JTextField();
        panel.add(lblId2);
        
        lblTxt3 = new JLabel("Nome:");
        panel.add(lblTxt3);
        lblNome = new JTextField();
        panel.add(lblNome);
        
        lblTxt4 = new JLabel("Genero:");
        panel.add(lblTxt4);
        lblGenero = new JTextField();
        panel.add(lblGenero);
        
        lblTxt5 = new JLabel("Qtd_copias:");
        panel.add(lblTxt5);
        lblQtd_copias = new JTextField();
        panel.add(lblQtd_copias);
        
        btnSend = new JButton("Send");
        btnSend.addActionListener(this);
        panel.add(btnSend);
        
        frame.pack();
        frame.setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		Titulo titulo = new Titulo();
		LocadoraController crud = new LocadoraController();
		
		titulo.setId_titulo(lblId2.getText());
		titulo.setNome(lblNome.getText());
		titulo.setGenero(lblGenero.getText());
		titulo.setQtd_copias(lblQtd_copias.getText());

		crud.update(titulo,lblId1.getText());	
	}
}
