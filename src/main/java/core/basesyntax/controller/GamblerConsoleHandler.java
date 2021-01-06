package core.basesyntax.controller;

import core.basesyntax.dao.GamblerDao;
import core.basesyntax.dao.GamblerDaoImpl;
import core.basesyntax.model.Gambler;
import java.util.Scanner;

public class GamblerConsoleHandler {
    GamblerDao gamblerDao = new GamblerDaoImpl();

    public void handle() {
        System.out.println("Print 'name, age' for new gambler."
                + "For quit type 'quit'.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("quit")) {
                return;
            }
            Gambler gambler = null;
            try {
                try {
                    String[] gamblerData = command.split(", ");
                    String name = gamblerData[0];
                    int age = Integer.parseInt(gamblerData[1]);
                    gambler = new Gambler(name, age);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("There should be two parameters!");;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong format."
                        + "Please put correct values.");
            }
            gamblerDao.add(gambler);
            System.out.println(gambler == null ? "Missing values."
                    : gambler.toString());
        }
    }
}
