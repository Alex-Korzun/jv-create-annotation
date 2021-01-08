package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.Gambler;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Bet> bets = new ArrayList<>();
    public static final List<Gambler> gamblers = new ArrayList<>();
}
