package views;

import javax.swing.JDialog;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;
import simulator.model.SimulatorObserver;

public class ForceLawsDialog extends JDialog {
	private JLabel info;
	private DefaultComboBoxModel comboBox;
	private Controller _ctrl;
	private JSONObject forcelawsinfo;
	private List<JSONObject> listForces;

	public ForceLawsDialog(Controller ctrl) {
		super();
		_ctrl = ctrl;
		initGUI();
	}

	@SuppressWarnings("unchecked")
	private void initGUI() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		this.setSize(700, 500);
		setTitle("Force Laws Selection");
		// panel informacion
		info = new JLabel();
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setAlignmentX(Component.CENTER_ALIGNMENT);
		info.setText(
				"<html><p>Select a force law and provide values for the parameters in the <b>Value column</b> (default values are used for parameters with no value).</p></html>");

		getContentPane().add(info);

		// tabla

		// panel combo box
		JPanel ForcePanel = new JPanel();

		JLabel forceLabel = new JLabel("Force Law: ");
		ForcePanel.add(forceLabel);

		listForces = _ctrl.getForceLawsInfo();

		comboBox = new DefaultComboBoxModel<>();
		for(JSONObject i : listForces) {
			comboBox.addElement(i.getString("desc"));
		}
	
		this.setVisible(true);
	}
}