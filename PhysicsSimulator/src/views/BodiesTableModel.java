package views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class BodiesTableModel extends AbstractTableModel implements SimulatorObserver{

	private static final long serialVersionUID = 1L;
	private List<Body> _bodies;
	private String _colNames[] = {"Id", "Mass", "Position", "Velocity", "Force"};
	
	BodiesTableModel (Controller ctrl) {
		_bodies = new ArrayList<>();
		ctrl.addObserver(this);
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this._bodies.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this._colNames.length;
	}
	public String getColumnName(int column) {
		return this._colNames[column];
		
	}
	
	private void update(List<Body> b) {
		this._bodies = b;
		fireTableStructureChanged();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String s = "";
		Body b = this._bodies.get(rowIndex);
		
		switch(columnIndex) {
			case 0: //id
				s = b.getId().toString();
				break;
			case 1: //masa
				s = ""+ b.getMass();
				break;
			case 2:	//posision
				s = ""+ b.getPosition().asJSONArray();
				break;
			case 3:	//velocidad
				s = "" + b.getVelocity().asJSONArray();
				break;
			case 4:	//fuerza
				s = "" + b.getForce().asJSONArray();
				break;
			default:
				assert(false);
		}
		return s;
	}

	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String flawsDesc) {
		// TODO Auto-generated method stub
		update(bodies);
		
	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt, String flawsDesc) {
		// TODO Auto-generated method stub
		update(bodies);
	}

	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		// TODO Auto-generated method stub
		update(bodies);
	}

	@Override
	public void onAdvance(List<Body> bodies, Double time) {
		// TODO Auto-generated method stub
		update(bodies);
	}

	@Override
	public void onDeltaTimeChanged(Double dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onForceLawsChanged(String flawsDesc) {
		// TODO Auto-generated method stub
		
	}

}
