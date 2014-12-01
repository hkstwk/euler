package nl.hkolvoort.euler.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;


import java.awt.FlowLayout;

public class EulerMain extends JFrame {

	private JPanel mainPanel;
	private JPanel contentPane;
	private JPanel statusBarPanel;
	private JLabel lblStatusMessage;
	private CardLayout cl;
	private ArrayList<JPanel> cardList;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EulerMain frame = new EulerMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EulerMain() {
		setTitle("projecteuler.net");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		cl = new CardLayout();
		cardList = new ArrayList<JPanel>();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEuler10 = new JMenu("Euler Problem 1-10");
		menuBar.add(mnEuler10);
		
		JMenuItem mntmEuler1 = new JMenuItem("1 - Multiples of 3 and 5");
		mntmEuler1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event){
				if (cardList.isEmpty()){
					Euler1 euler1Panel = new Euler1();
					euler1Panel.setBackground(Color.BLUE);
					euler1Panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
					setTitle("projecteuler.net - problem 1, Multiples of 3 and 5");
					cardList.add(euler1Panel);
					contentPane.add(euler1Panel,"1");
					cl.show(contentPane, "1");	
					lblStatusMessage.setText("Ready - no panels yet; created panel for problem 1");
				}
				else {
					boolean cardExists = false;
					for (int i=0; i < cardList.size(); i++) {
						if (cardList.get(i).getClass() == Euler1.class) {
							cardExists = true;
						}
					}
					if (cardExists) {
						cl.show(contentPane, "1");
						setTitle("projecteuler.net - problem 1, Multiples of 3 and 5");
						lblStatusMessage.setText("Ready - switched to already opened panel for problem 1");
					}
					else {
						Euler1 euler1Panel = new Euler1();
						euler1Panel.setBackground(Color.BLUE);
						euler1Panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
						setTitle("projecteuler.net - problem 1, Multiples of 3 and 5");
						cardList.add(euler1Panel);
						contentPane.add(euler1Panel,"1");
						cl.show(contentPane, "1");	
						lblStatusMessage.setText("Ready - there were already open panel, but not for problem 1, so created that one");
					}
				}
			}
		});
		mnEuler10.add(mntmEuler1);
		
		JMenuItem mntmEuler2 = new JMenuItem("2 - Even Fibonacci numbers");
		mntmEuler2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event){
				if (cardList.isEmpty()){
					JPanel cardTwo = new JPanel();
					cardTwo.setBackground(Color.GREEN);
					setTitle("projecteuler.net - problem 2, sum of even fibonacci numbers");
					cardList.add(cardTwo);
					contentPane.add(cardTwo,"2");
					cl.show(contentPane, "2");	
					lblStatusMessage.setText("Ready - no panels yet; created panel for problem 2");
				}
				else {
					boolean cardExists = false;
					for (int i=0; i < cardList.size(); i++) {
						if (cardList.get(i).getClass() == JPanel.class) {
							cardExists = true;
						}
					}
					if (cardExists) {
						cl.show(contentPane, "2");
						setTitle("projecteuler.net - problem 2, sum of even fibonacci numbers");
						lblStatusMessage.setText("Ready - switched to already opened panel for problem 2");
					}
					else {
						JPanel cardTwo = new JPanel();
						cardTwo.setBackground(Color.GREEN);
						setTitle("projecteuler.net - problem 2, sum of even fibonacci numbers");
						cardList.add(cardTwo);
						contentPane.add(cardTwo,"2");
						cl.show(contentPane, "2");	
						lblStatusMessage.setText("Ready - there were already open panel, but not for problem 2, so created that one");
					}
				}
			}
		});		
		mnEuler10.add(mntmEuler2);
		
		JMenuItem mntmEuler3 = new JMenuItem("3 - Largest prime factor");
		mnEuler10.add(mntmEuler3);
		
		JMenuItem mntmEuler10 = new JMenuItem("10 - Summation of primes");
		mnEuler10.add(mntmEuler10);
		
		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnExit.add(mntmExit);
		
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event){
				lblStatusMessage.setText("Ready - exit selected");
				System.exit(0);
			}
		});
		
		
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		contentPane = new JPanel();
		mainPanel.add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(cl);
		
		statusBarPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) statusBarPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		statusBarPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		statusBarPanel.setPreferredSize(new Dimension(this.getWidth(), 25));
		statusBarPanel.setBackground(Color.LIGHT_GRAY);
		lblStatusMessage = new JLabel("Ready");
		lblStatusMessage.setHorizontalAlignment(SwingConstants.LEFT);
		statusBarPanel.add(lblStatusMessage);
		mainPanel.add(statusBarPanel, BorderLayout.SOUTH); 
	}
	
}
