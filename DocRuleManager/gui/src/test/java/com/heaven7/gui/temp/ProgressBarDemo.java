package com.heaven7.gui.temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProgressBarDemo extends JFrame {
    private JProgressBar progressBar;
    private JButton startButton;
    private SwingWorker<Void, Void> worker;

    public ProgressBarDemo() {
        setTitle("进度条演示");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        startButton = new JButton("开始");

        startButton.addActionListener(e -> startTask());
        add(progressBar);
        add(startButton);
        pack();
        setVisible(true);
    }

    private void startTask() {
        if (worker != null && !worker.isDone()) {
            return; // 防止重复启动
        }
        startButton.setEnabled(false);
        progressBar.setValue(0);

        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(50);
                    setProgress(i);
                }
                return null;
            }

            @Override
            protected void done() {
                startButton.setEnabled(true);
                progressBar.setValue(100);
            }
        };

        worker.addPropertyChangeListener(evt -> {
            if ("progress".equals(evt.getPropertyName())) {
                progressBar.setValue((int) evt.getNewValue());
            }
        });

        worker.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProgressBarDemo::new);
    }
}