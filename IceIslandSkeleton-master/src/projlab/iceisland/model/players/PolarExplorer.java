package projlab.iceisland.model.players;

import projlab.iceisland.Skeleton;
import projlab.iceisland.model.Player;
import projlab.iceisland.model.Thing;

public class PolarExplorer extends Player {

    public PolarExplorer(String name,Thing startingItem) {
        super(name,4, 4, startingItem);
    }

    @Override
    public int checkField(int n) {
        Skeleton.called(this,this.getName(),"checkField",n + "");
        int ret = currentField.getNeighbor(n).getCapacity();
        Skeleton.returned(this,this.getName(),"checkField",ret + "");
        return ret ;
    }
}
