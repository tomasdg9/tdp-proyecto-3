package Entidades.Estaticas;

import GUI.PowerPelletGUI;
import Visitors.Visitor;

public class PowerPellet extends Pocion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PowerPelletGUI miRepresentacion;
	
	public PowerPellet(String powerPellet) {
		miRepresentacion = new PowerPelletGUI(powerPellet);
		this.representacion = powerPellet;
		tamano = 20;
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
}
