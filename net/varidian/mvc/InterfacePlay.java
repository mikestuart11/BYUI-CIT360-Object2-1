package net.varidian.mvc;

public class InterfacePlay {

    public static void main(String[] args){

        ViewPlay view = new ViewPlay();
        view.setVisible(true);

        ModelPlay model = new ModelPlay();

        ControlPlay control = new ControlPlay(view, model);

    }
}
