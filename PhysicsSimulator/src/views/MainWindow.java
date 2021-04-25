package views;

import java.awt.BorderLayout;

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
		
	}

}
