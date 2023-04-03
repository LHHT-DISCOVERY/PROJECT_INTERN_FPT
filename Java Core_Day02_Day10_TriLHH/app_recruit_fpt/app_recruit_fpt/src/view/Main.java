package view;

import controller.ControllerApp;
import model.Experience;

public class Main {
    public static void main(String[] args) {
        Experience experience = new Experience(12, "tri", "2001-20-10", "0333915138", "emailtesst", 4, 42, "trikjad");
        System.out.println(experience.showMe());
        ControllerApp controllerApp = new ControllerApp();
        controllerApp.displayMenu();

    }
}