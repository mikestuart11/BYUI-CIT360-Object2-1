package net.varidian.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPlay {
    private ViewPlay view;
    private  ModelPlay model;

    // control constructor
    ControlPlay(ViewPlay view, ModelPlay model){
        this.view = view;
        this.model = model;


        this.view.addCalculateListener(new CalculateListener());
    }



    class CalculateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                int number1 = view.getNumber1();
                int number2 = view.getNumber2();

                view.setCalcSolution(model.addTwoNumbers(number1, number2));

            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

}
