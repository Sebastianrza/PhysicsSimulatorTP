package simulator.control;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.PhysicsSimulator;

public class Controller {
	
	protected PhysicsSimulator ps;
	protected Factory<Body> fb;
	
	public Controller(PhysicsSimulator ps, Factory<Body> fb) {
		this.fb=fb;
		this.ps = ps;
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
	
	public void run(int n, OutputStream out, InputStream expOut, StateComparator cmp) {
		
		PrintStream p = new PrintStream(out);
		p.println("{");
		p.println("\"states\": [");
		p.print(ps);
		
		if(n != 0) p.println(", ");
		for (int i = 0; i < n; i++) {
			ps.advance();
			p.print(ps);
		}
		p.println("]");
		p.println("}");
		
	}
}
