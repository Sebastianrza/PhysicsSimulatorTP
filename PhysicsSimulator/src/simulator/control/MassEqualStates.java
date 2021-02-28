package simulator.control;

import org.json.JSONObject;

public class MassEqualStates implements StateComparator {

	@Override
	public boolean equal(JSONObject s1, JSONObject s2) {
		
		if(s1.get("time") == s2.get("time")){
			
			for (int i=0; i < s1.getJSONArray("bodies").length(); i++) {
				
				if(s1.getJSONArray("bodies").getJSONObject(i).get("id") == s2.getJSONArray("bodies").getJSONObject(i).get("id")){
					if(s1.getJSONArray("bodies").getJSONObject(i).get("mass") == s2.getJSONArray("bodies").getJSONObject(i).get("mass"));
				}else{
					return false;
				}	
			}
			
		}else{
			return false;
		}
		
		return true;
				
	}

}
