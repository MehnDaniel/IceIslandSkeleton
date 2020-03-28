package projlab.iceisland.model.fields;


import projlab.iceisland.model.AbstractField;
import model.*;

import static model.AbstractField.FieldState.NoSnow;
import static model.AbstractField.FieldState.Water;
import static model.Building.NoBuilding;
import static model.Interaction.Underwater;

public class UnstableField extends AbstractField {
    private int capacity;

    public UnstableField(Thing buriedThing, int snow, int capacity, string name) {
        super(buriedThing, snow,name);
        this.capacity = capacity;
    }

    UnstableField(){
        this(Thing.Nothing, 5, 3,"");
    }

    @Override
    public void step(Player player) {
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
    }

    @Override
    public Player rescueSomeone() {
        Player player = super.rescueSomeone();
        if(people.size() == 0 && player != null){
            currentState = NoSnow;
        }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
        public void update() {
            super.update();
            if (people.size() > capacity) {
                for (Player player : people) {
                    Underwater.interact(player);
                }
            }
        }
}
