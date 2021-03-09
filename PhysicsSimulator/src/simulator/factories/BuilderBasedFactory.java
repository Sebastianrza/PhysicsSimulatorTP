package simulator.factories;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class BuilderBasedFactory<T> implements Factory<T> {

	private List<Builder<T>> builders;
	static List<JSONObject> _factoryElements;
	
	public  BuilderBasedFactory(List<Builder<T>> builders) {
		this.builders = new ArrayList<>(builders);
		_factoryElements = new ArrayList<JSONObject>();
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
		_factoryElements = new ArrayList<JSONObject>();
		for (Builder<T> b : builders) {
			_factoryElements.add(b.getBuilderInfo());
		}
		return _factoryElements;
	}

}
