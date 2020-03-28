package projlab.iceisland.model.fields;

import projlab.iceisland.model.AbstractField;

public class UnstableField extends AbstractField {
    private int capacity;

    @Override
    public void step(Player player) {
        super.step(player);
        if(people.size() > capacity){
            Underwater.interact(_player);
        }else if(currentState == Water){
            Underwater.interact(player);
        }
    }
    @Override
    public Player rescueSomeone() {
        if(people.size() == 0 && player != null){
        }
        return player;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void update() {
        super.update();
        if (people.size() > capacity) {
                Underwater.interact(player);
        }
    }
}
