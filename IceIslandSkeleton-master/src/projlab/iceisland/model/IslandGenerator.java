package projlab.iceisland.model;

import java.util.ArrayList;
import java.util.List;

public interface IslandGenerator {
    ArrayList<AbstractField> generate(List<Player> players);
}
