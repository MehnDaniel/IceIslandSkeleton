package projlab.iceisland.model.thingusagestrategies;

import projlab.iceisland.Skeleton;
import projlab.iceisland.model.Player;
import projlab.iceisland.model.Thing.DiggingStrategy;

public class ShovelDig implements DiggingStrategy {
    @Override
    public void dig(Player who) {
        Skeleton.called(this,"dig",who.toString());

        who.getCurrentField().dig(2);
        Skeleton.called(this,"dig",who.toString());

    }
}
