package simulator.control;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class EpsilonEqualStates implements StateComparator{
	
	protected double eps = 0.00;
	
	public EpsilonEqualStates(double eps) {
		this.eps = eps;
	}

	@Override
	public boolean equal(JSONObject s1, JSONObject s2) {
		// TODO Auto-generated method stub

		if(s1.getDouble("time") == s2.getDouble("time")&& s1.getJSONArray("bodies").length() == s2.getJSONArray("bodies").length()){

			for (int i=0; i < s1.getJSONArray("bodies").length(); i++) {
				JSONObject boS1 = s1.getJSONArray("bodies").getJSONObject(i);
				JSONObject boS2 = s2.getJSONArray("bodies").getJSONObject(i);
				
				if(boS1.getString("id").equals(boS2.getString("id"))){
					try{
					if(Math.abs(boS1.getDouble("m") - boS2.getDouble("m")) <= eps){
						
						Vector2D pS1 = new Vector2D (boS1.getJSONArray("p").getDouble(0), boS1.getJSONArray("p").getDouble(1));
						Vector2D pS2 = new Vector2D (boS2.getJSONArray("p").getDouble(0), boS2.getJSONArray("p").getDouble(1));
	
						if(pS1.distanceTo(pS2) <= eps){
							Vector2D vS1 = new Vector2D (boS1.getJSONArray("v").getDouble(0), boS1.getJSONArray("v").getDouble(1));
							Vector2D vS2 = new Vector2D (boS2.getJSONArray("v").getDouble(0), boS2.getJSONArray("v").getDouble(1));
		
							if(vS1.distanceTo(vS2) <= eps){
								Vector2D fS1 = new Vector2D (boS1.getJSONArray("f").getDouble(0), boS1.getJSONArray("f").getDouble(1));
								Vector2D fS2 = new Vector2D (boS2.getJSONArray("f").getDouble(0), boS2.getJSONArray("f").getDouble(1));
			
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
