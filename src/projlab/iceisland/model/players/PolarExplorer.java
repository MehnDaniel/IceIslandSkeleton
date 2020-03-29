package projlab.iceisland.model.players;

import projlab.iceisland.model.Player;
import projlab.iceisland.model.Thing;

public class PolarExplorer extends Player {

    public PolarExplorer(Thing startingItem) {
        super(4, 4, startingItem);
    }

    @Override
    public int checkField(int n) {
        //return super.checkField(n);
        return currentField.getNeighbor(n).getCapacity();
    }
}
