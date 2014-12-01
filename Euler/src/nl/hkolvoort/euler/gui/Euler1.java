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

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class Euler1 extends JPanel {
	private JTextField textMultiple1;
	private JTextField textMultiple2;
	private JTextField textLimit;
	private JTextField textStart;
	private JTextField textStop;
	private JTextField textDuration;
	private JTextField textResult;

	/**
	 * Create the panel.
	 */
	public Euler1() {
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
		
		JLabel lblMultiple1 = new JLabel("Multiple of");
		lblMultiple1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblMultiple1, "8, 4, right, default");
		
		textMultiple1 = new JTextField();
		textMultiple1.setText("3");
		panel_1.add(textMultiple1, "10, 4, fill, default");
		textMultiple1.setColumns(10);
		
		JLabel lblMultiple2 = new JLabel("Mutliple of");
		lblMultiple2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblMultiple2, "8, 6, right, default");
		
		textMultiple2 = new JTextField();
		textMultiple2.setText("5");
		panel_1.add(textMultiple2, "10, 6, fill, default");
		textMultiple2.setColumns(10);
		
		JLabel lblLimit = new JLabel("Limit");
		panel_1.add(lblLimit, "8, 8, right, default");
		
		textLimit = new JTextField();
		textLimit.setText("1000");
		panel_1.add(textLimit, "10, 8, fill, default");
		textLimit.setColumns(10);
		
		JButton btnGo = new JButton("Go!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer multiple1 = 0;
				Integer multiple2 = 0;
				Integer limit = 0; 
				
				try {
					multiple1 = Integer.parseInt(textMultiple1.getText());
					textMultiple1.setBackground(Color.WHITE);
				} catch (NumberFormatException e1) {
					textMultiple1.setText("Enter a integer value");
					textMultiple1.setBackground(Color.RED);
					return;
				}
				
				try {
					multiple2 = Integer.parseInt(textMultiple2.getText());
					textMultiple2.setBackground(Color.WHITE);
				} catch (NumberFormatException e1) {
					textMultiple2.setText("Enter a integer value");
					textMultiple2.setBackground(Color.RED);
				}
				
				try {
					limit = Integer.parseInt(textLimit.getText());
					textLimit.setBackground(Color.WHITE);
				} catch (NumberFormatException e1) {
					textLimit.setText("Enter a integer value");
					textLimit.setBackground(Color.RED);
				}
				
				Timestamp start = new Timestamp(new Date().getTime());
				textStart.setText(start.toString());

				P1_SumOfMultiples som = new P1_SumOfMultiples();
				textResult.setText(Integer.toString(som.sum(multiple1, multiple2, limit)));
				
				Timestamp stop = new Timestamp(new Date().getTime());
				textStop.setText(stop.toString());
				
				Long duration = stop.getTime() - start.getTime();
				textDuration.setText(Long.toString(duration));
			}
		});
		panel_1.add(btnGo, "10, 10");
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblResult, "8, 12, right, default");
		
		textResult = new JTextField();
		panel_1.add(textResult, "10, 12, fill, default");
		textResult.setColumns(10);

	}

}
