package com.rednetty.productiveday.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXPanel;

import com.formdev.flatlaf.FlatLightLaf;
import com.rednetty.utils.DateUtils;

public class MainFrame {

    private JFrame frame;
    private JXLabel timeLabel;
    private JPanel topPanel;
    private JLabel imageLabel;
    private JPanel centerPanel;
    private JXButton calendarButton;
    private JXButton alertsButton;
    private JXButton timersButton;
    private JXButton assignmentsButton;

    public MainFrame() {
        setupLookAndFeel();
        setupFrame();
        setupTopPanel();
        setupCenterPanel();
        startClock();
        showFrame();
    }

    private void setupLookAndFeel() {
        try {
            FlatLightLaf.setup();
        } catch (Exception ex) {
            System.out.println("Error setting up Look and Feel.");
        }
    }

    private void setupFrame() {
        frame = new JXFrame("Productive Day");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setMinimumSize(new Dimension(500, 600));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(0x2d2d2d));
    }

    private void setupTopPanel() {
        topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(0, 80));
        topPanel.setBackground(new Color(0x222222));

        timeLabel = new JXLabel(getCurrentTimeFormatted());
        timeLabel.setForeground(new Color(0xffffff));
        timeLabel.setFont(timeLabel.getFont().deriveFont(Font.BOLD, 36.0f));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topPanel.add(timeLabel, BorderLayout.CENTER);

        frame.add(topPanel, BorderLayout.NORTH);
    }

    private void setupCenterPanel() {
        centerPanel = new JXPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(0x2d2d2d));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(setupImageLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(30, 0, 0, 0);
        centerPanel.add(setupButtons(), gbc);

        frame.add(centerPanel, BorderLayout.CENTER);
    }

    private JPanel setupImageLabel() {
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(new Color(0x2d2d2d));

        try {
            imageLabel = new JLabel(new ImageIcon(new URL("https://ntvb.tmsimg.com/assets/assets/182528_v9_bc.jpg?w=120&h=120")));
            imageLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } catch (MalformedURLException e) {
            System.out.println("Error retrieving images.");
        }
        return imagePanel;
    }

    private JPanel setupButtons() {
        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setBackground(new Color(0x2d2d2d));

        GridBagConstraints gbc = new GridBagConstraints();

        calendarButton = new JXButton("Calendar");
        calendarButton.setForeground(new Color(0xffffff));
        calendarButton.setBackground(new Color(0x3a3a3a));
        calendarButton.setFont(calendarButton.getFont().deriveFont(Font.BOLD, 18.0f));
        calendarButton.setFocusPainted(false);
        calendarButton.setPreferredSize(new Dimension(180, 60));
        calendarButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 20, 0, 20);
        gbc.anchor = GridBagConstraints.CENTER;
        buttonsPanel.add(calendarButton, gbc);

        alertsButton = new JXButton("Alerts");
        alertsButton.setForeground(new Color(0xffffff));
        alertsButton.setBackground(new Color(0x3a3a3a));
        alertsButton.setFont(alertsButton.getFont().deriveFont(Font.BOLD, 18.0f));
        alertsButton.setFocusPainted(false);
        alertsButton.setPreferredSize(new Dimension(180, 60));
        alertsButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 20);
        gbc.anchor = GridBagConstraints.CENTER;
        buttonsPanel.add(alertsButton, gbc);

        timersButton = new JXButton("Timers");
        timersButton.setForeground(new Color(0xffffff));
        timersButton.setBackground(new Color(0x3a3a3a));
        timersButton.setFont(timersButton.getFont().deriveFont(Font.BOLD, 18.0f));
        timersButton.setFocusPainted(false);
        timersButton.setPreferredSize(new Dimension(180, 60));
        timersButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 20, 0, 20);
        gbc.anchor = GridBagConstraints.CENTER;
        buttonsPanel.add(timersButton, gbc);

        assignmentsButton = new JXButton("Assignments");
        assignmentsButton.setForeground(new Color(0xffffff));
        assignmentsButton.setBackground(new Color(0x3a3a3a));
        assignmentsButton.setFont(assignmentsButton.getFont().deriveFont(Font.BOLD, 18.0f));
        assignmentsButton.setFocusPainted(false);
        assignmentsButton.setPreferredSize(new Dimension(180, 60));
        assignmentsButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 20);
        gbc.anchor = GridBagConstraints.CENTER;
        buttonsPanel.add(assignmentsButton, gbc);

        return buttonsPanel;
    }

    private void startClock() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("Error updating clock.");
                }
                timeLabel.setText(getCurrentTimeFormatted());
            }
        }).start();
    }

    private String getCurrentTimeFormatted() {
        LocalTime currentTime = DateUtils.getCurrentTime().toLocalTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        return currentTime.format(formatter);
    }

    private void showFrame() {
        frame.setVisible(true);
    }
}
