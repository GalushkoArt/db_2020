package homework.riddle_game;

import design_patterns.template_method.Game;
import homework.riddle_game.controller.MyAwesomeRiddleGame;
import homework.riddle_game.view.*;
import homework.riddle_game.view.View;

public class RiddleGameMain {
    public static void main(String[] args) {
        View view = new SwingUIView();
        Game riddleGame = new MyAwesomeRiddleGame(10, view);
        riddleGame.play();
    }
}
