package main.models.squares;

import main.Board;
import main.Player;
import main.services.PlayerService;
import main.services.impl.DefaultPlayerService;

public abstract class Square {
    String name;
    protected PlayerService playerService=new DefaultPlayerService();

    public Square(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void doAction(Player player, Board board);
}
