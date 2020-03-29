package projlab.iceisland.model.players;

import projlab.iceisland.model.Player;
import projlab.iceisland.model.Thing;

public class Eskimo extends Player {
    public Eskimo(String name, Thing startingItem) {
        super(name,5, 4, startingItem);

    }
    @Override
    public void buildIgloo() {
        super.buildIgloo();
    }
}
