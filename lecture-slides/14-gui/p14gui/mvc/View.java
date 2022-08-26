package it.unibo.apice.oop.p15gui.mvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame implements ViewInterface{
	
	private static final long serialVersionUID = 4944349615829626265L;
	final public static String WINDOW_TITLE = "PersonEditor";
	final public static String[] PROPS = new String[]{"Name","Surname","Code","Birth Year","Gender"};
	final private Object[][] INIT_DATA = new Object[][]{};
	final private JTable table = new JTable(new DefaultTableModel(INIT_DATA,PROPS));
	final private JButton bLoad = new JButton("Load");
	final private JButton bSave = new JButton("Save");
	final private JButton bAdd = new JButton("Add");
	final private JButton bQuit = new JButton("Quit");
	final private Form formDialog = new Form(this);
	
	private ViewObserver controller;
	
	public View(){
		super(WINDOW_TITLE);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(800,480);
		this.setResizable(false);
		this.buildLayout();
		this.setHandlers();
		this.setVisible(true);
	}
	
	@Override
	public void attachViewObserver(ViewObserver controller){
		this.controller = controller;
	}
	
	@Override
	public void commandFailed(String message) {
		JOptionPane.showMessageDialog(this,
			    message,
			    "An error occurred",
			    JOptionPane.ERROR_MESSAGE);		
	}
	
	@Override
	public void addData(Object[] o){
		((DefaultTableModel)this.table.getModel()).addRow(o);
	}
	
	@Override
	public void clearData() {
		((DefaultTableModel)this.table.getModel()).setDataVector(INIT_DATA,PROPS);
		
	}
		
	private void buildLayout(){
		JScrollPane scroll = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel pEastInternal = new JPanel(new GridBagLayout()); // Griglia flessibile
		GridBagConstraints cnst = new GridBagConstraints();
		cnst.gridy = 0;								  // 1-a riga
		cnst.insets = new Insets(3,3,3,3);			  // spazio attorno al comp.
		cnst.fill = GridBagConstraints.HORIZONTAL; 	  // estensione in orizzont.
		pEastInternal.add(bLoad,cnst);
		cnst.gridy++;								  // prossima riga
		pEastInternal.add(bAdd,cnst);
		cnst.gridy++;
		pEastInternal.add(bSave,cnst);
		cnst.gridy++;
		pEastInternal.add(bQuit,cnst);
		
		JPanel pEast = new JPanel(new FlowLayout());
		//pEast.setBorder(new TitledBorder("FlowLayout"));
		pEast.add(pEastInternal);
		
		JPanel jp = new JPanel();
		this.add(jp);
		jp.setLayout(new BorderLayout(5,5));
		jp.add(scroll,BorderLayout.CENTER);
		jp.add(pEast,BorderLayout.EAST);
		jp.setBorder(new EmptyBorder(5,5,5,5));
	}
	
	private void setHandlers(){
		this.bLoad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.commandLoad();
			}
		});
		this.bSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.commandSave();
			}
		});
		this.bQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				quitHandler();
			}
		});
		this.bAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				formDialog.reinit();
				formDialog.setVisible(true);
			}
		});
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				quitHandler();
			}
		});
		this.formDialog.addComponentListener(new ComponentAdapter(){
			@Override
			public void componentHidden(ComponentEvent e){
				if (formDialog.getOKState()){
					Object[] o = new Object[]{	formDialog.getName(),
												formDialog.getSurname(), 
												formDialog.getCode(),
												formDialog.getBirthYear(),
												formDialog.getMale()
					};
					controller.commandAdd(o);
				}
			}
		});
	}
	
	private void quitHandler(){
		int n = JOptionPane.showConfirmDialog(this,
			    "Do you really want to quit?",
			    "Quitting..", JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION){
			controller.commandQuit();
		}
	}
}
