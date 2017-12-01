package Dominio;
import java.io.File;

import javazoom.jlgui.basicplayer.BasicPlayer;

public class GestorReproductorMusica {

		private BasicPlayer player = new BasicPlayer();
		public void reproducirMusica() throws Exception{
			player.play();
		}
		
		public void AbrirFichero() throws Exception{
			//player.open(new File("Dire Straits - Sultans Of Swing.mp3"));
			player.open(getClass().getResourceAsStream("/Dire Straits - Sultans Of Swing.mp3"));
		}
		
	    public void Pausa() throws Exception {
	        player.pause();
	    }

	    public void Continuar() throws Exception {
	        player.resume();
	    }

	    public void Stop() throws Exception {
	        player.stop();
	    }
	    
	    void setVisible(boolean b) {
	        throw new UnsupportedOperationException("Not supported yet.");
	    }
}
