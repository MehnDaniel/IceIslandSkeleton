package projlab.iceisland.model;

public interface IActor {
    void step(int n);

    void dig();

    void rescueOtherPlayer(int n);

    void eat();

    void buildIgloo();

    int checkField(int n);

    void assembleFlareGun();

    void skipTurn();

    void takeThing();
}

