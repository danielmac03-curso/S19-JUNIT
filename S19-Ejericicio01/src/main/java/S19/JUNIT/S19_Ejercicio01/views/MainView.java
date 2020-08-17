package S19.JUNIT.S19_Ejercicio01.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame{
	
	private JPanel contentPane;
	private String num1 = "0";
	private String num2 = "0";
	private String operator = "";
	private double result = 0.0;
	private boolean editFirstNum = true;
	private boolean error = false;
	
	public MainView() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(230, 230, 230));

		JTextField textFieldNum = new JTextField();
		textFieldNum.setBounds(10, 25, 500, 150);
		textFieldNum.setText("");
		textFieldNum.setEnabled(false);
		textFieldNum.setBackground(new Color(230, 230, 230));
		textFieldNum.setBorder(null);
		textFieldNum.setText("0");
		textFieldNum.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textFieldNum.setHorizontalAlignment(JTextField.RIGHT);
		contentPane.add(textFieldNum);
		
		JPanel panelBtns = new JPanel();
		panelBtns.setBounds(10, 215, 500, 335);
		contentPane.add(panelBtns);
		panelBtns.setLayout(new GridLayout(6, 4, 5, 5));
		
		JLabel labelOperacionCompleta = new JLabel("");
		labelOperacionCompleta.setBounds(10, 11, 500, 14);
		contentPane.add(labelOperacionCompleta);
		
    	JLabel labelHistorial = new JLabel("HISTORIAL");
    	labelHistorial.setBounds(600, 15, 100, 25);
    	labelHistorial.setFont(new Font("Tahoma", Font.PLAIN, 20));
    	contentPane.add(labelHistorial);
    	
    	JPanel panelHistorial = new JPanel();
    	panelHistorial.setBounds(550, 58, 200, 492);
    	contentPane.add(panelHistorial);
    	panelHistorial.setLayout(new GridLayout(10, 1, 5, 5));
		
		JButton btns[] = new JButton[24];
	
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton();
			btns[i].setBorder(null);
			panelBtns.add(btns[i]);
		}
		
		btns[0].setText("%");
		btns[1].setText("CE");
		btns[2].setText("C");
		btns[3].setText("←");
		btns[4].setText("1/x");
		btns[5].setText("x2");
		btns[6].setText("2√x");
		btns[7].setText("/");
		btns[8].setText("7");
		btns[9].setText("8");
		btns[10].setText("9");
		btns[11].setText("*");
		btns[12].setText("4");
		btns[13].setText("5");
		btns[14].setText("6");
		btns[15].setText("-");
		btns[16].setText("1");
		btns[17].setText("2");
		btns[18].setText("3");
		btns[19].setText("+");
		btns[20].setText("+/-");
		btns[21].setText("0");
		btns[22].setText(",");
		btns[23].setText("=");
		
		for (int i = 0; i < btns.length; i++) {
			if (btns[i].getText().equals("%") || btns[i].getText().equals("CE") || btns[i].getText().equals("C") || btns[i].getText().equals("←") || btns[i].getText().equals("1/x") || btns[i].getText().equals("x2") || btns[i].getText().equals("2√x") || btns[i].getText().equals("%") || btns[i].getText().equals("/") || btns[i].getText().equals("*") || btns[i].getText().equals("-") || btns[i].getText().equals("+")) {
				btns[i].setBackground( new Color(240, 240, 240));
			}else if(btns[i].getText().equals("=")) {
				btns[i].setBackground( new Color(154, 186, 219));
			}else {
				btns[i].setBackground( new Color(250, 250, 250));
			}
		}

		ActionListener alBtns = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton tmpBtn = (JButton) e.getSource();
				String btnText = tmpBtn.getText();
				
				if (btnText.equals("CE") || btnText.equals("C") || btnText.equals("←") || btnText.equals("+/-")) {
					switch (btnText) {
						case "CE":
							num1 = "0";
							num2 = "0";
							operator = "";
							break;
						case "C":
							if (editFirstNum) {
								num1 = "0";
							}else {
								num2 = "0";
							}
							break;
						case "←":
							if (editFirstNum) {
								char num[] = new char[num1.length()];
	
								for (int i = 0; i < num1.length(); i++) {
									num[i] = num1.charAt(i);
								}
															
								num1 = new String(num);
	
								if (num1.equals("")) {
									num1 = "0";
								}
							}else {
								char num[] = new char[num2.length()];
	
								for (int i = 0; i < num2.length(); i++) {
									num[i] = num2.charAt(i);
								}
															
								num2 = new String(num);
	
								if (num2.equals("")) {
									num2 = "0";
								}
							}
							break;
					}
				}else if(btnText.equals("1/x") || btnText.equals("x2") || btnText.equals("2√x")){
					switch (btnText) {
						case "1/x":
							result = 1/Double.parseDouble(num1);
							operator = " entre ";
							num2 = "1";
							break;
						case "x2":
							result = Math.pow(Double.parseDouble(num1), 2);
							operator = " elevado a ";
							num2 = "2";
							break;
						case "2√x":
							result = Math.sqrt(Double.parseDouble(num1));
							operator = " raíz de ";
							num2 = "2";
							break;
					}				
					
					num1 = Double.toString(result);
					
					if (num1.length() > 4) {
						char num[] = new char[4];
						
						for (int i = 0; i < 4; i++) {
							num[i] = num1.charAt(i);
						}
													
						num1 = new String(num);
					}
					
					editFirstNum = true;
					
					panelHistorial.add(new JLabel(num1 + operator + num2 + " = " + num1));
					labelOperacionCompleta.setText(num1 + operator + num2 + " = " + num1);
				}else if(btnText.equals("/") || btnText.equals("*") || btnText.equals("-") || btnText.equals("+") || btnText.equals("%")){
					operator = btnText;
					editFirstNum = false;
				}else if(btnText.equals("=")) {
					switch (operator) {
						case "/":
							result = Double.parseDouble(num1) / Double.parseDouble(num2);
							break;
						case "*":
							result = Double.parseDouble(num1) * Double.parseDouble(num2);			
							break;
						case "-":
							result = Double.parseDouble(num1) - Double.parseDouble(num2);
							break;
						case "+":
							result = Double.parseDouble(num1) + Double.parseDouble(num2);	
							break;
						case "%":
							result = Double.parseDouble(num1) % Double.parseDouble(num2);						
							break;
					}
					
					if (result == Double.POSITIVE_INFINITY) {
						error = true;
						num1 = "No se puede dividir entre cero";
						textFieldNum.setFont(new Font("Tahoma", Font.PLAIN, 35));
					}else {
						num1 = Double.toString(result);
					}
					
					if (num1.length() > 4 && error) {
						char num[] = new char[4];
						
						for (int i = 0; i < 4; i++) {
							num[i] = num1.charAt(i);
						}
													
						num1 = new String(num);
					}
					
					num2 = "0";
					editFirstNum = true;
					labelOperacionCompleta.setText(num1 + operator + num2 + " = " + num1);
				}else {
					textFieldNum.setFont(new Font("Tahoma", Font.PLAIN, 50));
					
					if (editFirstNum) {						
						if (num1.equals("0") || num1.equals("No se puede dividir entre cero")) {
							num1 = btnText;
						}else {
							num1 += btnText;
						}
					}else {					
						if (num2.equals("0")) {
							num2 = btnText;
						}else {
							num2 += btnText;
						}
					}
				}
				
				if (editFirstNum) {
					textFieldNum.setText(num1);
				}else {
					textFieldNum.setText(num2);
				}
				
				if (num1.length() > 4) {
					char num[] = new char[4];
					
					for (int i = 0; i < 4; i++) {
						num[i] = num1.charAt(i);
					}
												
					num1 = new String(num);
				}				
			}
		};
		
		for (int i = 0; i < btns.length; i++) {
			if (btns[i].getText().equals("%") || btns[i].getText().equals("CE") || btns[i].getText().equals("C") || btns[i].getText().equals("←") || btns[i].getText().equals("1/x") || btns[i].getText().equals("x2") || btns[i].getText().equals("2√x") || btns[i].getText().equals("%") || btns[i].getText().equals("/") || btns[i].getText().equals("*") || btns[i].getText().equals("-") || btns[i].getText().equals("+")) {
				btns[i].setBackground( new Color(240, 240, 240));
			}else if(btns[i].getText().equals("=")) {
				btns[i].setBackground( new Color(154, 186, 219));
			}else {
				btns[i].setBackground( new Color(250, 250, 250));
			}
			
			btns[i].addActionListener(alBtns);
		}

	}
}
