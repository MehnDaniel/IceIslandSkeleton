package projlab.iceisland.model.players;

import projlab.iceisland.model.Player;
import projlab.iceisland.model.Thing;

public class Eskimo extends Player {
    public Eskimo(Thing startingItem) {
        super(5, 4, startingItem, "");

    }
    @Override
    public void buildIgloo() {
        super.buildIgloo();
    }
}
