package simulator.model;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class Body {
	
	protected String id;
	protected Vector2D force;
	protected Vector2D position;
	protected Vector2D velocity;
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
	//Metodos
	
	void addForce(Vector2D f) {
		this.force.plus(f);
	}
	void resetForce() {
	
	}
	void move(double t) {
		
	}
	
	public JSONObject getState() {
		return null;
		
	}
	public String toString() {
		return id;
		
	}
}

