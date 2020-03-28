package projlab.iceisland.model;

public abstract class Player implements IActor {
    public void ate() {

    }

    public void step(int n){}

    public void dig(){}

    public void rescueOtherPlayer(int n){}

    public void eat(){}

    public void buildIgloo(){

    }

    public int checkField(int n){
        return -1;
    }

    public void assembleFlareGun(){}

    public void skipTurn(){}

    public void takeThing(){}

    public void worked() {
    }

    public void setCurrentField(AbstractField abstractField) {
    }

    public void setThing(Thing buriedThing) {

    }
}
