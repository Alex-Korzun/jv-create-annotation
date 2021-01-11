package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GamblerDao;
import core.basesyntax.dao.GamblerDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static GamblerDao gamblerDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static GamblerDao getGamblerDao() {
        if (gamblerDao == null) {
            gamblerDao = new GamblerDaoImpl();
        }
        return gamblerDao;
    }
}
