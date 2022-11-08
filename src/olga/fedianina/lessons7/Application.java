package olga.fedianina.lessons7;

import olga.fedianina.lessons7.base.BinHandler;
import olga.fedianina.lessons7.base.BattleUnit;
import olga.fedianina.lessons7.units.Infantry;
import olga.fedianina.lessons7.units.King;
import olga.fedianina.lessons7.units.Knight;

public class Application {

    public static void main(String[] args) {
        King king1 = new King(200);
        king1.rest();

        King king2 = new King(200);
        king1.rest(king1);

        System.out.println(king1.getHealthScore());


        Infantry infantry1 = new Infantry(30, 10, 5);
        BattleUnit knight = new Knight(30, 10, 5);
        king1.generationArmy();
        king2.generationArmy();
        king1.startBattle(king2);

        BinHandler<King> kingHandler = new BinHandler<>();
        kingHandler.writeToFile(king1);
        King saveKing = kingHandler.readFromFile();
        System.out.println(saveKing);

        }




    }

