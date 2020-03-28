package projlab.iceisland.model;

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

    public AbstractField(int startingSnow, List<Player> players, Thing buriedThing, Building building) {
        this.snow = startingSnow;
        people = players;
        this.buriedThing = buriedThing;
        this.building = building;
    }
    public AbstractField(Thing buriedThing, int startingSnow) {
        this(startingSnow, new ArrayList<>(), buriedThing, NoBuilding);
    }

    public void step(Player player){
        people.add(player);
        player.setCurrentField(this);
    }

    public void dig(int n){
        if (currentState == UnderSnow) {
            snow -= n;
        }
        if(snow <= 0){
            snow = 0;
        }
    }

    public List<Player> getPeople(){
        return people;
    }

    public Player rescueSomeone(){
        if(currentState == Water && !people.isEmpty()){
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
            this.buriedThing = Thing.Nothing;
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
        this.buriedThing = Thing.Nothing;
    }

    public boolean build(Building building){
        if (currentState == UnderSnow) {
            player.buildingBuilt();
            return true;
        }
        return false;
    }

    public void snowing(){
        snow++;
        currentState = UnderSnow;
    }

    public void update(){
        if (hasStorm) {
            snowing();
            Cold.interact(player);
        }
        }
    }
}
