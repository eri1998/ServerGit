package com.danilo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.danilo.niti.ServerNit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerForma extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					 
					 UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

					ServerForma serverForma = new ServerForma();
					serverForma.setVisible(true);
					 

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public ServerForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPokreniServer = new JButton("Pokreni Server");
		btnPokreniServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ServerNit sn = new ServerNit();
			    sn.start();
			}
		});
		btnPokreniServer.setBounds(148, 111, 123, 23);
		contentPane.add(btnPokreniServer);
	}
}
