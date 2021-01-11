package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.GamblerDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        consoleHandler.handle();

        BetDao betDao = Factory.getBetDao();
        System.out.println("all bets: " + betDao.getAll());
        GamblerDao gamblerDao = Factory.getGamblerDao();
        System.out.println("all gamblers: " + gamblerDao.getAll());
    }
}