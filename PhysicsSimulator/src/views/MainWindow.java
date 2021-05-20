package views;

import java.awt.BorderLayout;
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
		
		JPanel main = new ControlPanel(ctrl);
	
		mainPanel.add(main,BorderLayout.PAGE_START);
		BodiesTable bodiestable = new BodiesTable(ctrl, new BodiesTableModel(ctrl));
		bodiestable.setPreferredSize(new Dimension(800,300));
		bodiestable.setMaximumSize(new Dimension(Integer.MAX_VALUE,300));
		
		Viewer viewer = new Viewer(ctrl);
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.Y_AXIS));
		contentPanel.add(bodiestable);
		contentPanel.add(viewer);
		mainPanel.add(contentPanel,BorderLayout.CENTER);
		StatusBar status = new StatusBar(ctrl);
		mainPanel.add(status,BorderLayout.PAGE_END);
		this.setMinimumSize(new Dimension(900,700));
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
}
