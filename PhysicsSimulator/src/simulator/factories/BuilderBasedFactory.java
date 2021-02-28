package simulator.factories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
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
		return null;
		
	}

	@Override
	public List<JSONObject> getInfo() {
		
		List<JSONObject> bu = new ArrayList<JSONObject>();
		for(int i = 0; i<builders.size(); i++) {
			bu.add(builders.get(i).getBuilderInfo());
		}
		return bu;
	}

}
