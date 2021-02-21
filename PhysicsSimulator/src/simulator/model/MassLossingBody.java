package simulator.model;

import simulator.misc.Vector2D;

public class MassLossingBody extends Body {
	
	protected double lossFactor;
	protected double lossFrequency;
	protected double c;//contador

	public MassLossingBody(String id, Vector2D position, Vector2D velocity, double mass, double lossFactor, double lossFrequency) {
		super(id, position, velocity, mass);
		// TODO Auto-generated constructor stub
		
		if(this.lossFactor >=0 && this.lossFactor <=1) {
			this.lossFactor = lossFactor;
		}
		if(this.lossFrequency>=0) {
			this.lossFrequency = lossFrequency;
		}
		this.c = 0.0;
	}
	
	void move(double t) {
		
		super.move(t);
		this.c += t;
		if(c >= this.lossFrequency) {
		this.mass = mass*(1-this.lossFactor);
		c=0.0;
		
		}
	}
	
}
