package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Gambler;
import java.util.List;

@Dao
public class GamblerDaoImpl implements GamblerDao {
    @Override
    public void add(Gambler gambler) {
        Storage.gamblers.add(gambler);
    }

    @Override
    public List<Gambler> getAll() {
        return Storage.gamblers;
    }
}
