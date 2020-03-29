package projlab.iceisland.model;

import com.sun.media.jfxmedia.events.PlayerStateEvent;
import projlab.iceisland.Skeleton;


public abstract class Player implements IActor {

    protected int bodyHeat;
    protected int maxBodyHeat;
    protected Thing thing;
    protected int workPoints;
    protected int maxWorkPoints;
    protected AbstractField currentField;
    protected IceIsland island;
    protected PlayerState currentState = PlayerState.Normal;
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
        Skeleton.called(this, this.getName(), "ate", "");

        thing=Thing.Nothing;

        Skeleton.returned(this, this.getName(), "ate", "");
    }

    public void buildingBuilt(Building building) {
        Skeleton.called(this, this.getName(), "buildingBuilt", "Igloo");

        currentState = PlayerState.InIgloo;

        Skeleton.returned(this, this.getName(), "buildingBuilt", "Igloo");
    }

    public void step(int n) {
        Skeleton.called(this, this.getName(), "step", "1");

        currentField.stepTo(this, currentField.getNeighbor(n));

        Skeleton.returned(this, this.getName(), "step", "1");


    }

    public void dig() {
        Skeleton.called(this, this.getName(), "dig", "");

        thing.getDiggingStrategy().dig(this);

        Skeleton.returned(this, this.getName(), "dig", "");

    }

    public void rescueOtherPlayer(int n) {
        Skeleton.called(this, this.getName(), "rescueOtherPlayer", "1");

        thing.getRescueStrategy().rescuePlayer(this, n);

        Skeleton.returned(this, this.getName(), "rescueOtherPlayer", "1");


    }

    public void eat() {
        Skeleton.called(this, this.getName(), "eat", "");

        thing.useForEating(this);

        Skeleton.returned(this, this.getName(), "eat", "");

    }

    public void buildIgloo() {
        Skeleton.called(this, this.getName(), "buildIgloo", "");

        Skeleton.returned(this, this.getName(), "buildIgloo", "");

    }

    public int checkField(int n) {
        Skeleton.called(this, this.getName(), "checkField", "1");
        Skeleton.returned(this, this.getName(), "checkField", "1");
        return -1;
    }

    public void assembleFlareGun() {
        Skeleton.called(this, this.getName(), "assembleFlareGun", "");

        thing.useForShooting(currentField, island);

        Skeleton.returned(this, this.getName(), "assembleFlareGun", "");



    }

    public void skipTurn() {
        Skeleton.called(this, this.getName(), "skipTurn", "");
        Skeleton.returned(this, this.getName(), "skipTurn", "");

    }

    public void takeThing() {
        Skeleton.called(this, this.getName(), "takeThing", "");

        currentField.takeThing(this);

        Skeleton.returned(this, this.getName(), "takeThing", "");


    }


    public boolean isDead() {
        Skeleton.called(this, this.getName(), "isDead", "");
        Skeleton.returned(this, this.getName(), "isDead", "");

        return true;
    }

    public boolean isWarm() {
        Skeleton.called(this, this.getName(), "isWarm", "");
        Skeleton.returned(this, this.getName(), "isWarm", "");

        return true;
    }

    public boolean canWork() {
        Skeleton.called(this, this.getName(), "canWork", "");
        Skeleton.returned(this, this.getName(), "canWork", "");

        return true;
    }

    public int getBodyHeat() {
        Skeleton.called(this, this.getName(), "getBodyHeat", "");
        Skeleton.returned(this, this.getName(), "getBodyHeat", "");

        return bodyHeat;
    }

    public int getWorkPoints() {
        Skeleton.called(this, this.getName(), "getWorkPoints", "");
        Skeleton.returned(this, this.getName(), "getWorkPoints", "");

        return workPoints;
    }

    public AbstractField getCurrentField() {
        Skeleton.called(this, this.getName(), "getCurrentField", "");
        Skeleton.returned(this, this.getName(), "getCurrentField", "");

        return currentField;
    }

    public Thing getThing() {
        Skeleton.called(this, this.getName(), "getThing", "");
        Skeleton.returned(this, this.getName(), "getThing", "");

        return thing;
    }

    public void setThing(Thing thing) {
        Skeleton.called(this, this.getName(), "setThing", "");

        this.thing=thing;

        Skeleton.returned(this, this.getName(), "setThing", "");

    }

    public void setCurrentField(AbstractField field) {
        Skeleton.called(this, this.getName(), "setCurrentField", "field");

        this.currentField.people.remove(this);
        this.currentField = field;

        Skeleton.returned(this, this.getName(), "setCurrentField", "field");

}

    public void setIsland(IceIsland island) {
        Skeleton.called(this, this.getName(), "setIsland", "island");

        this.island = island;

        Skeleton.returned(this, this.getName(), "setIsland", "island");

    }

    public void setWorkPoints(int i) {
        Skeleton.called(this, this.getName(), "setWorkPoints", "2");
        workPoints = i;
        Skeleton.returned(this, this.getName(), "setWorkPoints", "2");

    }

    public void damage() {
        Skeleton.called(this, this.getName(), "damage", "");

        bodyHeat--;

        Skeleton.returned(this, this.getName(), "damage", "");

    }

    public void worked() {
        Skeleton.called(this, this.getName(), "worked", "");

        workPoints--;

        Skeleton.returned(this, this.getName(), "worked", "");

    }

    public void update() {
        Skeleton.called(this, this.getName(), "update", "");

        this.workPoints = maxWorkPoints;

        Skeleton.returned(this, this.getName(), "update", "");

    }

    public enum PlayerState{
        Normal, InIgloo, InWater
    }

}
