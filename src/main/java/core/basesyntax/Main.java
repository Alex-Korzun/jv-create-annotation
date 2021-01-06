package core.basesyntax;

import core.basesyntax.controller.BetConsoleHandler;
import core.basesyntax.controller.GamblerConsoleHandler;

public class Main {
    public static void main(String[] args) {
        BetConsoleHandler betConsoleHandler = new BetConsoleHandler();
        betConsoleHandler.handle();
        GamblerConsoleHandler gamblerConsoleHandler = new GamblerConsoleHandler();
        gamblerConsoleHandler.handle();
    }
}
