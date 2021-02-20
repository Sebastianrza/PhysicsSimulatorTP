package simulator.factories;

import org.json.JSONObject;

public abstract class Builder<T>{

	protected String typetag;
	
	public Builder(String typetag) {
		if(typetag ==null) {
			
			throw new IllegalArgumentException("Invalid type: "+ typetag);
		}
		
		else {
		
			this.typetag = typetag;
		
		}
	}
	
	public T createInstance(JSONObject info) {
		return null;
		
	}
	
	public JSONObject getBuilderInfo() {
		return null;
		
	}
}
