package mvcView;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mvcModel.Bill;
import mvcModel.OrderList;
import mvcModel.Restaurant_Model;
import mvcView.Bill_View.ChoiceComboListener;

public class Restaurant_View extends JFrame implements Observer{

	private JPanel mainPanel, northPanel, southPanel, centerPanel;
	private static JTextArea timeWindow;
	private static JTextArea ordersWindow;
	private static JTextArea hatchWindow;
	private static JTextArea tableWindow1;
	private static JTextArea tableWindow2;
	private static JTextArea tableWindow3;
	private static JTextArea tableWindow4;
	private static JTextArea tableWindow5;
	private static JTextArea tableWindow6;
	private static JTextArea tableWindow7;
	private static JTextArea tableWindow8;
	private static JTextArea tableWindow9;
	private static JTextArea tableWindow10;
	private String[] Tables = { "Orders Read From txt File", "Random Generated Orders" };
	private JComboBox<String> dropdownBox;
	private JButton start, slow, normal, fast, bill;
	private double speedtimer = 1;
	private static boolean GeneratedOrders = false;

	private Restaurant_Model model;
	
	
	private JScrollPane ordersPanel;
	
	public Restaurant_View(Restaurant_Model model) {

		mainPanel = new JPanel();
		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel = new JPanel();
		
		this.model=model;
		model.addObserver(this);
		

		dropdownBox = new JComboBox<String>();
		// populating JComboBox
		for (int i = 0; i < 2; i++) {
			dropdownBox.addItem(Tables[i]);
		}

		timeWindow = new JTextArea(30, 20);
		timeWindow.setEditable(false);

		ordersWindow = new JTextArea(5, 5);
		ordersWindow.setEditable(false);
		ordersPanel = new JScrollPane(ordersWindow);

		hatchWindow = new JTextArea(5, 5);
		hatchWindow.setEditable(false);
		JScrollPane ordersPane2 = new JScrollPane(hatchWindow);

		tableWindow1 = new JTextArea(5, 5);
		tableWindow1.setEditable(false);
		JScrollPane tablePanel1 = new JScrollPane(tableWindow1);
		tableWindow2 = new JTextArea(5, 5);
		tableWindow2.setEditable(false);
		JScrollPane tablePanel2 = new JScrollPane(tableWindow2);
		tableWindow3 = new JTextArea(5, 5);
		tableWindow3.setEditable(false);
		JScrollPane tablePanel3 = new JScrollPane(tableWindow3);
		tableWindow4 = new JTextArea(5, 5);
		tableWindow4.setEditable(false);
		JScrollPane tablePanel4 = new JScrollPane(tableWindow4);
		tableWindow5 = new JTextArea(5, 5);
		tableWindow5.setEditable(false);
		JScrollPane tablePanel5 = new JScrollPane(tableWindow5);
		tableWindow6 = new JTextArea(5, 5);
		tableWindow6.setEditable(false);
		JScrollPane tablePanel6 = new JScrollPane(tableWindow6);
		tableWindow7 = new JTextArea(5, 5);
		tableWindow7.setEditable(false);
		JScrollPane tablePanel7 = new JScrollPane(tableWindow7);
		tableWindow8 = new JTextArea(5, 5);
		tableWindow8.setEditable(false);
		JScrollPane tablePanel8 = new JScrollPane(tableWindow8);
		tableWindow9 = new JTextArea(5, 5);
		tableWindow9.setEditable(false);
		JScrollPane tablePanel9 = new JScrollPane(tableWindow9);
		tableWindow10 = new JTextArea(5, 5);
		tableWindow10.setEditable(false);
		JScrollPane tablePanel10 = new JScrollPane(tableWindow10);

		start = new JButton("Start");
		slow = new JButton("<< Slower");
		normal = new JButton("Normal Speed");
		fast = new JButton("Faster >>");
		bill = new JButton("bill");
		slow.setEnabled(false);
		normal.setEnabled(false);
		fast.setEnabled(false);
		bill.setEnabled(false);

		mainPanel = new JPanel(new GridLayout(3, 1));
		mainPanel.setVisible(true);
		northPanel = new JPanel(new GridLayout(4, 5));
		northPanel.setVisible(true);
		centerPanel = new JPanel(new GridLayout(1, 2));
		centerPanel.setVisible(true);
		southPanel = new JPanel(new GridLayout(2, 5));
		southPanel.setVisible(true);

		// main panel
		mainPanel.add(northPanel);
		mainPanel.add(centerPanel);
		mainPanel.add(southPanel);

		// north panel
		northPanel.add(start);
		northPanel.add(slow);
		northPanel.add(normal);
		northPanel.add(fast);
		northPanel.add(bill);
		northPanel.add(new JLabel(""));
		northPanel.add(new JLabel(""));

		northPanel.add(new JLabel(""));
		northPanel.add(new JLabel(""));
		northPanel.add(new JLabel(""));
		northPanel.add(new JLabel(""));
		northPanel.add(new JLabel(""));
		timeWindow.setBorder(BorderFactory.createTitledBorder("Speed"));
		northPanel.add(timeWindow);
		northPanel.add(new JLabel(""));
		dropdownBox.setBorder(BorderFactory.createTitledBorder("Choose Random or TXT Orders"));
		northPanel.add(dropdownBox);
		northPanel.add(new JLabel(""));
		northPanel.add(new JLabel(""));
		northPanel.add(new JLabel(""));
		northPanel.add(new JLabel(""));
		northPanel.add(new JLabel(""));

		// center Panel
		centerPanel.add(ordersPanel);
		ordersPanel.setBorder(BorderFactory.createTitledBorder("List of Orders"));

		centerPanel.add(ordersPane2);
		ordersPane2.setBorder(BorderFactory.createTitledBorder("Hatch"));

		// south panel

		southPanel.add(tablePanel1);
		tablePanel1.setBorder(BorderFactory.createTitledBorder("Table 1"));
		southPanel.add(tablePanel2);
		tablePanel2.setBorder(BorderFactory.createTitledBorder("Table 2"));
		southPanel.add(tablePanel3);
		tablePanel3.setBorder(BorderFactory.createTitledBorder("Table 3"));
		southPanel.add(tablePanel4);
		tablePanel4.setBorder(BorderFactory.createTitledBorder("Table 4"));
		southPanel.add(tablePanel5);
		tablePanel5.setBorder(BorderFactory.createTitledBorder("Table 5"));
		southPanel.add(tablePanel6);
		tablePanel6.setBorder(BorderFactory.createTitledBorder("Table 6"));
		southPanel.add(tablePanel7);
		tablePanel7.setBorder(BorderFactory.createTitledBorder("Table 7"));
		southPanel.add(tablePanel8);
		tablePanel8.setBorder(BorderFactory.createTitledBorder("Table 8"));
		southPanel.add(tablePanel9);
		tablePanel9.setBorder(BorderFactory.createTitledBorder("Table 9"));
		southPanel.add(tablePanel10);
		tablePanel10.setBorder(BorderFactory.createTitledBorder("Table 10"));

		// step 3
		ChoiceComboListener listener = new ChoiceComboListener();
		dropdownBox.addActionListener(listener);

		// Set Frame
		this.setContentPane(mainPanel);
		this.setVisible(true);
		this.setSize(1400, 900);
		this.setTitle("Kitchen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// Create Listener for DropDownMenu
	public class ChoiceComboListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			JComboBox<?> cb = (JComboBox<?>) ev.getSource();
			String currentComboSelection = (String) cb.getSelectedItem();

			if (currentComboSelection.equals(Tables[0])) {
				GeneratedOrders = false;
			} else if (currentComboSelection.equals(Tables[1])) {
				GeneratedOrders = true;
			}
		}
	}

	public boolean getRandomOrderBoolean() {
		return GeneratedOrders;
	}

	// Create Start Button Listener
	public void addStartButtonListener(ActionListener ac) {
		start.addActionListener(ac);
	}

	// Create Slower Button Listener
	public void addSlowerButtonListener(ActionListener ac) {
		slow.addActionListener(ac);

	}

	// Create Normal Speed Button Listener
	public void addNormalButtonListener(ActionListener ac) {
		normal.addActionListener(ac);

	}

	// Create Faster Button Listener
	public void addFasterButtonListener(ActionListener ac) {
		fast.addActionListener(ac);

	}

	// Create Bill Button Listener
	public void addBillButtonListener(ActionListener ac) {
		bill.addActionListener(ac);
	}

	public void ViewOnWindows() {

		// this.ordersWindow.setText();

	}

	// Method to Print the OrdersWindow
	public static void startDisplayingtheOrders(String s) {
		//ordersWindow.setText(s);
	}

	// Method to Print the HatchWindow
	public static void startDisplayingtheHatch(String s) {
		//hatchWindow.setText(s);
	}

	// Method to Print the TablesWindow
	public static void startDisplayingtheTables(int i, String s) {
		if (i == 1)
			tableWindow1.setText(s);
		else if (i == 2)
			tableWindow2.setText(s);
		else if (i == 3)
			tableWindow3.setText(s);
		else if (i == 4)
			tableWindow4.setText(s);
		else if (i == 5)
			tableWindow5.setText(s);
		else if (i == 6)
			tableWindow6.setText(s);
		else if (i == 7)
			tableWindow7.setText(s);
		else if (i == 8)
			tableWindow8.setText(s);
		else if (i == 9)
			tableWindow9.setText(s);
		else if (i == 10)
			tableWindow10.setText(s);
	}

	// Method to enable the BillButton
	public void releaseBillButton() {
		bill.setEnabled(true);
	}

	// Method to disable the StartButton
	public void disableStartButton() {
		start.setEnabled(false);
	}

	// Method to disable the SlowButton
	public void disableSlowButton() {
		slow.setEnabled(false);
	}

	// Method to disable the FastButton
	public void disableFastButton() {
		fast.setEnabled(false);
	}

	// Method to enable the SlowButton
	public void enableSlowButton() {
		slow.setEnabled(true);
	}

	// Method to enable the FastButton
	public void enableFastButton() {
		fast.setEnabled(true);
	}

	// Method to enable the SpeedButtons
	public void releaseSpeedButtons() {
		slow.setEnabled(true);
		normal.setEnabled(true);
		fast.setEnabled(true);
	}

	// Method to Control SpeedTimer
	public void setSpeedTimer(int i) {
		if (i == 1) {
			speedtimer = speedtimer * 2;
			timeWindow.setText(Double.toString(speedtimer) + "   >>");
		} else if (i == 2) {
			speedtimer = 1;
			timeWindow.setText("Normal Speed");
		} else if (i == 3) {
			speedtimer = speedtimer / 2;
			timeWindow.setText("<<   " + Double.toString(speedtimer));
		}
	}

	public static boolean getRandomOrders() {
		return GeneratedOrders;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (model.getFinished()){
			bill.setEnabled(true);
		}		
		else{	
		Restaurant_View.ordersWindow.setText(model.getKitchenListView());
		Restaurant_View.hatchWindow.setText(model.getHatchListView());
		
		}
		
	}

}
