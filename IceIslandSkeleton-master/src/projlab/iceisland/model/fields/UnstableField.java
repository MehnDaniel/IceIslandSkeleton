package projlab.iceisland.model.fields;


import projlab.iceisland.Skeleton;
import projlab.iceisland.model.AbstractField;
import projlab.iceisland.model.Player;
import projlab.iceisland.model.Thing;

import java.util.List;

import static projlab.iceisland.model.AbstractField.FieldState.NoSnow;
import static projlab.iceisland.model.AbstractField.FieldState.Water;
import static projlab.iceisland.model.Building.NoBuilding;
import static projlab.iceisland.model.Interaction.Underwater;

public class UnstableField extends AbstractField {
    private int capacity;

    public UnstableField(Thing buriedThing, int snow, int capacity, List<AbstractField> neighbors, String name) {
        super(buriedThing, snow, neighbors, name);
        this.capacity = capacity;
    }


    @Override
    public void step(Player player) {
        Skeleton.called(this,"step",player.toString());
        super.step(player);
        if(people.size() > capacity){
            for(Player _player : people){
                Underwater.interact(_player);
            }
            currentState = Water;
            building = NoBuilding;
            snow = 0;
            //handles edgecase, when unstable field is water, but there are only 2 people in there
        }else if(currentState == Water){
            Underwater.interact(player);
        }
        Skeleton.returned(this,"step",player.toString());

    }

    @Override
    public Player rescueSomeone() {
        Skeleton.called(this,this.getName(),"rescueSomeone","");

        Player player = super.rescueSomeone();
        if (people.size() == 0 && player != null) {
            currentState = NoSnow;
        }
        Skeleton.returned(this,this.getName(),"rescueSomeone","");

        return player;

    }

    @Override
    public int getCapacity() {
        Skeleton.called(this,this.getName(),"getCapacity","");
        Skeleton.returned(this,this.getName(),"getCapacity","");
        return capacity;
    }

    @Override
        public void update() {
        Skeleton.called(this,this.getName(),"update","");
            super.update();
            if (people.size() > capacity) {
                for (Player player : people) {
                    Underwater.interact(player);
                }
            }
        Skeleton.returned(this,this.getName(),"update","");
        }
}
