package projlab.iceisland;


import projlab.iceisland.model.*;
import projlab.iceisland.model.fields.HoleField;
import projlab.iceisland.model.fields.StableField;
import projlab.iceisland.model.fields.UnstableField;
import projlab.iceisland.model.players.Eskimo;
import projlab.iceisland.model.players.PolarExplorer;

import java.util.List;
import java.util.Scanner;

public class Console {

    public static void testCases()
    {
        //a tesztesetek listázása

        System.out.println("Tesztesetek:\n" +
                "2. Kilépés a Skeletonból/játékból\n" +
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

        //a System.out.println("-----------"); arra szolgál hogy jelezzük hol ér véget az előkészítés

        //a tesztesetek
        switch(i)

        {
            case 1:
                //új játék indítása
                //builder.createIceIsland();
                System.out.println("Törölt testcase, sorry");
                break;
            case 2:
                //exit
                System.exit(0);
                break;
            case 3:
                //kör befejezése
                Player eskimo3 = new Eskimo("player1", Thing.Nothing);
                eskimo3.skipTurn();
                break;
            case 4:
                //a játékos lép
                Player eskimo4 = new Eskimo("player1", Thing.Nothing);
                AbstractField sf4_1 = new StableField(Thing.Nothing, 4, List.of(), "havas_stabil1");
                AbstractField sf4_2 = new StableField(Thing.Nothing, 4, List.of(sf4_1), "havas_stabil2");
                System.out.println("A két mező szomszédos? (i/n) ");
                char answer4 = in.next().charAt(0);
                if(answer4 == i)
                {
                    sf4_2.step(eskimo4);
                    System.out.println("-----------");
                    eskimo4.step(0);
                }
            case 5:
                //az eszkimó iglut épít
                System.out.println("A mező hó alatt van? (i/n) ");
                char answer5 = in.next().charAt(0);
                Eskimo eskimo = new Eskimo("eskimo1", Thing.Nothing);
                if(answer5 == i)
                {
                    AbstractField sf = new StableField(Thing.Nothing, 4, List.of(), "havas_stabil");
                    sf.step(eskimo);
                    System.out.println("-----------");
                    eskimo.buildIgloo();
                }
                else
                {
                    //reasoning: mégis hogy építene szerencsétlen eszkimó iglut hó nélkül?
                    AbstractField sf = new StableField(Thing.Nothing, 0, List.of(), "havatlan_stabil");
                    sf.step(eskimo);
                    System.out.println("-----------");
                    eskimo.buildIgloo();
                }

                break;

            case 6:
                //explorer checks field
                PolarExplorer explorer = new PolarExplorer("explorer1", Thing.Nothing);

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
                System.out.println("-----------");
                explorer.checkField(0);
                break;
            case 7:
                //player digs
                AbstractField snowy = new StableField(Thing.Nothing, 8, List.of(), "havas_mezo");
                System.out.println("Legyen ásó a játékosnál? (i/n) ");
                char answer7 = in.next().charAt(0);

                Player player7 = null;

                if(answer7 == 'i')
                {
                    player7 = new Eskimo("player1", Thing.Shovel);
                }
                else
                {
                    player7 = new Eskimo("player1", Thing.Nothing);
                }
                snowy.step(player7);
                System.out.println("-----------");
                player7.dig();
                break;
            case 8:
                //a játékos összeszereli a jelzőrakétát

                AbstractField stable1 = new StableField(Thing.Nothing, 8, List.of(), "raketas_mezo");
                AbstractField stable2 = new StableField(Thing.Nothing, 7, List.of(stable1), "masik_mezo");
                Player player8_1 = null;
                Player player8_2 = new PolarExplorer("player2", Thing.FlareGun);
                Player player8_3 = new PolarExplorer("player3", Thing.Beacon);

                System.out.println("Legyen a játékosnál az egyik darab? (i/n) ");
                char answer8_1 = in.next().charAt(0);
                if(answer8_1 == 'i')
                {
                    player8_1 = new Eskimo("player1", Thing.Cartridge);
                    System.out.println("Legyen a mezőn az összes darab és játékos? (i/n) ");
                    char answer8_2 = in.next().charAt(0);
                    if(answer8_2 == 'i')
                    {
                        IceIsland island8_1 = new IceIsland.Builder()
                                .generator(new SkeletonIslandGenerator(List.of(stable1, stable2)))
                                .players(List.of(player8_1, player8_2, player8_3))
                                .createIceIsland();
                        System.out.println("-----------");
                        player8_1.assembleFlareGun();
                    }
                    else{
                        IceIsland island8_2 = new IceIsland.Builder()
                                .generator(new SkeletonIslandGenerator(List.of(stable2, stable1)))
                                .players(List.of(player8_1, player8_2, player8_3))
                                .createIceIsland();
                        //mivel az a konvenciónk hogy mindig az elsőként megadott mezőre léptetjük rá az összes játékost
                        //ezért most arra a mezőre tesszük a játékosokat akinek van szomszédja majd az egyiket elléptetjük
                        player8_2.step(0);
                        System.out.println("-----------");
                        player8_1.assembleFlareGun();
                    }
                }
                else{
                    //nem lesz a kezében semmi, ezért nem tudja megnyerni a játékot.
                    player8_1 = new Eskimo("player1", Thing.Nothing);
                    IceIsland island8_2 = new IceIsland.Builder()
                            .generator(new SkeletonIslandGenerator(List.of(stable1, stable2)))
                            .players(List.of(player8_1, player8_2, player8_3))
                            .createIceIsland();
                    System.out.println("-----------");
                    player8_1.assembleFlareGun();
                }
                //eskimo.assembleFlareGun();
                break;
            case 9:
                //a játékos eszik
                //Eskimo eskimo = new Eskimo();
                System.out.println("Legyen a játékosnál étel? (i/n) ");
                char answer9 = in.next().charAt(0);
                if(answer9 == 'i')
                {
                    Player eskimo9_1 = new Eskimo("player1", Thing.Food);
                    System.out.println("-----------");
                    eskimo9_1.eat();
                }
                else {
                    Player eskimo9_2 = new Eskimo("player1", Thing.Food);
                    System.out.println("-----------");
                    eskimo9_2.eat();
                }

                break;
            case 10:
                //a játékos felvesz egy eszközt
                Player eskimo10 = new Eskimo("player1", Thing.Nothing);
                System.out.println("Van a mezőn hó? (i/n) ");
                char answer10_1 = in.next().charAt(0);
                System.out.println("Van a mezőn tárgy? (i/n) ");
                char answer10_2 = in.next().charAt(0);


                if(answer10_1 == 'i' && answer10_2 == 'i'){
                    AbstractField takethingfield = new StableField(Thing.Food, 2, List.of(), "havastargyas");
                    takethingfield.step(eskimo10);
                    System.out.println("-----------");
                    eskimo10.takeThing();
                }else if(answer10_1 == 'i' && answer10_2 != 'i'){
                    AbstractField takethingfield = new StableField(Thing.Nothing, 2, List.of(), "havasnemtargyas");
                    takethingfield.step(eskimo10);
                    System.out.println("-----------");
                    eskimo10.takeThing();
                }else if(answer10_1 != 'i' && answer10_2 == 'i'){
                    AbstractField takethingfield = new StableField(Thing.Food, 0, List.of(), "nemhavastargyas");
                    takethingfield.step(eskimo10);
                    System.out.println("-----------");
                    eskimo10.takeThing();
                }else{
                    AbstractField takethingfield = new StableField(Thing.Nothing, 0, List.of(), "nemhavasnemtargyas");
                    takethingfield.step(eskimo10);
                    System.out.println("-----------");
                    eskimo10.takeThing();
                }


                break;
            case 11:
                //a játékos kimenti egy társát a szomszédos mezőről
                //eskimo.rescueOtherPlayer();
                /*"   a. Van a játékosnál kötél?\n" +
                        "   b. Szomszédos mezőről akar menteni?\n" +
                        "   c. Van valaki a vízben?\n" +*/
                System.out.println("Van a játékosnál kötél? (i/n) ");
                char answer11_1 = in.next().charAt(0);


                if(answer11_1 == 'i')
                {


                    Eskimo eskimo11_1 = new Eskimo("eskimo11_1", Thing.Rope);
                    System.out.println("Szomszédos mezőről akar menteni? (i/n) ");
                    char answer11_2 = in.next().charAt(0);
                    if(answer11_2 == 'i')
                    {
                        AbstractField hole11 = new HoleField(0, List.of(), "lyuk");
                        AbstractField sfield11 = new StableField(Thing.Nothing, 0, List.of(hole11),"mentos_mezo");
                        sfield11.step(eskimo11_1);
                        System.out.println("Van valaki a vízben? (i/n) ");
                        char answer11_3 = in.next().charAt(0);
                        if(answer11_3 == 'i')
                        {
                            Player victim11 = new Eskimo("victim", Thing.Nothing);
                            hole11.step(victim11);
                            System.out.println("-----------");
                            eskimo11_1.rescueOtherPlayer(0);
                        }else {
                            sfield11.step(eskimo11_1);
                            System.out.println("-----------");
                            eskimo11_1.rescueOtherPlayer(0);
                        }
                    }else{
                        AbstractField hole11 = new HoleField(0, List.of(), "lyuk");
                        AbstractField sfield11 = new StableField(Thing.Nothing, 0, List.of(),"mentos_mezo");
                        sfield11.step(eskimo11_1);
                        System.out.println("-----------");
                        eskimo11_1.rescueOtherPlayer(0);
                    }
                }
                else
                {
                    Eskimo eskimo11_2 = new Eskimo("eskimo11_2",Thing.Nothing);
                    AbstractField sfield11 = new StableField(Thing.Nothing, 0, List.of(),"mentos_mezo");
                    sfield11.step(eskimo11_2);
                    System.out.println("-----------");
                    eskimo11_2.rescueOtherPlayer(0);
                }
                break;
            case 12:
                //a játékos vízbefullad, vagy búvárkodik

                //így utolag nem teljesen értjük hogy ez hogy került ide ez a kérdés, de mostmár marad
                System.out.println("Vízben van a játékos? (i/n) ");
                char answer12 = in.next().charAt(0);
                if(answer12 == 'i')
                {
                    System.out.println("Van a játékoson búvárruha? (i/n) ");
                    char answer122 = in.next().charAt(0);
                    if(answer122 == 'i')
                    {
                        Player eskimo12_1 = new Eskimo("scubaeskimo", Thing.Scuba);

                    }
                    else
                    {
                        Player eskimo12_2 = new Eskimo("scubatlaneskimo", Thing.Nothing);
                        eskimo12_2.damage();
                    }
                }
                else
                {
                        Player eskimo122 = new Eskimo("notdrowningplayer", Thing.Nothing);
                    AbstractField field1 = new StableField(Thing.Nothing, 0, List.of(), "field1");
                    IceIsland island12 = new IceIsland.Builder().generator(new SkeletonIslandGenerator(List.of(field1)))
                            .players(List.of(eskimo122)).createIceIsland();
                    island12.updateAll();

                }
                break;
            case 13:
                //havazik

                /*
                "13. Havazás\n" +
                        "   a. Van játékos, aki nincs igluban?\n" +
                        "   b. Van olyan, aki időközben meghalt?\n");
                */

                AbstractField field1 = new StableField(Thing.Nothing, 0, List.of(), "field1");
                field1.setStorm(true);
                Player player1 = new PolarExplorer("useless", Thing.Nothing);
                IceIsland island13 = new IceIsland.Builder()
                        .generator(new SkeletonIslandGenerator(List.of(field1)))
                        .players(List.of(player1))
                        .createIceIsland();

                System.out.println("Van játékos aki nincs igluban?");
                char answer13_1 = in.next().charAt(0);

                if(answer13_1 == 'i'){
                    System.out.println("Van olyan, aki időközben meghalt?");
                    char answer13_2 = in.next().charAt(0);
                    if(answer13_2 == 'i'){
                        //ha később lesz olyan ami nem egy sebzést csinál akkor majd lesz egy paramétere a damagenek, addig mindegy
                        player1.damage();
                        player1.damage();
                        player1.damage();
                        System.out.println("-----------");
                        island13.updateAll();
                    }else{
                        System.out.println("-----------");
                        island13.updateAll();
                    }
                }else{
                    field1.build(Building.Igloo);
                    System.out.println("-----------");
                    island13.updateAll();
                }

                break;
            default:
        }
    }
}