package simulator.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.ForceLaws;
import simulator.model.PhysicsSimulator;
import simulator.model.SimulatorObserver;

public class Controller {
	
	protected PhysicsSimulator ps;
	protected Factory<Body> fb;
	protected Factory<ForceLaws> fl;
	
	public Controller(PhysicsSimulator ps, Factory<Body> fb, Factory<ForceLaws> fl ) {
		this.fb=fb;
		this.ps = ps;
		this.fl = fl;
	}
	
	//Getters and Setters
	public PhysicsSimulator getPs() {
		return ps;
	}

	public void setPs(PhysicsSimulator ps) {
		this.ps = ps;
	}

	public Factory<Body> getFb() {
		return fb;
	}

	public void setFb(Factory<Body> fb) {
		this.fb = fb;
	}

	public void loadBodies(InputStream in) {
		try {
		
			JSONObject jsonInput = new JSONObject(new JSONTokener(in));
			JSONArray bodies = jsonInput.getJSONArray("bodies");
			
			for(int i = 0; i < bodies.length(); i++) {
				
				ps.addBody(fb.createInstance(bodies.getJSONObject(i)));
				
			}
			
		}catch(JSONException ex) {
			throw new IllegalArgumentException("Invalid JSONObject bodies ", ex);
		}
		
	}
	
	public void run(int n, OutputStream out, InputStream expOut, StateComparator cmp) throws Exception {
		PrintStream p = new PrintStream(out);
		p.println("{");
		p.println("\"states\": [");
		
		if(expOut !=null) {
			
			JSONObject ex = new JSONObject(new JSONTokener(expOut));
				
			for (int i = 0; i <= n; i++) {
				if(cmp.equal(ps.getState(),ex.getJSONArray("states").getJSONObject(i))) {
					
					p.print(ps.getState());
					this.ps.advance();
					
					if(i!=n)p.println(",");
				}else {
					throw new Exception("States Diferent " + ps.getState() + " in the time " + ps.getTime());
				}
				
			}
		
		}else {
			for (int i = 0; i <= n; i++) {
					p.println(ps.getState());
					this.ps.advance();
					if(i!=n)p.print(",");
			}
		}
		
		p.println("]");
		p.println("}");
	}
	@SuppressWarnings("resource")
	public void run(int n) {
		new OutputStream() {
				@Override
				public void write(int b) throws IOException {
					// TODO Auto-generated method stub
					}
			};
			for (int i = 0; i <= n; i++) {
				
				this.ps.advance();
			
		}
	}
	public void reset() {
		this.ps.reset();
	}
	public void setDeltaTime(Double dt) {
		this.ps.setTimeReal(dt);
	}
	public void addObserver(SimulatorObserver o) {
		this.ps.addObserver(o);
	}
	
	public List<JSONObject>getForceLawsInfo(){
		return this.fl.getInfo();
		
	}
	public void setForceLaws(JSONObject info){
		this.fl.createInstance(info);
	}
}
