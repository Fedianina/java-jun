package olga.fedianina.lesson20;

public class Game {

    private BinHandler<Game> gameBinHandler;

    public Game(){
        this.gameBinHandler = new BinHandler<>();
    }

    public void save(){
        gameBinHandler.writeToFile(this);
    }

    public void read (){
        Game game = gameBinHandler.readFromFile();
        //this.user = game.user
    }
}
