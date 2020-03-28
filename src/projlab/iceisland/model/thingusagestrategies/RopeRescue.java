package projlab.iceisland.model.thingusagestrategies;

import projlab.iceisland.model.Player;

import static projlab.iceisland.model.Thing.*;

public class RopeRescue implements RescueStrategy {
    @Override
    public void rescuePlayer(Player who, int from) {
        who.getCurrentField().step(who.getCurrentField().getNeighbor(from).rescueSomeone());
        who.worked();

    }
}
