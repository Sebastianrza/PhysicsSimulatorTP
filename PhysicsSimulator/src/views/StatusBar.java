package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class StatusBar extends JPanel implements SimulatorObserver{

	private static final long serialVersionUID = 1L;
	
	private JLabel _currTime;
	private JLabel _currLaws;
	private JLabel _numOfBodies;
	private static String[] statusName = {"Time: ", "Bodies: ", "Laws: "};
	StatusBar(Controller ctrl){
		this._currLaws = new JLabel();
		this._currTime = new JLabel("0.00");
		this._numOfBodies = new JLabel("0");
		initGUI();
		ctrl.addObserver(this);
	}
	
	private void initGUI() {
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.setBorder(BorderFactory.createBevelBorder(1));
		this.setForeground(Color.gray);
	
	}
	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String flawsDesc) {
		// TODO Auto-generated method stub
		_numOfBodies.setText(Integer.toString(bodies.size()));
		_currTime.setText(Double.toString(time));
		_currLaws.setText(flawsDesc.toString());
	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt, String flawsDesc) {
		// TODO Auto-generated method stub
		_numOfBodies.setText(Integer.toString(bodies.size()));
		_currTime.setText(Double.toString(time));
		_currLaws.setText(flawsDesc.toString());
	}

	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		// TODO Auto-generated method stub
		_numOfBodies.setText(Integer.toString(bodies.size()));
	}

	@Override
	public void onAdvance(List<Body> bodies, Double time) {
		// TODO Auto-generated method stub
		_currTime.setText(Double.toString(time));
	}

	@Override
	public void onDeltaTimeChanged(Double dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onForceLawsChanged(String flawsDesc) {
		// TODO Auto-generated method stub
		_currLaws.setText(flawsDesc);
	}

}
