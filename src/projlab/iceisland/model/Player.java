package projlab.iceisland.model;

public abstract class Player implements IActor {

    protected int bodyHeat;
    protected int maxBodyHeat;
    protected Thing thing;
    protected int workPoints;
    protected int maxWorkPoints;
    protected AbstractField currentField;
    protected IceIsland island;
    protected PlayerState currentState = Normal;

    public void ate() {

    }

    public void buildingBuilt(Building building) {
    }

    public void step(int n) {
        currentField.stepTo(this, currentField.getNeighbor(n));
    }

    public void dig() {
        thing.getDiggingStrategy().dig(this);
    }

    public void rescueOtherPlayer(int n) {
        thing.getRescueStrategy().rescuePlayer(this, n);
    }

    public void eat() {
        thing.useForEating(this);
    }

    public void buildIgloo() {

    }

    public int checkField(int n) {
        return -1;
    }

    public void assembleFlareGun() {
        thing.useForShooting(currentField, island);
    }

    public void skipTurn() {
    }

    public void takeThing() {
        currentField.takeThing(this);
    }


    public boolean isDead() {
        return true;
    }

    public boolean isWarm() {
        return true;
    }

    public boolean canWork() {
        return true;
    }

    public int getBodyHeat() {
        return bodyHeat;
    }

    public int getWorkPoints() {
        return workPoints;
    }

    public AbstractField getCurrentField() {
        return currentField;
    }

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
    }

    public void setCurrentField(AbstractField field) {
        this.currentField.people.remove(this);
    }

    public void setIsland(IceIsland island) {
    }

    public void setWorkPoints(int i) {
    }

    public void damage() {
    }

    public void worked() {
    }

    public void update() {
    }
}
