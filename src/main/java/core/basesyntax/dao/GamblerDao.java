package core.basesyntax.dao;

import core.basesyntax.model.Gambler;
import java.util.List;

public interface GamblerDao {
    void add(Gambler gambler);

    List<Gambler> getAll();
}
