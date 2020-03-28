package projlab.iceisland;


import projlab.iceisland.model.AbstractField;
import projlab.iceisland.model.IceIsland;
import projlab.iceisland.model.Player;
import projlab.iceisland.model.Thing;
import projlab.iceisland.model.fields.StableField;
import projlab.iceisland.model.fields.UnstableField;
import projlab.iceisland.model.players.Eskimo;
import projlab.iceisland.model.players.PolarExplorer;

import java.util.List;

public class Console {

    public void testCases()
    {
        //a tesztesetek listázása
        System.out.println("Tesztesetek:\n" +
        "1. Új játék\n" +
        "2. Kilépés a játékból\n" +
        3. Kör befejezése\n
        4. Másik mezőre lépés\n
        a. A mező szomszédos?\n
        5. Iglu építése\n
        a. A mező hó alatt van?\n
        6. Mező teherbírásának ellenőrzése\n
        a. A mező szomszédos?\n
        7. Hó eltakarítása\n
        a. Legyen ásó a játékosnál?\n
        8. Jelzőrakéta összeszerelése és elsütése\n
        a. A játékosnál van az egyik darab?\n
        b. A mezőn van az összes darab és játékos?\n
        9. Evés\n
        a. A játékosnál lévő tárgy étel?\n
        10. Eszköz felvétele\n
        a. Van a mezőn hó?\n
        b. Van a mezőn tárgy?\n
        11. Másik játékos kimentése szomszéd mezőről\n
        a. Van a játékosnál kötél?\n
        b. Szomszédos mezőről akar menteni?\n
        c. Van valaki a vízben?\n
        12. Vízbefulladás\n
        a. Vízben van a játékos?\n
        b. Van a játékoson búvárruha?\n
        13. Havazás\n
        a. Van játékos, aki nincs igluban?\n
        b. Van olyan, aki időközben meghalt?\n");

        //input
        Scanner in = new Scanner(System.in);
        //input beolvasása
        int i = in.nextInt();

        //teszteset számának kiírása
        System.out.println("Teszteset: " + i);


        //a tesztesetek
        switch(i)
        {
            case 1:
                //új játék indítása
                builder.createIceIsland();
                break;
            case 2:
                //exit
                System.exit(0);
                break;
            case 3:
                //kör befejezése
                player.skipTurn();
                break;
            case 4:
                //a játékos lép
                eskimo.step(absField.id);
                break;
            case 5:
                //az eszkimó iglut épít
                eskimo.buildIgloo();
                break;

                //Példa implementáció:
            case 6:
                //nem feltétlenül ez lesz a konstruktorhívás kinézete de lényeg hogy nem kell bele semmilyen tárgy
                PolarExplorer explorer = new PolarExplorer();

                //Megjegyzem: kelleni fog az abstractfieldnek egy addNeighbour függvény,
                // mert így elég nehéz lesz gráfot építeni i guess.

                AbstractField unstable = new UnstableField(Thing.Nothing, 4, 2, List.of(),"unstable1");
                AbstractField stable = new StableField(Thing.Nothing, 8, List.of(unstable), "stable1");


                List<AbstractField> fields = List.of(
                        stable,
                        unstable
                );

                IceIsland island = new IceIsland.Builder()
                        .players(List.of(explorer))
                        .generator(new SkeletonIslandGenerator(fields))
                        .createIceIsland();

                //a sarkkutató csekkolja a szomszédos mezőt
                explorer.checkField(0);
                break;
            case 7:
                //a játékos havat takarít
                if(j == 1){
                    Player eskimo = new Eskimo(Thing.Shovel);


                }else{

                }
                eskimo.dig();
                break;
            case 8:
                //a játékos összeszereli a jelzőrakétát
                eskimo.assambleFlareGun();
                break;
            case 9:
                //a játékos eszik
                eskimo.eat();
                break;
            case 10:
                //a játékos felvesz egy eszközt
                eskimo.takeThing();
                break;
            case 11:
                //a játékos kimenti egy társát a szomszédos mezőről
                eskimo.rescueOtherPlayer();
                break;
            case 12:
                //a játékos vízbefullad, vagy búvárkodik
                eskimo.isDead();
                break;
            case 13:
                //havazik
                iceisland.updateAll();
                break;
            default:
        }
    }
}
