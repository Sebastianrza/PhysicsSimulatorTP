package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import simulator.control.ControlPanel;
import simulator.control.Controller;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	Controller ctrl;
	
	public MainWindow(Controller ctrl) {
		super("Physics Simulator");
		this.ctrl = ctrl;
		initGUI();
	}
	
	private void initGUI(){
		
		 JPanel mainPanel = new JPanel(new BorderLayout());
		 setContentPane(mainPanel);
		 mainPanel.add(new ControlPanel(ctrl), BorderLayout.PAGE_START);
		 mainPanel.add(new StatusBar(ctrl), BorderLayout.PAGE_END);
		 
		 mainPanel.add(centerPanel(), BorderLayout.CENTER);
		 
		 
		 
		 this.setVisible(true);
		 this.setBounds(400, 0, 800, 800);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private JPanel centerPanel() {
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(Color.WHITE);
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

		panelCentral.add(new BodiesTable(ctrl));
		panelCentral.add(new Viewer(ctrl));

		return panelCentral;

	}

}
