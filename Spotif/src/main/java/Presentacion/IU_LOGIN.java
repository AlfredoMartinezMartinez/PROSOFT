package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import Dominio.GestorUsuario;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_LOGIN {

	private JFrame frmLogIn;
	private JPanel panel;
	private JLabel lblNombreUsario;
	private JLabel lblContraseaUsuario;
	private JTextField txtNombre;
	private JPasswordField pswPass;
	private JButton btnNuevoUsuario;
	private JButton btnInicoSesion;
	private JLabel lblNewLabel;
	private JLabel lblNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_LOGIN window = new IU_LOGIN();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IU_LOGIN() {
		initialize();
	}

	public JFrame getFrmVentanaLogIn() {
		return frmLogIn;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log In");
		frmLogIn.setIconImage(Toolkit.getDefaultToolkit().getImage(IU_LOGIN.class.getResource(
				"/presentacion/ProSoft_SinFondo (1)-iloveimg-resized-iloveimg-resized-iloveimg-resized.png")));
		frmLogIn.setBounds(100, 100, 822, 323);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		frmLogIn.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 67, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IU_LOGIN.class
				.getResource("/presentacion/ProSoft_SinFondo (1)-iloveimg-resized-iloveimg-resized.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridheight = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		lblNombreUsario = new JLabel("Nombre Usuario");
		GridBagConstraints gbc_lblNombreUsario = new GridBagConstraints();
		gbc_lblNombreUsario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreUsario.gridx = 4;
		gbc_lblNombreUsario.gridy = 2;
		panel.add(lblNombreUsario, gbc_lblNombreUsario);

		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 5;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 6;
		gbc_txtNombre.gridy = 2;
		panel.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		lblNombre = new JLabel("");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 12;
		gbc_lblNombre.gridy = 2;
		panel.add(lblNombre, gbc_lblNombre);

		lblContraseaUsuario = new JLabel("Contraseña Usuario");
		GridBagConstraints gbc_lblContraseaUsuario = new GridBagConstraints();
		gbc_lblContraseaUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblContraseaUsuario.gridx = 4;
		gbc_lblContraseaUsuario.gridy = 4;
		panel.add(lblContraseaUsuario, gbc_lblContraseaUsuario);

		pswPass = new JPasswordField();
		GridBagConstraints gbc_pswPass = new GridBagConstraints();
		gbc_pswPass.gridwidth = 5;
		gbc_pswPass.insets = new Insets(0, 0, 5, 5);
		gbc_pswPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_pswPass.gridx = 6;
		gbc_pswPass.gridy = 4;
		panel.add(pswPass, gbc_pswPass);

		btnInicoSesion = new JButton("InicioSesion");
		btnInicoSesion.addActionListener(new BtnInicoSesionActionListener());
		GridBagConstraints gbc_btnInicoSesion = new GridBagConstraints();
		gbc_btnInicoSesion.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInicoSesion.gridwidth = 2;
		gbc_btnInicoSesion.anchor = GridBagConstraints.SOUTH;
		gbc_btnInicoSesion.insets = new Insets(0, 0, 5, 5);
		gbc_btnInicoSesion.gridx = 4;
		gbc_btnInicoSesion.gridy = 6;
		panel.add(btnInicoSesion, gbc_btnInicoSesion);

		btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.addActionListener(new BtnNuevoUsuarioActionListener());
		GridBagConstraints gbc_btnNuevoUsuario = new GridBagConstraints();
		gbc_btnNuevoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNuevoUsuario.gridwidth = 3;
		gbc_btnNuevoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoUsuario.gridx = 8;
		gbc_btnNuevoUsuario.gridy = 6;
		panel.add(btnNuevoUsuario, gbc_btnNuevoUsuario);
	}

	private class BtnInicoSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				boolean autenticar1 = GestorUsuario.login(txtNombre.getText(),
						String.valueOf(pswPass.getPassword()));

				if (autenticar1) {

					lblNombre.setText("Usuario registrado");
					String tipo = GestorUsuario.tipo(txtNombre.getText(), String.valueOf(pswPass.getPassword()));
					if (tipo.equals("admin")) {

						IU_ADMINISTRADOR frame = new IU_ADMINISTRADOR();
						frame.setVisible(true);
						// frame.jLabelNusario.setText(jTextFieldUser.getText());
						frmLogIn.dispose();
					}
					if (tipo.equals("usuario")) {
						IU_USUARIO frame2 = new IU_USUARIO();
						frame2.setVisible(true);
						// frame2.jLabelNusario.setText(jTextFieldUser.getText());
						frmLogIn.dispose();
					}

				} else {

					lblNombre.setText("Usuario o contraseña incorrecta");
					txtNombre.setText("");
					pswPass.setText("");

				}
			} catch (Exception e) {
				e.printStackTrace();
			} // fin catch

		}
	}

	private class BtnNuevoUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			try {
				IU_CREARUSUARIO frame = new IU_CREARUSUARIO();
				frame.setVisible(true);
				frmLogIn.dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
			} // fin catch

		}
	}

}
