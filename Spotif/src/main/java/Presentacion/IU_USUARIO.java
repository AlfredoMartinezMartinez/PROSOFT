package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Dominio.Gestor_Reproductor_Musica;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class IU_USUARIO {

	private JFrame frame;
	private JPanel panel;
	private JButton btnPlay;
	private Gestor_Reproductor_Musica gestor_reproductor = new Gestor_Reproductor_Musica();
	private JLabel lblMensaje;
	private JButton btnPausa;
	private JButton btnStop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_USUARIO window = new IU_USUARIO();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IU_USUARIO() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				btnPlay = new JButton("Play");
				btnPlay.addActionListener(new BtnPlayActionListener());
				btnPlay.setBounds(154, 66, 115, 29);
				panel.add(btnPlay);
			}
			{
				lblMensaje = new JLabel("");
				lblMensaje.setBounds(177, 207, 69, 20);
				panel.add(lblMensaje);
			}
			{
				btnPausa = new JButton("Pausa");
				btnPausa.addActionListener(new BtnPausaActionListener());
				btnPausa.setBounds(154, 106, 115, 29);
				panel.add(btnPausa);
			{
				btnStop = new JButton("Stop");
				btnStop.addActionListener(new BtnStopActionListener());
						
				btnStop.setBounds(154, 146, 115, 29);
				panel.add(btnStop);
				
				}
				//btnStop.setEnabled(false);
				//btnPausa.setEnabled(false);
			}
		}
	}
	private class BtnPlayActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				if(btnPausa.isEnabled()==false){
					gestor_reproductor.Continuar();
					btnPausa.setEnabled(true);}
				else{
				gestor_reproductor.AbrirFichero();
				gestor_reproductor.reproducirMusica();
				btnPausa.setEnabled(true);
				btnPlay.setEnabled(false);}
				
					
			}catch (Exception e) {
				lblMensaje.setText(e.getMessage());
			}
			
			
		}
	}
	private class BtnPausaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				btnPlay.setEnabled(true);
				gestor_reproductor.Pausa();
				btnPausa.setEnabled(false);
				//btnPausa.setEnabled(b);
			} catch (Exception e) {
				lblMensaje.setText(e.getMessage());
			}
		}
	}
	
	private class BtnStopActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				
				gestor_reproductor.Stop();
				btnPausa.setEnabled(true);
				btnPlay.setEnabled(true);				
			} catch (Exception e) {
				lblMensaje.setText(e.getMessage());
			}
		}
	}
	
}
