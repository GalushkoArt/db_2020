package homework.riddle_game.view;

import javax.swing.*;
import java.awt.*;

public class SwingUIView implements View {
    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public int askNumberWithMessage(String message) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(message));
            } catch (NumberFormatException | HeadlessException e) {
                showMessage("Пожалуйста введите вашу цифру");
            }
        }
    }
}
