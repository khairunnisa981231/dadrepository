package server.view;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class serverFrame extends JFrame {

	private static final long serialVersionUID = 1L;


	private JLabel lblServerStatus;
	private JTextArea txtRequestStatus;
	


	public serverFrame() 
	{
		getContentPane().setLayout(new BorderLayout());
		this.setTitle("Translation App Server Side");
		this.setSize(new Dimension(700, 528));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.lblServerStatus = new JLabel("-");
		lblServerStatus.setForeground(Color.WHITE);
		this.txtRequestStatus = new JTextArea(20, 70);
		loadComponent();
	}

	private JPanel getServerStatusPanel(Font font) {

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		JLabel lblServer = new JLabel("Server status: ");
		lblServer.setForeground(Color.WHITE);
		lblServer.setFont(font);
		lblServerStatus.setFont(font);
		lblServer.setBackground(Color.WHITE);
		lblServerStatus.setBackground(Color.WHITE);
		panel.add(lblServer);
		panel.add(lblServerStatus);
		return panel;
	}

	private JPanel getRequestStatusPanel() 
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		txtRequestStatus.setText("\n > Server is running");
		txtRequestStatus.setEditable(false);
		txtRequestStatus.setFont(new Font("Courier", Font.PLAIN, 15));
		panel.add(txtRequestStatus);
		return panel;
	}

	public void loadComponent() 
	{
		Font font = this.getFontStyle();
		JPanel topPanel = this.getServerStatusPanel(font);
		getContentPane().add(topPanel, BorderLayout.NORTH);
		JPanel centrePanel = this.getRequestStatusPanel();
		getContentPane().add(centrePanel, BorderLayout.CENTER);
	}

	public void updateServerStatus(boolean flag) 
	{
		String status = "Waiting for connection.";

		if (flag)
			status = "Received connection.";

		this.lblServerStatus.setText(status);
	}


	public void updateRequestStatus(String status) 
	{
		String currentText = this.txtRequestStatus.getText();
		txtRequestStatus.setEditable(true);
		status += "\n > " + currentText;
		this.txtRequestStatus.setText(status);
		txtRequestStatus.setEditable(false);
	}


	private Font getFontStyle() 
	{
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
		return font;
	}

}

