package projlab.iceisland.model.thingusagestrategies;

import projlab.iceisland.Skeleton;
import projlab.iceisland.model.Player;

import static projlab.iceisland.model.Thing.*;

public class RopeRescue implements RescueStrategy {
    @Override
    public void rescuePlayer(Player who, int from) {
        Skeleton.called(this,"rescuePlayer",who.toString()+", "+from.toString());
        who.getCurrentField().step(who.getCurrentField().getNeighbor(from).rescueSomeone());
        who.worked();
        Skeleton.returned(this,"rescuePlayer",who.toString()+", "+from.toString());
    }
}
