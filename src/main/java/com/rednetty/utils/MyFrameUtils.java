package com.rednetty.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyFrameUtils {

    public static JFrame createFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(UIUtils.BACKGROUND_COLOR);
        frame.setSize(800, 600);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        return frame;
    }

    public static JLabel createLabel(String text, int fontSize, int fontStyle, Color color) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setFont(new Font(UIUtils.FONT_FAMILY, fontStyle, fontSize));
        return label;
    }

    public static JButton createButton(String text, int fontSize, int fontStyle, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setBackground(UIUtils.BUTTON_COLOR);
        button.setForeground(UIUtils.TEXT_COLOR);
        button.setFocusPainted(false);
        button.setFont(new Font(UIUtils.FONT_FAMILY, fontStyle, fontSize));
        button.addActionListener(actionListener);
        button.setPreferredSize(new Dimension(180, 60));
        button.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, UIUtils.BORDER_COLOR));
        return button;
    }
}
