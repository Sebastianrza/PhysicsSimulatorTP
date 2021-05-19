package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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
		this.setContentPane(mainPanel);
		//mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		
		
		JPanel menu = new ControlPanel(ctrl);
		//menu.setPreferredSize(new Dimension(800,30));
		mainPanel.add(menu,BorderLayout.PAGE_START);
		BodiesTable bodies = new BodiesTable(ctrl, new BodiesTableModel(ctrl));
		bodies.setPreferredSize(new Dimension(800,300));
		bodies.setMaximumSize(new Dimension(Integer.MAX_VALUE,300));
		
		Viewer viewer = new Viewer(ctrl);
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.Y_AXIS));
		contentPanel.add(bodies);
		contentPanel.add(viewer);
		mainPanel.add(contentPanel,BorderLayout.CENTER);
		StatusBar status = new StatusBar(ctrl);
		mainPanel.add(status,BorderLayout.PAGE_END);
		this.setMinimumSize(new Dimension(700,900));
		// TODO complete this method to build the GUI
		// ..
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
}
