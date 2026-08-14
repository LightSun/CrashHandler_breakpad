package com.heaven7.gui.temp;

import javax.swing.*;
import java.awt.*;

/**
 * 演示 CardLayout：在同一区域切换不同面板，隐藏的面板不占用空间。
 */
public class CardLayoutDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("CardLayout 示例");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // 1. 创建 CardLayout 容器
            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel(cardLayout);

            // 2. 创建卡片1：包含 Box 和多个子组件
            Box boxPanel = Box.createVerticalBox();
            boxPanel.setBackground(Color.LIGHT_GRAY);
            boxPanel.setOpaque(true);
            boxPanel.add(new JLabel("这是卡片1 (Box)"));
            boxPanel.add(Box.createVerticalStrut(10));
            boxPanel.add(new JButton("按钮A"));
            boxPanel.add(new JButton("按钮B"));
            boxPanel.add(Box.createVerticalStrut(20));
            boxPanel.add(new JTextField("文本框", 10));
            // 添加边框便于观察
            boxPanel.setBorder(BorderFactory.createTitledBorder("Box 卡片"));

            // 3. 创建卡片2：一个空白面板（或替代内容）
            JPanel emptyPanel = new JPanel();
            emptyPanel.setBackground(Color.WHITE);
            emptyPanel.add(new JLabel("这是卡片2 (空白)"));
            emptyPanel.setBorder(BorderFactory.createTitledBorder("空白卡片"));

            // 4. 将卡片加入 cardPanel，并指定名称
            cardPanel.add(boxPanel, "card1");
            cardPanel.add(emptyPanel, "card2");

            // 5. 控制区：显示当前卡片名称 + 切换按钮
            JPanel controlPanel = new JPanel(new FlowLayout());
            JLabel statusLabel = new JLabel("当前卡片: card1");
            JButton switchButton = new JButton("切换至 card2");

            // 切换逻辑
            switchButton.addActionListener(e -> {
                // 轮流切换
                if (cardPanel.getComponent(0).isVisible()) {
                    cardLayout.show(cardPanel, "card2");
                    switchButton.setText("切换至 card1");
                    statusLabel.setText("当前卡片: card2");
                } else {
                    cardLayout.show(cardPanel, "card1");
                    switchButton.setText("切换至 card2");
                    statusLabel.setText("当前卡片: card1");
                }
                // 可选：强制刷新（show 内部已处理，但显式调用更安全）
                cardPanel.revalidate();
                cardPanel.repaint();
            });

            controlPanel.add(statusLabel);
            controlPanel.add(switchButton);

            // 6. 组装界面
            frame.add(cardPanel, BorderLayout.CENTER);
            frame.add(controlPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}