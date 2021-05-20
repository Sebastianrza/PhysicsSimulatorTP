package simulator.control;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;


import simulator.model.Body;
import simulator.model.SimulatorObserver;
import views.ForceLawsDialog;

public class ControlPanel extends JPanel implements SimulatorObserver {

	private static final long serialVersionUID = 1L;
	
	private Controller ctrl;
	private boolean _stopped=false;
	private JButton fileChoose;
	private JButton stop;
	private JButton run;
	private JButton exit;
	private JButton fl;
	private JSpinner steps;
	private JTextField dta;
	private JFileChooser file;
	private String fFilePath;
	
	
	public ControlPanel(Controller ctrl){
		this.ctrl = ctrl;
		initGUI();
		ctrl.addObserver(this);
	}
	
	private void initGUI() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JToolBar toolBar = new JToolBar("Control Panel");
		file = new JFileChooser(new File("resources/examples"));
		fFilePath = new String();
		
		this.fileChoose = new JButton();
		this.fileChoose.setToolTipText("Open a File");
		this.fileChoose.setIcon(new ImageIcon("resources/icons/open.png"));
		toolBar.add(this.fileChoose);
		toolBar.addSeparator();
		
		this.fl = new JButton();
		this.fl.setToolTipText("Change Forces Laws");
		this.fl.setIcon(new ImageIcon("resources/icons/physics.png"));
		this.fl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ForceLawsDialog fld = new ForceLawsDialog(ctrl);
				
			}
		});
		toolBar.add(this.fl);
		toolBar.addSeparator();
		
		this.run = new JButton();
		this.run.setToolTipText("Run simulation");
		this.run.setIcon(new ImageIcon("resources/icons/run.png"));
		toolBar.add(this.run);
		
		this.stop = new JButton();
		this.stop.setToolTipText("Stop simulation");
		this.stop.setIcon(new ImageIcon("resources/icons/stop.png"));
		toolBar.add(this.stop);
		
		toolBar.add(new JLabel("Steps:"));
		this.steps = new JSpinner(new SpinnerNumberModel(10000, 0, Integer.MAX_VALUE, 1));
		this.steps.setToolTipText("Simulation steps to run: 1-10000");
		this.steps.setMaximumSize(new Dimension(80, 40));
		this.steps.setMinimumSize(new Dimension(80, 40));
		this.steps.setPreferredSize(new Dimension(80, 40));
		toolBar.add(this.steps);
		
		toolBar.add(new JLabel("Delta-Time:"));
		this.dta = new JTextField(5);
		this.dta.setToolTipText("Change Delta-Time");
		this.dta.setMaximumSize(new Dimension(80, 40));
		this.dta.setMinimumSize(new Dimension(80, 40));
		this.dta.setPreferredSize(new Dimension(80, 40));
		this.dta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			try {
				ctrl.setDeltaTime(Double.parseDouble(dta.getText()));
				}catch (Exception e2){
					
				}
				
			}});
		toolBar.add(this.dta);
		
		
		this.exit = new JButton ();
		this.exit.setToolTipText("exit simulation");
		this.exit.setIcon(new ImageIcon("resources/icons/exit.png"));
		
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
		
		this.add(toolBar, BorderLayout.LINE_START);
		this.add(this.exit);
		
		
		
		this.fileChoose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int r = file.showOpenDialog(null);
				if(r == JFileChooser.APPROVE_OPTION) {
					fFilePath = (file.getSelectedFile().getAbsolutePath());
				}
				
				if(r == JFileChooser.CANCEL_OPTION) fFilePath = null;
				
				if(fFilePath != null) {
					try {
						InputStream fileInStream = new FileInputStream(new File(fFilePath));
						ctrl.reset();
						ctrl.loadBodies(fileInStream);
						
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Archivo incorrecto no puede leerse", "Error al cargar archivo", JOptionPane.WARNING_MESSAGE);
						ex.printStackTrace();
					}
				}
			}
			
		});
		
		this.run.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	fl.setEnabled(false);
            	fileChoose.setEnabled(false);
				run.setEnabled(false);
				_stopped = false;
				try {
				double delta = Double.parseDouble(dta.getText());
				ctrl.setDeltaTime(delta);
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(new JFrame(),
		                    "Colocar valor valido para Delta",
		                    "Error",
		                    JOptionPane.ERROR_MESSAGE);
				}
				int stepsNum = (int) steps.getValue();
				run_sim(stepsNum);
            	
            }
        });
		
		this.stop.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	stop();
            }
        });
		this.exit.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            
            	int n = JOptionPane.showOptionDialog(new JFrame(),
						 "Are sure you want to quit?", "Quit",
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						 null, null);
						 if (n == 0) {System.exit(0); }
            }
        });
	}
	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String flawsDesc) {
		// TODO Auto-generated method stub
		dta.setText(Double.toString(dt));
	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt, String flawsDesc) {
		// TODO Auto-generated method stub
		dta.setText(Double.toString(dt));
	}

	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAdvance(List<Body> bodies, Double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDeltaTimeChanged(Double dt) {
		// TODO Auto-generated method stub
		dta.setText(Double.toString(dt));
	}

	@Override
	public void onForceLawsChanged(String flawsDesc) {
		// TODO Auto-generated method stub
		
	}
	
	private void run_sim(int n) {;
		if(n>0 && !_stopped) {
			try {
				ctrl.run(1);
			}catch(Exception e) {
				_stopped = true;
				return;
			}
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					run_sim(n-1);
					
				}
				
			});
		}else {
			stop();
			_stopped = true;
		}
	}
	private void stop() {
		JButtonStatus(true);
		_stopped = true;
	}
	protected void JButtonStatus(boolean b) {
		fileChoose.setEnabled(b);
		run.setEnabled(b);
		exit.setEnabled(b);
		stop.setEnabled(b);
		fl.setEnabled(b);
		dta.setEnabled(b);
		steps.setEnabled(b);
	}

}
