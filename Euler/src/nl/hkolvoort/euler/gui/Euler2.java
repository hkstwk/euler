package nl.hkolvoort.euler.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import nl.hkolvoort.euler.P1_SumOfMultiples;
import nl.hkolvoort.euler.P2_SumOfEvenFibonacci;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class Euler2 extends JPanel {
	private JTextField textLimit;
	private JTextField textStart;
	private JTextField textStop;
	private JTextField textDuration;
	private JTextField textResult;

	/**
	 * Create the panel.
	 */
	public Euler2() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblStartTime = new JLabel("Start time");
		panel.add(lblStartTime, "8, 2, right, default");
		
		textStart = new JTextField();
		panel.add(textStart, "10, 2, fill, default");
		textStart.setColumns(10);
		
		JLabel lblStopTime = new JLabel("Stop time");
		panel.add(lblStopTime, "8, 4, right, default");
		
		textStop = new JTextField();
		panel.add(textStop, "10, 4, fill, default");
		textStop.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration (ms)");
		panel.add(lblDuration, "8, 6, right, default");
		
		textDuration = new JTextField();
		panel.add(textDuration, "10, 6, fill, default");
		textDuration.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel, "8, 8");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblLimit = new JLabel("Limit");
		panel_1.add(lblLimit, "8, 2, right, default");
		
		textLimit = new JTextField();
		textLimit.setText("1000");
		panel_1.add(textLimit, "10, 2, fill, default");
		textLimit.setColumns(10);
		
		JButton btnGo = new JButton("Go!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer limit = 0; 
				
				try {
					limit = Integer.parseInt(textLimit.getText());
					textLimit.setBackground(Color.WHITE);
				} catch (NumberFormatException e1) {
					textLimit.setText("Enter a integer value");
					textLimit.setBackground(Color.RED);
				}
				
				Timestamp start = new Timestamp(new Date().getTime());
				textStart.setText(start.toString());

				P2_SumOfEvenFibonacci soef = new P2_SumOfEvenFibonacci();
				soef.setLimit(limit);
				soef.fillFibonacciList();
				soef.sumEvenFibonacciNumbers();
				textResult.setText(Integer.toString(soef.getSumEvenFibonacci()));
				
				Timestamp stop = new Timestamp(new Date().getTime());
				textStop.setText(stop.toString());
				
				Long duration = stop.getTime() - start.getTime();
				textDuration.setText(Long.toString(duration));
			}
		});
		panel_1.add(btnGo, "10, 4");
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblResult, "8, 6, right, default");
		
		textResult = new JTextField();
		panel_1.add(textResult, "10, 6, fill, default");
		textResult.setColumns(10);

	}

}
