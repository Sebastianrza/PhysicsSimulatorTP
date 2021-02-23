package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import simulator.model.Body;

public class BuilderBasedFactory<T> implements Factory<T> {

	private List<Builder<T>> builders;
	
	public  BuilderBasedFactory(List<Builder<T>> builders) {
		builders = new ArrayList<>(builders);
		// TODO Auto-generated constructor stub
	}
	@Override
	public T createInstance(JSONObject info) {
	/*	ArrayList<Builder<Body>> bodyBuilders = new ArrayList<>();
		bodyBuilders.add(new BasicBodyBuilder());
		bodyBuilders.add(new MassLosingBodyBuilder());
		Factory<Body> bodyFactory = new BuilderBasedFactory<Body>(bodyBuilders);*/
		return null;
	}

	@Override
	public List<JSONObject> getInfo() {
	
		return null;
	}

}
