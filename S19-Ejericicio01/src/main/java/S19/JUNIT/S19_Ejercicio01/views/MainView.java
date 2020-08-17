package S19.JUNIT.S19_Ejercicio01.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView extends JFrame{
		
	private JPanel contentPane;
	private String num1 = "";
	private String num2 = "";
	private String operator = "";
	private double result; 
	private boolean writingFirstNumber = true;

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
		btns[11].setText("x");
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
		btns[22].setText(".");
		btns[23].setText("=");
		
		for (int i = 0; i < btns.length; i++) {		
			if (btns[i].getText().equals("%") || btns[i].getText().equals("CE") || btns[i].getText().equals("C") || btns[i].getText().equals("←") || btns[i].getText().equals("1/x") || btns[i].getText().equals("x2") || btns[i].getText().equals("2√x") || btns[i].getText().equals("%") || btns[i].getText().equals("/") || btns[i].getText().equals("x") || btns[i].getText().equals("-") || btns[i].getText().equals("+")) {
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
				
				switch (btnText) {
				case "%":
					
					break;
					
				case "CE":
					num1 = "";
					num2 = "";
					operator = "";	
					textFieldNum.setText("0");
					break;
					
				case "C":
					textFieldNum.setText("0");

					if (writingFirstNumber) {
						num1 = textFieldNum.getText();
					}else {
						num2 = textFieldNum.getText();
					}
					break;
					
				case "←":
					if (writingFirstNumber) {
						char num[] = new char[num1.length()];

						for (int i = 0; i < (num1.length()-1); i++) {
							num[i] = num1.charAt(i);
						}
													
						num1 = new String(num);

						if (num1.equals("")) {
							num1 = "0";
						}
					}else {
						char num[] = new char[num2.length()];
		
						for (int i = 0; i < (num2.length()-1); i++) {
							num[i] = num2.charAt(i);
						}
														
						num2 = new String(num);
		
						if (num2.equals("")) {
							num2 = "0";
						}

					}
					break;
					
				case "1/x":
					num2 = num1;
					num1 = "1";
					operator = "/";			
					btns[23].doClick();
					break;
					
				case "x2":
					num2 = num1;
					operator = "x";			
					btns[23].doClick();
					break;
					
				case "2√x":
					operator = "2√x";		
					btns[23].doClick();
					break;
					
				case "/":
				case "x":;
				case "-":
				case "+":
					operator = btnText;
					writingFirstNumber = false;
					textFieldNum.setText("0");
					break;
					
				case "=":
					switch (operator) {
						case "/":
							result = Double.parseDouble(num1) / Double.parseDouble(num2);
							break;
						case "x":
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
						case "2√x":
							result = Math.sqrt(Double.parseDouble(num1));
							break;
						default:
							result = Double.parseDouble(num1);
							break;
					}

					if (Double.toString(result).length() > 4 && result != Double.POSITIVE_INFINITY) {
						result = Math.round(result* 100.0) / 100.0;
					}
					
					if(result == Double.POSITIVE_INFINITY){
						textFieldNum.setFont(new Font("Tahoma", Font.PLAIN, 35));
						num1 = "No se puede dividir entre cero";
					}else {
						num1 = Double.toString(result);
					}
					
					num2 = "";
					result = 0;
					writingFirstNumber = true;
					operator = "";
					
					textFieldNum.setText(num1);
					break;
				default:
					textFieldNum.setFont(new Font("Tahoma", Font.PLAIN, 50));

					if (textFieldNum.getText().equals("0") || num1.equals("No se puede dividir entre cero")){
						textFieldNum.setText(btnText);
					}else {
						textFieldNum.setText(textFieldNum.getText() + btnText);
					}
										
					if (writingFirstNumber) {
						num1 = textFieldNum.getText();
					}else {
						num2 = textFieldNum.getText();
					}
					break;
				}

				if(!num1.equals("No se puede dividir entre cero")) {
					labelOperacionCompleta.setText(num1 + operator + num2);
				}else {
					labelOperacionCompleta.setText("No se puede dividir entre cero");
				}
				
//				panelHistorial.add(new JLabel(num1 + operator + num2 + " = " + num1));
			}
		};
		
		for (int i = 0; i < btns.length; i++) {
			if (btns[i].getText().equals("%") || btns[i].getText().equals("CE") || btns[i].getText().equals("C") || btns[i].getText().equals("←") || btns[i].getText().equals("1/x") || btns[i].getText().equals("x2") || btns[i].getText().equals("2√x") || btns[i].getText().equals("%") || btns[i].getText().equals("/") || btns[i].getText().equals("x") || btns[i].getText().equals("-") || btns[i].getText().equals("+")) {
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
