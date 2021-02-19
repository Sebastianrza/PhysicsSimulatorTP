package simulator.model;

import simulator.misc.Vector2D;

public class MassLossingBody extends Body {
	
	protected double lossFactor;
	protected double lossFrequency;
	protected double contador;

	public MassLossingBody(double lossFactor, double lossFrequency,String id, Vector2D position, Vector2D velocity, double mass) {
		super(id, position, velocity, mass);
		// TODO Auto-generated constructor stub
		
		if(this.lossFactor >=0 && this.lossFactor <=1) {
			this.lossFactor = lossFactor;
		}
		if(this.lossFrequency>=0) {
			this.lossFrequency = lossFrequency;
		}
		this.contador = contador;
	}
	
	void move(double t) {
		
		
	}
	
}
