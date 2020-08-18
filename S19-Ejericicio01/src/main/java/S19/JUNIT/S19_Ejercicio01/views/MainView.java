package S19.JUNIT.S19_Ejercicio01.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView extends JFrame{
		
	private JPanel contentPane;
	public String num1 = "";
	public String num2 = "";
	public String operacion = "";
	private double resultado; 
	private boolean escribiendoPrimerOperador = true;
	public JButton btns[] = new JButton[24];
	private boolean negativo = false;

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
    	labelHistorial.setBounds(625, 11, 100, 25);
    	labelHistorial.setFont(new Font("Tahoma", Font.PLAIN, 20));
    	contentPane.add(labelHistorial);
    	
    	JPanel panelHistorial = new JPanel();
    	panelHistorial.setBounds(574, 47, 200, 500);
    	panelHistorial.setBackground(new Color(230, 230, 230));
    	contentPane.add(panelHistorial);
    	panelHistorial.setLayout(new GridLayout(15, 1, 2, 0));
    	
    	JButton eliminarHistorial = new JButton("X");
    	eliminarHistorial.setBounds(520, 527, 42, 23);
    	contentPane.add(eliminarHistorial);
	
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
					case "CE":
						num1 = "";
						num2 = "";
						operacion = "";	
						textFieldNum.setText("0");
						btns[22].setEnabled(true);
						break;
						
					case "C":
						textFieldNum.setText("0");
	
						if (escribiendoPrimerOperador) {
							num1 = textFieldNum.getText();
						}else {
							num2 = textFieldNum.getText();
						}
						btns[22].setEnabled(true);
						break;
						
					case "←":
						int lastIndex = textFieldNum.getText().length()-1;
						
						if (Character.toString(textFieldNum.getText().charAt(lastIndex)).equals(".")) {
							btns[22].setEnabled(true);
						}
						
						char num[] = new char[(textFieldNum.getText().length()-1)];
						
						for (int i = 0; i < (textFieldNum.getText().length()-1); i++) {
							num[i] = textFieldNum.getText().charAt(i);
						}
													
						textFieldNum.setText(new String(num));

						if (textFieldNum.getText().equals("")) {
							textFieldNum.setText("0");
						}
						break;
						
					case "1/x":
						num2 = num1;
						num1 = "1";
						operacion = "/";			
						btns[23].doClick();
						break;
						
					case "x2":
						num2 = num1;
						operacion = "x";			
						btns[23].doClick();
						break;
						
					case "2√x":
						operacion = "2√x";		
						btns[23].doClick();
						break;
						
					case "/":
					case "x":;
					case "-":
					case "+":
					case "%":
						if (!num1.equals("")) {
							operacion = btnText;
							escribiendoPrimerOperador = false;
							textFieldNum.setText("0");
							btns[22].setEnabled(true);
						}
						break;
						
					case "=":
						if (num1.equals("")) {
							num1 = "0";
						}
						
						switch (operacion) {
							case "/":
								resultado = Double.parseDouble(num1) / Double.parseDouble(num2);
								break;
							case "x":
								resultado = Double.parseDouble(num1) * Double.parseDouble(num2);			
								break;
							case "-":
								resultado = Double.parseDouble(num1) - Double.parseDouble(num2);
								break;
							case "+":
								resultado = Double.parseDouble(num1) + Double.parseDouble(num2);	
								break;
							case "%":
								resultado = Double.parseDouble(num1) % Double.parseDouble(num2);						
								break;
							case "2√x":
								resultado = Math.sqrt(Double.parseDouble(num1));
								break;
							default:
								resultado = Double.parseDouble(num1);
								break;
						}
	
						if (Double.toString(resultado).length() > 4 && resultado != Double.POSITIVE_INFINITY) {
							resultado = Math.round(resultado* 100.0) / 100.0;
						}
						
						if(resultado == Double.POSITIVE_INFINITY){
							textFieldNum.setFont(new Font("Tahoma", Font.PLAIN, 35));
							textFieldNum.setText("No se puede dividir entre cero");
						}else {
							JLabel tmpLabel = new JLabel(num1 + operacion + num2 + " = " + resultado, JLabel.CENTER);
							tmpLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panelHistorial.add(tmpLabel);
							
							textFieldNum.setText(Double.toString(resultado));
						}
						
						num2 = "";
						resultado = 0;
						escribiendoPrimerOperador = true;
						operacion = "";
						
						if (textFieldNum.getText().contains(".")) {
							btns[22].setEnabled(false);
						}						
						break;
					case "+/-":
						if (!negativo) {
							negativo = true;
							textFieldNum.setText("-" + textFieldNum.getText());
						}else{
							negativo = false;
							char num2[] = new char[(textFieldNum.getText().length()-1)];
							
							for (int i = 0; i < (textFieldNum.getText().length()-1); i++) {
								num2[i] = textFieldNum.getText().charAt(i+1);
							}
														
							textFieldNum.setText(new String(num2));
						}
						break;
					default:
						textFieldNum.setFont(new Font("Tahoma", Font.PLAIN, 50));
	
						if (textFieldNum.getText().equals("0") || textFieldNum.getText().equals("No se puede dividir entre cero")){
							textFieldNum.setText(btnText);
						}else {
							textFieldNum.setText(textFieldNum.getText() + btnText);
						}

						if (btnText.equals(".")) {
							tmpBtn.setEnabled(false);
						}
						
						break;
				}

				if (escribiendoPrimerOperador) {
					num1 = textFieldNum.getText();
				}else {
					num2 = textFieldNum.getText();
				}
				
				if(!num1.equals("No se puede dividir entre cero")) {
					labelOperacionCompleta.setText(num1 + operacion + num2);
				}else {
					labelOperacionCompleta.setText("No se puede dividir entre cero");
				}
				
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
		
		ActionListener alEliminarHistorial = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelHistorial.removeAll();
				panelHistorial.repaint();
			}
		};
		
		eliminarHistorial.addActionListener(alEliminarHistorial);

	}
}
