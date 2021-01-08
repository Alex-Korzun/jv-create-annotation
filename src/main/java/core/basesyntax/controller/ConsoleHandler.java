package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GamblerDao;
import core.basesyntax.dao.GamblerDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Gambler;
import java.util.Scanner;

public class ConsoleHandler {
    private final BetDao betDao = new BetDaoImpl();
    private final GamblerDao gamblerDao = new GamblerDaoImpl();

    public void handle() {
        System.out.println("Print 'value, risk, name, age' for your bet."
                + "For quit type 'quit'.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("quit")) {
                return;
            }
            Bet bet = null;
            Gambler gambler = null;
            try {
                String[] betData = command.split(", ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                String name = betData[2];
                int gamblerAge = Integer.parseInt(betData[3]);
                bet = new Bet(value, risk);
                gambler = new Gambler(name, gamblerAge);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("There should be four parameters!");;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format."
                        + "Please put correct values.");
            }
            if (bet != null && gambler != null) {
                betDao.add(bet);
                gamblerDao.add(gambler);
            }
            System.out.println(bet == null
                    || gambler == null ? "Missing values."
                    : bet.toString() + " " + gambler.toString());
        }
    }
}
