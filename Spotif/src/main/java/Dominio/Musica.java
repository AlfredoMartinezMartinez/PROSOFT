package Dominio;

public class Musica {
	
	private String titulo;
	private String autor;
	private double coste;
	
	public Musica(String titulo,String autor,double coste){
		this.titulo=titulo;
		this.autor=autor;
		this.coste=coste;
	}
	
	public String getTitulo(){
		return titulo;
	}
	public void setTitulo(String titulo){
		this.titulo=titulo;
	}
	public String getAutor(){
		return autor;
	}
	public void setAutor(String autor){
		this.autor=autor;
	}
	public double getCoste(){
		return coste;
	}
	public void setCoste(double coste){
		this.coste=coste;
	}

}