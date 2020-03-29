package projlab.iceisland.model;


import projlab.iceisland.Skeleton;

import static projlab.iceisland.model.Player.PlayerState.InWater;


public abstract class Player implements IActor {

    protected int bodyHeat;
    protected int maxBodyHeat;
    protected Thing thing;
    protected int workPoints;
    protected int maxWorkPoints;
    protected AbstractField currentField;
    protected IceIsland island;
    protected PlayerState currentState = PlayerState.Normal;
    protected String name;


public Player(String name, int bodyHeat,
              int maxBodyHeat,
              int workPoints,
              int maxWorkPoints,
              Thing thing) {
    this.name = name;
    this.bodyHeat = bodyHeat;
    this.maxBodyHeat = maxBodyHeat;
    this.workPoints = workPoints;
    this.maxWorkPoints = maxWorkPoints;
    this.thing = thing;

}


    public Player(String name, int maxBodyHeat, int maxWorkPoints, Thing startingItem) {
        this(name, maxBodyHeat, maxBodyHeat, maxWorkPoints, maxWorkPoints, startingItem);
    }

    public String getName() {
        return name;
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
        Skeleton.called(this, this.getName(), "rescueOtherPlayer", this.name.toString() + ", 1");

        thing.getRescueStrategy().rescuePlayer(this, n);

        Skeleton.returned(this, this.getName(), "rescueOtherPlayer", "");


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
        workPoints = 0;
        //Itt az iceisland nem fogja meghívni az adott körben, csak mivel skeleton ezért még ezt nem tudjuk implementálni rendesen.
        Skeleton.returned(this, this.getName(), "skipTurn", "workpoints set to 0");

    }

    public void takeThing() {
        Skeleton.called(this, this.getName(), "takeThing", "");

        currentField.takeThing(this);

        Skeleton.returned(this, this.getName(), "takeThing", "");


    }


    public boolean isDead() {
        Skeleton.called(this, this.getName(), "isDead", "");
        boolean ret = bodyHeat <= 0;
        Skeleton.returned(this, this.getName(), "isDead", ret ? "true" : "false");

        return ret;
    }

    public boolean isWarm() {
        Skeleton.called(this, this.getName(), "isWarm", "");
        boolean ret = currentState == PlayerState.InIgloo;
        Skeleton.returned(this, this.getName(), "isWarm", ret ? "true" : "false");

        return ret;
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
        Skeleton.called(this, this.getName(), "setThing", "thing");

        this.thing=thing;

        Skeleton.returned(this, this.getName(), "setThing", "");

    }

    public void setCurrentField(AbstractField field) {
        Skeleton.called(this, this.getName(), "setCurrentField", field.getName());

        if(this.currentField != null){
            this.currentField.people.remove(this);
        }
        this.currentField = field;

        Skeleton.returned(this, this.getName(), "setCurrentField", "");

}

    public void setIsland(IceIsland island) {
        Skeleton.called(this, this.getName(), "setIsland", "island");

        this.island = island;

        Skeleton.returned(this, this.getName(), "setIsland", "");

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
        if(currentState == InWater && thing != Thing.Scuba){
            this.bodyHeat = 0;
        }

        Skeleton.returned(this, this.getName(), "update", "");

    }

    public enum PlayerState{
        Normal, InIgloo, InWater
    }

}