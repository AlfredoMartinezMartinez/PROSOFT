package Dominio;

/**
 * Clase que permite crear objetos musica Metodos get/set
 * 
 * @author PROSOFT
 * 
 */
public class Musica {

	private String titulo;
	private String autor;
	private double coste;

	/**
	 * 
	 * @param titulo
	 *            Atributo que nos indica el nombre de la cancion/album
	 * @param autor
	 *            Atributo que nos indica el nombre del autor de la cancion/album
	 * @param coste
	 *            Atributo que nos indica el precio de la cancion/album
	 */
	public Musica(String titulo, String autor, double coste) {
		this.titulo = titulo;
		this.autor = autor;
		this.coste = coste;
	}

	/**
	 * Metodo que devuelve el titulo de la musica
	 * 
	 * @return titulo Devuelve el nombre de la cancion/album
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo que permite cambiar el titulo de musica
	 * 
	 * @param titulo
	 *            Cambia el nombre de la cancion/album
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Metodo que devuelve el autor de la musica
	 * 
	 * @return autor Devuelve el nombre del autor de la cancion/album
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Metodo que permite cambiar el autor de musica
	 * 
	 * @param autor
	 *            Cambia el nombre del autor de la cancion/album
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * Metodo que devuelve el coste de la musica
	 * 
	 * @return coste Devuelve el precio de la cancion/album
	 */
	public double getCoste() {
		return coste;
	}

	/**
	 * Metodo que permite cambiar el coste de musica
	 * 
	 * @param coste
	 *            Cambia el precio de la cancion/album
	 */
	public void setCoste(double coste) {
		this.coste = coste;
	}

}