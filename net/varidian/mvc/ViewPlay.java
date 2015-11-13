package net.varidian.mvc;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewPlay extends JFrame {

    private JTextField number1 = new JTextField(10);
    private JLabel additionLabel = new JLabel("+");
    private JTextField number2 = new JTextField(10);
    private JButton calculateButton = new JButton("Calculate");
    private JTextField calcSolution = new JTextField(10);

    // View Constructor
    ViewPlay(){
        JPanel calcPanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 100);

        calcPanel.add(number1);
        calcPanel.add(additionLabel);
        calcPanel.add(number2);
        calcPanel.add(calculateButton);
        calcPanel.add(calcSolution);

        this.add(calcPanel);
    }

    public int getNumber1(){
        return Integer.parseInt(number1.getText());
    }

    public int getNumber2(){
        return Integer.parseInt(number2.getText());
    }

    public void setCalcSolution(int solution){
        calcSolution.setText(Integer.toString(solution));
    }

    // listener for button clicked
    void addCalculateListener(ActionListener listenForCalcButton){
        calculateButton.addActionListener(listenForCalcButton);
    }


}
