package simulator.model;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class Body {
	
	protected String id;
	protected Vector2D force = new Vector2D();
	protected Vector2D position;
	protected Vector2D velocity;
	protected Vector2D acceleration;
	protected double mass;
	
	//Constructor
	
	public Body(String id, Vector2D position, Vector2D velocity, Double mass) {
		this.id = id;
		this.position = position;
		this.velocity = velocity;
		this.mass = mass;
	}
	
	//Getters and Setters
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Vector2D getForce() {
		return force;
	}
	public void setForce(Vector2D force) {
		this.force = force;
	}
	public Vector2D getPosition() {
		return position;
	}
	public void setPosition(Vector2D position) {
		this.position = position;
	}
	public Vector2D getVelocity() {
		return velocity;
	}
	public void setVelocity(Vector2D velocity) {
		this.velocity = velocity;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	
	public Vector2D getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(Vector2D acceleration) {
		this.acceleration = acceleration;
	}
	
	//Metodos
	
	void addForce(Vector2D f) {
		this.force.plus(f);
	}
	void resetForce() {
		this.force = new Vector2D();
	}
	void move(double t) {
		
		if(this.mass == 0) {
			this.acceleration = new Vector2D();
		}else {
			this.acceleration = this.force.scale(1/mass); // si falla algo revisar 
		}
		this.position = position.plus(velocity.scale(t).plus(acceleration.scale(t*t/2)));
		this.velocity = velocity.plus(acceleration.scale(t));
				
				
	}
	
	public JSONObject getState() {
		
		JSONObject bo = new JSONObject();
		bo.put("id", this.id);
		bo.put("m", this.mass);
		bo.put("p", this.position);
		bo.put("v", this.velocity);
		bo.put("f", this.force);
		
		
		return bo;
		
	}
	public String toString() {
		return getState().toString();
		
	}
}

