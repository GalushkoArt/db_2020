package homework.riddle_game.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView implements View {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public int askNumberWithMessage(String message) {
        showMessage(message);
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                showMessage("Введите цифру");
            } catch (IOException e) {
                e.printStackTrace();
                throw new UnknownError("Произошла непредвиденная ошибка при чтении");
            }
        }
    }
}
