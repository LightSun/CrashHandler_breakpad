package com.heaven7.algo;

import java.util.*;

/**
 假设影响某件事情的因素有A，B,C,D,E,F 6个。其中A可能会影响B和C，C可能会影响D和E， E可能会影响F和A，
 请设计一个算法，满足这种需求，并给出java 或者c++ 的demo.
 */
public class InfluencePropagation1 {

    // 定义因素枚举
    enum Factor { A, B, C, D, E, F }

    // 影响衰减系数（每次传播乘以该系数，模拟能量损耗）
    private static final double DECAY = 0.5;
    // 收敛阈值，增量小于该值则忽略
    private static final double EPSILON = 0.001;
    // 最大迭代步数（防止因环导致死循环）
    private static final int MAX_STEPS = 20;

    public static void main(String[] args) {
        // 1. 构建有向图（邻接表）
        Map<Factor, List<Factor>> graph = new HashMap<>();
        // 初始化所有节点的邻接表，防止空指针
        for (Factor f : Factor.values()) {
            graph.put(f, new ArrayList<>());
        }
        // 根据题目要求添加边
        graph.get(Factor.A).add(Factor.B);
        graph.get(Factor.A).add(Factor.C);
        graph.get(Factor.C).add(Factor.D);
        graph.get(Factor.C).add(Factor.E);
        graph.get(Factor.E).add(Factor.F);
        graph.get(Factor.E).add(Factor.A); // 形成环 A->C->E->A

        // 2. 初始化节点值
        Map<Factor, Double> values = new HashMap<>();
        for (Factor f : Factor.values()) {
            values.put(f, 0.0);
        }

        // 假设初始影响由 A 发起，初始值为 100
        Factor source = Factor.A;
        values.put(source, 100.0);

        // 3. 工作列表算法（队列传播）
        Queue<Factor> queue = new LinkedList<>();
        Set<Factor> inQueue = new HashSet<>(); // 去重，避免队列重复挤压

        queue.add(source);
        inQueue.add(source);

        int steps = 0;
        while (!queue.isEmpty() && steps < MAX_STEPS) {
            Factor curr = queue.poll();
            inQueue.remove(curr);

            double currVal = values.get(curr);
            // 如果当前值太小，没必要继续传播（提升效率）
            if (Math.abs(currVal) < EPSILON) continue;

            for (Factor next : graph.get(curr)) {
                // 计算影响增量：当前值 * 衰减系数
                double delta = currVal * DECAY;

                // 如果增量足够小，忽略此次传播
                if (Math.abs(delta) < EPSILON) continue;

                // 更新后继节点的值
                double newVal = values.get(next) + delta;
                values.put(next, newVal);

                // 如果后继节点不在队列中，则加入队列等待处理
                if (!inQueue.contains(next)) {
                    queue.add(next);
                    inQueue.add(next);
                }
            }
            steps++;
        }

        // 4. 输出最终结果
        System.out.println("经过 " + steps + " 轮传播后的影响值：");
        for (Factor f : Factor.values()) {
            System.out.printf("%s : %.4f\n", f, values.get(f));
        }
    }
}