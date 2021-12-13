package deliverybay.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;



public class DeliveryBayFrame extends JFrame {


	private JPanel orderPanel_1, orderPanel_2, orderPanel_3;
	private JScrollPane scrollPane;
	private JLabel lblOrder, lblTotal;
	private JTable table;

	private String[] cols = { "Sender Address", "Receiver Address", "Telephone No", "Weight" };
	private String[][] data = {};
	private DefaultTableModel model = new DefaultTableModel(data, cols);


		public DeliveryBayFrame() {
			getContentPane().setForeground(Color.WHITE);
			getContentPane().setFont(new Font("Serif", Font.PLAIN, 10));
			setTitle("Parcel Order");
			getContentPane().setLayout(null);
			this.setSize(new Dimension(969, 645));
			setLocationRelativeTo(null);
	
			orderPanel_1 = new JPanel();
			orderPanel_1.setBorder(
					new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(64, 64, 64), new Color(64, 64, 64)),
							"", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(255, 255, 255)));
			orderPanel_1.setForeground(SystemColor.text);
			orderPanel_1.setBackground(Color.DARK_GRAY);
			orderPanel_1.setBounds(10, 10, 935, 26);
			getContentPane().add(orderPanel_1);
			orderPanel_1.setLayout(null);

			lblOrder = new JLabel("Parcel Order");
			lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
			lblOrder.setFont(new Font("Serif", Font.BOLD, 20));
			lblOrder.setForeground(SystemColor.textHighlightText);
			lblOrder.setBackground(Color.DARK_GRAY);
			lblOrder.setBounds(10, 1, 925, 23);
			orderPanel_1.add(lblOrder);

			orderPanel_2 = new JPanel();
			orderPanel_2.setForeground(Color.WHITE);
			orderPanel_2.setBackground(Color.BLACK);
			orderPanel_2.setBounds(10, 35, 935, 525);
			getContentPane().add(orderPanel_2);
			orderPanel_2.setLayout(null);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 10, 915, 505);
			orderPanel_2.add(scrollPane);

			table = new JTable();
			table.setModel(model);
			table.getColumnModel().getColumn(2).setPreferredWidth(5);
			table.getColumnModel().getColumn(3).setPreferredWidth(5);
			table.setFont(new Font("Serif", Font.PLAIN, 15));
			
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
			
			table.setRowHeight(25);
			
			scrollPane.setViewportView(table);

			orderPanel_3 = new JPanel();
			orderPanel_3.setBackground(Color.BLACK);
			orderPanel_3.setForeground(Color.WHITE);
			orderPanel_3.setBounds(10, 558, 935, 40);
			getContentPane().add(orderPanel_3);
			orderPanel_3.setLayout(null);
			
		
			lblTotal = new JLabel("Total: ");
			lblTotal.setFont(new Font("Serif", Font.BOLD, 20));
			lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
			lblTotal.setForeground(Color.WHITE);
			lblTotal.setBackground(Color.BLACK);
			lblTotal.setBounds(10, 5, 915, 25);
			orderPanel_3.add(lblTotal);


		}

		public JTable getTable() {
			return table;
		}


		public void setTable(JTable table) {
			this.table = table;
		}


		public DefaultTableModel getModel() {
			return model;
		}

		public void setModel(DefaultTableModel model) {
			this.model = model;
		}
		
		public JLabel getlblTotal() {
		    return lblTotal;
		}

	}

