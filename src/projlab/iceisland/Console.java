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
        "3. Kör befejezése\n" +
        "4. Másik mezőre lépés\n" +
        "   a. A mező szomszédos?\n" +
        "5. Iglu építése\n" +
        "   a. A mező hó alatt van?\n" +
        "6. Mező teherbírásának ellenőrzése\n" +
        "   a. A mező szomszédos?\n" +
        "7. Hó eltakarítása\n" +
        "   a. Legyen ásó a játékosnál?\n" +
        "8. Jelzőrakéta összeszerelése és elsütése\n" +
        "   a. Legyen a játékosnál az egyik darab?\n" +
        "   b. Legyen a mezőn az összes darab és játékos?\n" +
        "9. Evés\n" +
        "   a. Legyen a játékosnál étel?\n" +
        "10. Eszköz felvétele\n" +
        "   a. Van a mezőn hó?\n" +
        "   b. Van a mezőn tárgy?\n" +
        "11. Másik játékos kimentése szomszéd mezőről\n" +
        "   a. Van a játékosnál kötél?\n" +
        "   b. Szomszédos mezőről akar menteni?\n" +
        "   c. Van valaki a vízben?\n" +
        "12. Vízbefulladás\n" +
        "   a. Vízben van a játékos?\n" +
        "   b. Van a játékoson búvárruha?\n" +
        "13. Havazás\n" +
        "   a. Van játékos, aki nincs igluban?\n" +
        "   b. Van olyan, aki időközben meghalt?\n");

        //input
        Scanner in = new Scanner(System.in);
        //input beolvasása

        //teszteset számának kiírása
        System.out.println("Teszteset: " + case);

        //a tesztesetekhez szükséges objektumok létrehozása
        /*Builder builder = new Builder();
        Eskimo eskimo = new Eskimo();
        PolarExplorer explorer = new PolarExplorer();
        AbstractField absField = new AbstractField();
        RopeRescue strategy = new RopeRescue();
        IceIsland iceisland = new IceIsland();*/

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
                System.out.println("A mező hó alatt van? (i/n) ");
                char answer = in.next().charAt(0);
                if(answer == i)
                {
                  AbstractField stablefield = new StableField(Thing.Nothing, 4, List.of(), "havas_stabil");
                }
                else
                {
                  AbstractField stablefield = new StableField(Thing.Nothing, 0, List.of(), "havas_stabil");
                }
                eskimo.buildIgloo();
                break;

            /*case 6:
                //a sarkkutató csekkolja a szomszédos mezőt
                explorer.checkField(absField);
                break;
            case 7:
                //a játékos havat takarít
                Eskimo eskimo = new Eskimo();*/

                //Példa implementáció:
            case 6:
                //a sarkkutató csekkolja a szomszédos mezőt
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

                explorer.checkField(0);
                break;
            case 7:
                //a játékos havat takarít
                AbstractField havas = new StableField(Thing.Nothing, 8, List.of(), "havas_mezo");
                System.out.println("Legyen ásó a játékosnál? (i/n) ");
                char answer = in.next().charAt(0);
                if(answer == 'i')
                {
                    Player eskimo = new Eskimo(Thing.Shovel);
                    havas.step(eskimo);
                    eskimo.dig();
                }
                else
                {
                  Player eskimo = new Eskimo();
                  havas.step(eskimo);
                  eskimo.dig();
                }
                //eskimo.setCurrentField(havas);
                //eskimo.dig();
                break;
            case 8:
                //a játékos összeszereli a jelzőrakétát
                System.out.println("Legyen a játékosnál az egyik darab? (i/n) ");
                char answer = in.next().charAt(0);
                AbstractField stablefield = new StableField(Thing.Nothing, 8, List.of(), "raketas_mezo")
                if(answer == 'i')
                {
                  Player eskimo = new Eskimo(Thing.Cartridge); //FlareGun, Beacon kell még
                  System.out.println("Legyen a mezőn az összes darab és játékos? (i/n) ");
                  char answer2 = in.next().charAt(0);
                  if(answer2 == 'i')
                  {
                    Player explorer1 = new PolarExplorer(Thing.FlareGun);
                    Player explorer2 = new PolarExplorer(Thing.Beacon);
                    stablefield.step(eskimo);
                    stablefield.step(explorer1);
                    stablefield.step(explorer2);
                    eskimo.assambleFlareGun();
                  }
                  else
                  {

                  }
                }
                else
                {
                  Player eskimo = new Eskimo(Thing.Nothing);
                  System.out.println("Legyen a mezőn az összes darab és játékos? (i/n) ");
                  char answer2 = in.next().charAt(0);
                  if(answer2 == 'i')
                  {
                    Player explorer1 = new PolarExplorer(Thing.FlareGun);
                    Player explorer2 = new PolarExplorer(Thing.Beacon);
                    Player explorer3 = new PolarExplorer(Thing.Cartridge);
                    stablefield.step(explorer3);
                    stablefield.step(explorer1);
                    stablefield.step(explorer2);
                    eskimo.assambleFlareGun();
                  }
                  else
                  {

                  }
                }
                //eskimo.assambleFlareGun();
                break;
            case 9:
                //a játékos eszik
                //Eskimo eskimo = new Eskimo();
                System.out.println("Legyen a játékosnál étel? (i/n) ");
                char answer = in.next().charAt(0);
                if(answer == 'i')
                {
                    Player eskimo = new Eskimo(Thing.Food);
                }
                else{ Player eskimo = new Eskimo();}
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
