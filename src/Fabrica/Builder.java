package Fabrica;

import Logica.Nivel;

public interface Builder {

	public void reset();
	public void setPared(Tema tema,int x, int y, int repre);
	public void setProtagonista(Tema tema,int x, int y);
	public void setEnemigos(Tema tema,int x, int y);
	public void setCantPuntos();
	public void setFruta(Tema tema, int x, int y, int i);
	public void setPowerPellet(Tema tema, int x, int y);
	public void setPacDot(Tema tema, int x, int y);
	public void setBomba(Tema tema, int x, int y);
	public void setVelocidad(Tema tema,int x, int y);
	public Nivel getResult();
	public void setBlinky(Tema tema, int i, int j);
	public void setInky(Tema tema, int i, int j);
	public void setPinky(Tema tema, int i, int j);
	public void setClyde(Tema tema, int i, int j);
	
}
