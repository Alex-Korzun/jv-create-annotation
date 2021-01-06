package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class BetConsoleHandler {
    BetDao betDao = new BetDaoImpl();

    public void handle() {
        System.out.println("Print 'value, risk' for your bet."
                + "For quit type 'quit'.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("quit")) {
                return;
            }
            Bet bet = null;
            try {
                try {
                    String[] betData = command.split(", ");
                    int value = Integer.parseInt(betData[0]);
                    double risk = Double.parseDouble(betData[1]);
                    bet = new Bet(value, risk);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("There should be two parameters!");;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format."
                        + "Please put correct values.");
            }
            betDao.add(bet);
            System.out.println(bet == null ? "Missing values."
                    : bet.toString());
        }
    }
}
