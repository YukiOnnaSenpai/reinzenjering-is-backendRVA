package com.igligoric.jmbg;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

public class Window {

    private JFrame jFrame;
    private JTextField textField;
    private JLabel label;
    private JButton button;

    public Window() {
        jFrame = new JFrame();
        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(new Dimension(500, 300));
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        var jPanel = new JPanel();
        jFrame.add(jPanel, BorderLayout.NORTH);

        textField = new JTextField();
        textField.setColumns(10);

        label = new JLabel();

        button = new JButton("Validiraj");
        jPanel.add(button, 0);
        jPanel.add(textField, 1);

        var labelPanel = new JPanel();
        jFrame.add(labelPanel, BorderLayout.CENTER);
        labelPanel.add(label);

    }

    public void addFunction(Function<String, String> function) {
        button.addActionListener(e -> {
            var functionInput = textField.getText();
            var functionOutput = function.apply(functionInput);
            label.setText(functionOutput);
        });
    }

    public void show() {
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

}
