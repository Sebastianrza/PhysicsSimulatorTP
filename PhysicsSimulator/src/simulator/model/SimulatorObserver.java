package simulator.model;

import java.util.List;

public interface SimulatorObserver {
	
	public void onRegister(List<Body> bodies, double time, double dt, String flawsDesc);
	public void onReset(List<Body> bodies, double time, double dt, String flawsDesc);
	public void onBodyAdded(List<Body> bodies, Body b);
	public void onAdvance(List<Body> bodies, Double time);
	public void onDeltaTimeChanged(Double dt);
	public void onForceLawsChanged(String flawsDesc);

}
