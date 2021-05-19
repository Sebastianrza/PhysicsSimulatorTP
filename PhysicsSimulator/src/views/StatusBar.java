package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
		
		initGUI();
		ctrl.addObserver(this);
	}
	
	private void initGUI() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBorder(BorderFactory.createBevelBorder(1));
		this.setForeground(Color.gray);
		this._currTime = new JLabel(statusName[0]);
		add(_currTime);
		this.add(Box.createRigidArea(new Dimension(100, 0)));
		this._numOfBodies = new JLabel(statusName[1]);
		_numOfBodies.setPreferredSize(new Dimension(200,20));
		add(_numOfBodies);
		this.add(Box.createRigidArea(new Dimension(20, 0)));
		this._currLaws = new JLabel(statusName[2]);
		_currLaws.setPreferredSize(new Dimension(400,20));
		add(_currLaws);
		this.setVisible(true);
	
	}
	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String flawsDesc) {
		// TODO Auto-generated method stub
		_currTime.setText(statusName[0]+time);
		_numOfBodies.setText(statusName[1]+bodies.size());
		_currLaws.setText(statusName[2]+flawsDesc);
	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt, String flawsDesc) {
		// TODO Auto-generated method stub
		_currTime.setText(statusName[0]+time);
		_numOfBodies.setText(statusName[1]+bodies.size());
		_currLaws.setText(statusName[2]+flawsDesc);
	}

	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		// TODO Auto-generated method stub
		_numOfBodies.setText(statusName[1]+bodies.size());
	}

	@Override
	public void onAdvance(List<Body> bodies, Double time) {
		// TODO Auto-generated method stub
		_currTime.setText(statusName[0]+time);
	}

	@Override
	public void onDeltaTimeChanged(Double dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onForceLawsChanged(String flawsDesc) {
		// TODO Auto-generated method stub
		_currLaws.setText(statusName[2]+flawsDesc);
	}

}
