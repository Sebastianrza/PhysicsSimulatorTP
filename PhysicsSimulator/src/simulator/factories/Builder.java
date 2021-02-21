package simulator.factories;

import org.json.JSONObject;

public abstract class Builder<T>{

	protected final String typetag;
	
	public Builder(String typetag) {
		if(typetag ==null) {
			
			throw new IllegalArgumentException("Invalid type: "+ typetag);
		}
		
		else {
		
			this.typetag = typetag;
		
		}
	}
	
	public T createInstance(JSONObject info) {
		T b = null;
		if(typetag != null && typetag.equals(info.getString("type"))) {
			
			b = createInstance(info.getJSONObject("data"));
		}else {
			throw new IllegalArgumentException();
		}
		return b;
		
	}
	
	public JSONObject getBuilderInfo() {
		return null;
		
	}
}
