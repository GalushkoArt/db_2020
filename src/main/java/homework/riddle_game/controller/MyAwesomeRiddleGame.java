package homework.riddle_game.controller;

import homework.riddle_game.view.View;

public class MyAwesomeRiddleGame extends AbstractRiddleGame {
    private int score = 1000;

    public MyAwesomeRiddleGame(int max, View view) {
        super(max);
        this.view = view;
    }

    @Override
    protected void printScore() {
        view.showMessage("Красава! Ты угадал!");
        view.showMessage(String.format("У тебя %s очков", score));
    }

    @Override
    protected void askPlayer() {
        playerAnswer = view.askNumberWithMessage("Напиши свой вариант");
        score -= 10;
    }

    @Override
    protected void showTip() {
        if (playerAnswer > ANSWER) {
            view.showMessage("Братан, это слишком много");
        } else {
            view.showMessage("Да ну. Слишком мало");
        }
    }

    @Override
    protected void showWelcomeMessage() {
        view.showMessage("У тебя слишком много времени? - эта игра для тебя! Угадай что загадала железяка!");
    }
}
