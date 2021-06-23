package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bo.Produtora;
import controller.LocadoraController;

public class FrameUpdateProdutora extends JFrame implements ActionListener{
    private JFrame frame;
    private JPanel panel;

    private JLabel lblTitle;
    
    private JTextField lblId1;
    private JTextField lblId2;
    private JTextField lblNome;

    private JLabel lblTxt1;
    private JLabel lblTxt2;
    private JLabel lblTxt3;
    
    private JButton btnSend;
    
    public FrameUpdateProdutora()
    {
		frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CRUD");
        frame.setSize(800,900);
        
        lblTitle = new JLabel("Update Produtora");
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 30));
        panel.add(lblTitle);
 
        lblTxt1 = new JLabel("Id_produtora para atualizar:");
        panel.add(lblTxt1);
        lblId1 = new JTextField();
        panel.add(lblId1);
        
        lblTxt2 = new JLabel("Id_produtora:");
        panel.add(lblTxt2);
        lblId2 = new JTextField();
        panel.add(lblId2);
        
        lblTxt3 = new JLabel("Nome:");
        panel.add(lblTxt3);
        lblNome = new JTextField();
        panel.add(lblNome);
        
        btnSend = new JButton("Send");
        btnSend.addActionListener(this);
        panel.add(btnSend);
        
        frame.pack();
        frame.setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		Produtora produtora = new Produtora();
		LocadoraController crud = new LocadoraController();
		
		produtora.setId_produtora(lblId2.getText());
		produtora.setNome(lblNome.getText());

		crud.update(produtora,lblId1.getText());	
	}
}
