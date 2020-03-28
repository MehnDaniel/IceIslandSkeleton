package projlab.iceisland.model;

import java.util.ArrayList;
import java.util.List;

import static projlab.iceisland.model.AbstractField.FieldState.*;
import static projlab.iceisland.model.AbstractField.FieldState.UnderSnow;
import static projlab.iceisland.model.Building.NoBuilding;

public abstract class AbstractField {
    protected int snow;
    protected List<Player> people;
    protected FieldState currentState;
    protected Thing buriedThing;
    protected Building building;
    protected boolean hasStorm;
    protected ArrayList<AbstractField> neighbors;

    //?? nem tudom hogy kell e nekem logikusan kell de az oszt diagrammon nincs rajta
    public AbstractField getNeighbor(int n){
        if(n >= neighbors.size())
            return null;

        return neighbors.get(n);
    }

    public void stepTo(Player player, AbstractField field){
        field.step(player);
        player.worked();
        people.remove(player);
    }

    public enum FieldState{
        UnderSnow, NoSnow, Water
    }
    //Konstruktorok kimaradtak innen
    public abstract int getCapacity();

    public void step(Player player){
        people.add(player);
        player.setCurrentField(this);
    }

    public void dig(int n){
        if (currentState == UnderSnow) {
            snow -= n;
        }
        building = NoBuilding;
        if(snow <= 0){
            currentState = NoSnow;
            snow = 0;
        }
    }

    public List<Player> getPeople(){
        return people;
    }

    public Player rescueSomeone(){
        if(currentState == Water && !people.isEmpty()){
            Player player = people.get(0);
            people.remove(player);
            return player;
        }
        return null;
    }

    public void takeThing(Player player){
        if (snow > 0) {
            return;
        }
        if (this.buriedThing != Thing.Nothing) {
            player.setThing(buriedThing);
        }
    }

    public Building getBuilding(){
        return building;
    }

    public FieldState getState(){
        return currentState;
    }

    public Thing getThing() {
        return buriedThing;
    }

    public boolean hasStorm() {
        return hasStorm;
    }

    protected void setStorm(boolean bool){

    }

    public boolean build(Building building){
        if (currentState == UnderSnow) {
            player.buildingBuilt();
            return true;
        }
        return false;
    }

    public void snowing(){


    }

    public void update(){
        if (hasStorm) {
            snowing();
            Cold.interact(player);
            if(r < 0.25){ setStorm(false);
            }
        }else{
            if(r < 0.6){
                setStorm(true);
            }
        }
    }
}
