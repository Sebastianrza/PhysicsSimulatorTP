package simulator.control;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class EpsilonEqualStates implements StateComparator{
	
	protected double eps;
	
	public EpsilonEqualStates(double eps) {
		this.eps = eps;
	}

	@Override
	public boolean equal(JSONObject s1, JSONObject s2) {
		// TODO Auto-generated method stub
		if(s1.get("time") == s2.get("time")){
			
			for (int i=0; i < s1.getJSONArray("bodies").length(); i++) {
				JSONObject boS1 = s1.getJSONArray("bodies").getJSONObject(i);
				JSONObject boS2 = s2.getJSONArray("bodies").getJSONObject(i);
				
				
				if(boS1.get("id") == boS2.get("id")){
					try{
					if(Math.abs(boS1.getDouble("m") - boS2.getDouble("m")) <= eps){
						Vector2D pS1 = (Vector2D) boS1.get("p");
						Vector2D pS2 = (Vector2D) boS2.get("p");
	
						if(pS1.distanceTo(pS2) <= eps){
							Vector2D vS1 = (Vector2D) boS1.get("v");
							Vector2D vS2 = (Vector2D) boS2.get("v");
							
							if(vS1.distanceTo(vS2) <= eps){
								Vector2D fS1 = (Vector2D) boS1.get("f");
								Vector2D fS2 = (Vector2D) boS2.get("f");
								
								if(fS1.distanceTo(fS2) <= eps){
									
								}else{
									return false;
								}
							}else{
								return false;
							}
						}else{
							return false;
						}
					}else{
						return false;
					}
					}catch(ClassCastException e){
						System.out.println("Error: Vector2D cant be cast class EpsilonEqualStates");
					}
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
