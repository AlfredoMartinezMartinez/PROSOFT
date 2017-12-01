package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Dominio.GestorReproductorMusica;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import javax.swing.JTextField;
import java.awt.Toolkit;

public class IU_USUARIO {

	private JFrame frmProsoft;
	private JPanel panel;
	private JButton btnPlay;
	private GestorReproductorMusica gestor_reproductor = new GestorReproductorMusica();
	private JLabel lblMensaje;
	private JButton btnPausa;
	private JButton btnStop;
	private JButton btnBuscar;
	private JTextField textFieldBuscar;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_USUARIO window = new IU_USUARIO();
					window.frmProsoft.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

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
		frmProsoft = new JFrame();
		frmProsoft.setVisible(true);
		frmProsoft.setTitle("Prosoft");
		frmProsoft.setIconImage(Toolkit.getDefaultToolkit().getImage(IU_USUARIO.class.getResource("/imagenes/ProSoft_SinFondo.png")));
		frmProsoft.setBounds(100, 100, 720, 460);
		frmProsoft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			panel = new JPanel();
			frmProsoft.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				btnPlay = new JButton("Play");			
				btnPlay.addActionListener(new BtnPlayActionListener());
				btnPlay.setBounds(150, 290, 100, 30);
				panel.add(btnPlay);
			}
			{
				lblMensaje = new JLabel("");
				lblMensaje.setBounds(152, 234, 143, 16);
				panel.add(lblMensaje);
			}
			{
				btnPausa = new JButton("Pausa");
				btnPausa.addActionListener(new BtnPausaActionListener());
				btnPausa.setBounds(278, 290, 100, 30);
				panel.add(btnPausa);
			{
				btnStop = new JButton("Stop");
				btnStop.addActionListener(new BtnStopActionListener());
						
				btnStop.setBounds(408, 290, 100, 30);
				panel.add(btnStop);
				
				}
				//btnStop.setEnabled(false);
				//btnPausa.setEnabled(false);
			}
			{
				btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(309, 11, 100, 30);
				panel.add(btnBuscar);
			}
			{
				textFieldBuscar = new JTextField();
				textFieldBuscar.setBounds(420, 11, 250, 30);
				panel.add(textFieldBuscar);
				textFieldBuscar.setColumns(10);
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
