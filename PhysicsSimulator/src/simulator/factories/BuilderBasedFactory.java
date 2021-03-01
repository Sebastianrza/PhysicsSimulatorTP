package simulator.factories;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class BuilderBasedFactory<T> implements Factory<T> {

	private List<Builder<T>> builders;
	
	public  BuilderBasedFactory(List<Builder<T>> builders) {
		builders = new ArrayList<>(builders);
		// TODO Auto-generated constructor stub
	}
	@Override
	public T createInstance(JSONObject info) {
		if (info != null) {
            for (Builder<T> bb : builders) {
                T o = bb.createInstance(info);

                if (o != null) {
                    return o;
                    }
            }
        } 

        throw new IllegalArgumentException("Invalid value for createInstance: " + info);

		
	}

	@Override
	public List<JSONObject> getInfo() {
		
		List<JSONObject> bu = new ArrayList<JSONObject>();
		
		for(Builder<T> b : builders) {
			bu.add(b.getBuilderInfo());
		}

		return bu;
	}

}
