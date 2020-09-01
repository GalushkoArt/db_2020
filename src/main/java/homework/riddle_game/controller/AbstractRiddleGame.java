package homework.riddle_game.controller;

import design_patterns.template_method.Game;
import homework.riddle_game.view.View;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public abstract class AbstractRiddleGame implements Game {
    protected final int ANSWER;
    protected View view;
    protected int playerAnswer = 0;

    public AbstractRiddleGame(int max) {
        this.ANSWER = new Random(System.currentTimeMillis()).nextInt(max) + 1;
    }

    @Override
    public void play() {
        showWelcomeMessage();
        while(!isPlayerWin()) {
            showTip();
            askPlayer();
        }
        printScore();
    }

    protected abstract void showTip();

    protected abstract void printScore();

    protected abstract void askPlayer();

    protected boolean isPlayerWin() {
        return ANSWER == playerAnswer;
    }

    protected abstract void showWelcomeMessage();
}
