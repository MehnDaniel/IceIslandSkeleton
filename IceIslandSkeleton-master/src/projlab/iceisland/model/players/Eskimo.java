package projlab.iceisland.model.players;

import projlab.iceisland.Skeleton;
import projlab.iceisland.model.Player;
import projlab.iceisland.model.Thing;

import static projlab.iceisland.model.Building.Igloo;

public class Eskimo extends Player {
    public Eskimo(String name, Thing startingItem) {
        super(name,5, 4, startingItem);

    }
    @Override
    public void buildIgloo() {
        Skeleton.called(this,this.getName(),"buildIgloo","Igloo");
        currentField.build(Igloo);
        Skeleton.returned(this,this.getName(),"buildIgloo","");

    }
}
