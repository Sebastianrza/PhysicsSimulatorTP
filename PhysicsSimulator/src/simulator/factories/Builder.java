package simulator.factories;

import org.json.JSONObject;

public abstract class Builder<T>{

	protected String typetag;
	
	public Builder() {
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
		
		JSONObject info = new JSONObject();
		info.put("type", this.typetag);
		info.put("data", createData());
		return info;
		
	}
	public JSONObject createData() {
		return new JSONObject();
	}
	protected abstract T createTheInstance(JSONObject data);
}
