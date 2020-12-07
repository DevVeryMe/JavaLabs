package com.company;

import javax.swing.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class Main {
    public static JTextArea textArea = new JTextArea(" ");
    public static JFrame frame = new JFrame();;
    public static void main(String[] args) throws InterruptedException{
        frame.setBounds(500, 250, 1000, 500);

        textArea.setSize(950, 450);
        JScrollPane scroll = new JScrollPane (textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(scroll);
        String PATH = "file.txt";
        Graph graph = new Graph(PATH);
        Monitor MN = new Monitor();
        frame.setVisible(true);
        MN.run();

        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)
                Executors.newScheduledThreadPool(2);

        Monitor task = new Monitor();
        executor.scheduleWithFixedDelay(task, 2, 2, TimeUnit.SECONDS);
        graph.prima();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}