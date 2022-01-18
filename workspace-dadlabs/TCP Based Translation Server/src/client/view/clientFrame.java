package client.view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectOutputStream;

import client.application.clientApplication;

public class clientFrame extends JFrame{
	
	private JPanel contentPane;
	private JTextField textField;
	
	public clientFrame() {
		setTitle("Client Translation ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Translation Application");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 522, 35);
		contentPane.add(lblTitle);
		
		JPanel clientInputPanel = new JPanel();
		clientInputPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		clientInputPanel.setBounds(10, 55, 522, 310);
		contentPane.add(clientInputPanel);
		clientInputPanel.setLayout(null);
		
		JLabel lblText = new JLabel("Choose the text you wished to translate: ");
		lblText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblText.setBounds(32, 10, 733, 36);
		clientInputPanel.add(lblText);
		
		//declare radiobuttons
		JRadioButton rb1 = new JRadioButton("Good Morning");
		rb1.setHorizontalAlignment(SwingConstants.LEFT);
		rb1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb1.setBounds(157, 67, 359, 36);
		clientInputPanel.add(rb1);
		
		JRadioButton rb2 = new JRadioButton("Good Night");
		rb2.setHorizontalAlignment(SwingConstants.LEFT);
		rb2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb2.setBounds(157, 105, 359, 36);
		clientInputPanel.add(rb2);
		
		JRadioButton rb3 = new JRadioButton("How are You?");
		rb3.setHorizontalAlignment(SwingConstants.LEFT);
		rb3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb3.setBounds(157, 143, 359, 36);
		clientInputPanel.add(rb3);
		
		JRadioButton rb4 = new JRadioButton("Thank You");
		rb4.setHorizontalAlignment(SwingConstants.LEFT);
		rb4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb4.setBounds(157, 181, 359, 36);
		clientInputPanel.add(rb4);
		
		JRadioButton rb5 = new JRadioButton("Goodbye");
		rb5.setHorizontalAlignment(SwingConstants.LEFT);
		rb5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb5.setBounds(157, 219, 359, 36);
		clientInputPanel.add(rb5);
		
		JRadioButton rb6 = new JRadioButton("What's Up?");
		rb6.setHorizontalAlignment(SwingConstants.LEFT);
		rb6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb6.setBounds(157, 257, 359, 36);
		clientInputPanel.add(rb6);
		
		ButtonGroup rbTextGroup = new ButtonGroup();
		rbTextGroup.add(rb1);
		rbTextGroup.add(rb2);
		rbTextGroup.add(rb3);
		rbTextGroup.add(rb4);
		rbTextGroup.add(rb5);
		rbTextGroup.add(rb6);
		
		JPanel clientInputPanel_1 = new JPanel();
		clientInputPanel_1.setLayout(null);
		clientInputPanel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		clientInputPanel_1.setBounds(10, 375, 522, 206);
		contentPane.add(clientInputPanel_1);
		
		JLabel lblTranslateInto = new JLabel("Translate into:");
		lblTranslateInto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTranslateInto.setBounds(36, 10, 729, 36);
		clientInputPanel_1.add(lblTranslateInto);
		
		JRadioButton rdbtnBahasaMelayu = new JRadioButton("Bahasa Melayu");
		rdbtnBahasaMelayu.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnBahasaMelayu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnBahasaMelayu.setBounds(157, 67, 359, 36);
		clientInputPanel_1.add(rdbtnBahasaMelayu);
		
		JRadioButton rdbtnArabic = new JRadioButton("Arabic");
		rdbtnArabic.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnArabic.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnArabic.setBounds(157, 105, 359, 36);
		clientInputPanel_1.add(rdbtnArabic);
		
		JRadioButton rdbtnKorean = new JRadioButton("Korean");
		rdbtnKorean.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnKorean.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnKorean.setBounds(157, 143, 359, 36);
		clientInputPanel_1.add(rdbtnKorean);
		
		ButtonGroup rbLanguageGroup = new ButtonGroup();
		rbLanguageGroup.add(rdbtnBahasaMelayu);
		rbLanguageGroup.add(rdbtnArabic);
		rbLanguageGroup.add(rdbtnKorean);
		
		JButton btnTranslate = new JButton("Translate");
		btnTranslate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String text = rbTextGroup.getSelection().toString();
				String language = rbLanguageGroup.getSelection().toString();
				
				
				
			}
		});
		btnTranslate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnTranslate.setBounds(421, 591, 111, 35);
		contentPane.add(btnTranslate);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textField.setBackground(Color.YELLOW);
		textField.setEditable(false);
		textField.setBounds(10, 636, 522, 55);
		contentPane.add(textField);
		textField.setColumns(10);
		
	}

}
