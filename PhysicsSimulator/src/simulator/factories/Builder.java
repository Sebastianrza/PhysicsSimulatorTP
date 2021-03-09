package simulator.factories;

import org.json.JSONObject;

public abstract class Builder<T>{

	protected String typetag;
	protected String desc;
	public Builder(String typetag, String desc) {
		if(typetag ==null) {
			throw new IllegalArgumentException("invalid type: "+typetag);
		}else {
			this.typetag = typetag;
		}
		this.desc = desc;
	}
	
	public T createInstance(JSONObject info) {
		T b = null;
		if(info != null && typetag.equals(info.getString("type"))) {
			
			b = createInstance(info.getJSONObject("data"));
		}else {
			throw new IllegalArgumentException();
		}
		return b;
		
	}
	protected JSONObject createData() {
		return new JSONObject();
	}
	public JSONObject getBuilderInfo() {
		
		JSONObject info = new JSONObject();
		info.put("type", this.typetag);
		info.put("data", createData());
		info.put("desc", this.desc);
		
		return info;
		
	}
	
	protected abstract T createTheInstance(JSONObject data);
}
