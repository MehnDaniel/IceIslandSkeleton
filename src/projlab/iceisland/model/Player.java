package projlab.iceisland.model;


public abstract class Player implements IActor {

import static projlab.iceisland.model.Building.Igloo;
import static projlab.iceisland.model.Player.PlayerState.*;

public abstract class Player implements IUpdatable, IActor {


    protected int bodyHeat;
    protected int maxBodyHeat;
    protected Thing thing;
    protected int workPoints;
    protected int maxWorkPoints;
    protected AbstractField currentField;
    protected IceIsland island;
    protected PlayerState currentState = Normal;

//(this,getname),  szekvenciák alapján
    //enumoknál kevesebb paraméter
public Player(int bodyHeat,
              int maxBodyHeat,
              int workPoints,
              int maxWorkPoints,
              Thing thing) {

    this.bodyHeat = bodyHeat;
    this.maxBodyHeat = maxBodyHeat;
    this.workPoints = workPoints;
    this.maxWorkPoints = maxWorkPoints;
    this.thing = thing;
}


    public Player(int maxBodyHeat, int maxWorkPoints, Thing startingItem) {
        this(maxBodyHeat, maxBodyHeat, maxWorkPoints, maxWorkPoints, startingItem);
    }


    public void ate() {
       called(this, this.getName(), "ate", "");
        thing=Thing.Nothing;
    }

    public void buildingBuilt(Building building) {
        currentState = InIgloo;

        called(this, this.getName(), "buildingBuilt", "Igloo");
    }


    public void step(int n) {
          called(this, this.getName(), "step", "1");

        currentField.stepTo(this, currentField.getNeighbor(n));

    }

    public void dig() {
        thing.getDiggingStrategy().dig(this);

        called(this, this.getName(), "dig", "");
    }



    public enum PlayerState{
        Normal, InIgloo, InWater
    }


    public void rescueOtherPlayer(int n) {
              called(this, this.getName(), "rescueOtherPlayer", "1");
      thing.getRescueStrategy().rescuePlayer(this, n);
     
    }


    public void eat() {
        thing.useForEating(this);

        called(this, this.getName(), "eat", "");
    }

    public void buildIgloo() {
        called(this, this.getName(), "buildIgloo", "");
    }

    public int checkField(int n) {
        called(this, this.getName(), "checkField", "1");
        return -1;
    }

    public void assembleFlareGun() {
        thing.useForShooting(currentField, island);

        called(this, this.getName(), "assembleFlareGun", "");
    }

    public void skipTurn() {
        called(this, this.getName(), "skipTurn", "");
    }

    public void takeThing() {
        currentField.takeThing(this);
        called(this, this.getName(), "takeThing", "");
    }


    public boolean isDead() {
        called(this, this.getName(), "isDead", "");
    return true;
    }

    public boolean isWarm() {
        called(this, this.getName(), "isWarm", "");
        return true;
    }


    public boolean canWork() {
        called(this, this.getName(), "canWork", "");
        return true;
    }

    public int getBodyHeat() {
        called(this, this.getName(), "getBodyHeat", "");
        return bodyHeat;
    }

    public int getWorkPoints() {
        called(this, this.getName(), "getWorkPoints", "");
        return workPoints;
    }

    public AbstractField getCurrentField() {
        called(this, this.getName(), "getCurrentField", "");
        return currentField;
    }

    public Thing getThing() {
        called(this, this.getName(), "getThing", "");
        return thing;
    }

    public void setThing(Thing thing) {
        called(this, this.getName(), "setThing", "");
    this.thing=thing;
    }


    public void setIsland(IceIsland island) {
        this.island = island;
        called(this, this.getName(), "setIsland", "island");
    }

    public void setWorkPoints(int i) {
        workPoints = i;
        called(this, this.getName(), "setWorkPoints", "2");
    }

    public void damage() {
        bodyHeat--;
        called(this, this.getName(), "damage", "");
    }

    public void worked() {
        workPoints--;
        called(this, this.getName(), "worked", "");
    }

    public void setCurrentField(AbstractField field) {
              called(this, this.getName(), "setCurrentField", "field");
        this.currentField.people.remove(this);
        this.currentField = field;
        if(currentField.getBuilding() == Igloo){
            currentState = InIgloo;
        }else {
            currentState = Normal;
        }

    }



    @Override
    public void update() {
              called(this, this.getName(), "update", "");

        this.workPoints = maxWorkPoints;
    }

}
