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
						
						Vector2D pS1 = new Vector2D (firstDouble(boS1.get("p").toString()), seconDouble(boS1.get("p").toString()));
						Vector2D pS2 = new Vector2D (firstDouble(boS2.get("p").toString()), seconDouble(boS2.get("p").toString()));
	
						if(pS1.distanceTo(pS2) <= eps){
							Vector2D vS1 = new Vector2D (firstDouble(boS1.get("v").toString()), seconDouble(boS1.get("v").toString()));;
							Vector2D vS2 = new Vector2D (firstDouble(boS2.get("v").toString()), seconDouble(boS2.get("v").toString()));
							
							if(vS1.distanceTo(vS2) <= eps){
								Vector2D fS1 = new Vector2D (firstDouble(boS1.get("f").toString()), seconDouble(boS1.get("f").toString()));
								Vector2D fS2 = new Vector2D (firstDouble(boS2.get("f").toString()), seconDouble(boS2.get("f").toString()));
								
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
	
	
	private double firstDouble (String s){
		return Double.parseDouble(s.substring(1, (s.indexOf(','))));
	}
	private double seconDouble (String s){
		return Double.parseDouble(s.substring((s.indexOf(','))+1, s.length() -1));

	}

}
