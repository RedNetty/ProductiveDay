package com.rednetty.productiveday.frames;

import com.formdev.flatlaf.FlatLightLaf;
import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXImagePanel;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MainFrame {

    public MainFrame () {
        try {
            FlatLightLaf.setup();

            LayoutManager layoutManager = new GridLayout(5, 4);
            JXFrame frame = new JXFrame("Productive Day");

            JXImagePanel imagePanel = new JXImagePanel(new URL("https://a.espncdn.com/combiner/i?img=/i/headshots/nhl/players/full/4233568.png"));
            JXButton calendarButton = new JXButton("Calendar");
            JXButton alertsButton = new JXButton("Alerts");
            JXButton timerButton = new JXButton("Timers");
            JXButton assignmentButton = new JXButton("Assignments");
            frame.setLayout(layoutManager);


            frame.add(imagePanel, 0);
            frame.add(calendarButton, 1);
            frame.add(alertsButton, 2);
            frame.add(timerButton, 3);
            frame.add(assignmentButton, 4);

            frame.pack();
            frame.setVisible(true);
        }catch (MalformedURLException e) {
            System.out.println("Error retrieving images.");
        }


    }


}
