package dominio;

import java.io.File;

import javazoom.jlgui.basicplayer.BasicPlayer;

/**
 * Clase que se encarga de la reproduccion de musica
 * 
 * @author PROSOFT
 *
 */
public class GestorReproductorMusica {

	private BasicPlayer player = new BasicPlayer();

	public void reproducirMusica() throws Exception {
		player.play();
	}

	/**
	 * Metodo que mediante un objeto player abre un archivo de musica
	 * 
	 * @throws Exception
	 *             control de error
	 */
	public void abrirFichero() throws Exception {
		// player.open(new File("Dire Straits - Sultans Of Swing.mp3"));
		player.open(getClass().getResourceAsStream("/Dire Straits - Sultans Of Swing.mp3"));
	}

	/**
	 * Metodo que proporciona la funcion de pausa al sistema
	 * 
	 * @throws Exception
	 *             control de error
	 */
	public void pausa() throws Exception {
		player.pause();
	}

	/**
	 * Metodo que proporciona la funcion de continuar al sistema
	 * 
	 * @throws Exception
	 *             control de error
	 */
	public void continuar() throws Exception {
		player.resume();
	}

	/**
	 * Metodo que proporciona la funcion de stop al sistema
	 * 
	 * @throws Exception
	 *             control de error
	 */
	public void stop() throws Exception {
		player.stop();
	}

	/**
	 * metodo que proporciona un metodos de comprobacion para objetos no
	 * implementados	 * 
	 * 
	 */
	void setVisible(boolean b) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
