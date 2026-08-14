package com.heaven7.algo;

import java.util.*;

/**
 * 影响因素传播算法 Demo
 * 依赖关系：
 * A -> B, A -> C
 * C -> E, D -> E
 * E -> B, E -> A
 */
public class InfluencePropagation {

    // 因素枚举
    enum Factor { A, B, C, D, E, F }

    // 边对象，包含目标节点和影响权重
    static class Edge {
        Factor target;
        double weight;

        Edge(Factor target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // 算法参数
    private static final double EPSILON = 0.001;   // 增量忽略阈值
    private static final int MAX_STEPS = 30;       // 最大传播轮数
    private static final double DEFAULT_WEIGHT = 0.6; // 默认影响权重（可自定义）

    public static void main(String[] args) {
        // 1. 构建图（邻接表）
        Map<Factor, List<Edge>> graph = new HashMap<>();
        for (Factor f : Factor.values()) {
            graph.put(f, new ArrayList<>());
        }

        // 根据题目描述添加有向边（权重设为 0.6，可调整）
        graph.get(Factor.A).add(new Edge(Factor.B, 0.6));
        graph.get(Factor.A).add(new Edge(Factor.C, 0.6));
        graph.get(Factor.C).add(new Edge(Factor.E, 0.6));
        graph.get(Factor.D).add(new Edge(Factor.E, 0.6));
        graph.get(Factor.E).add(new Edge(Factor.B, 0.6));
        graph.get(Factor.E).add(new Edge(Factor.A, 0.6));

        // 2. 初始化所有节点的值
        Map<Factor, Double> values = new HashMap<>();
        for (Factor f : Factor.values()) {
            values.put(f, 0.0);
        }

        // 假设初始影响力由 A 触发（可视为外部注入）
        Factor source = Factor.A;
        double initialValue = 100.0;
        values.put(source, initialValue);

        // 3. 工作列表（队列）传播
        Queue<Factor> queue = new LinkedList<>();
        Set<Factor> inQueue = new HashSet<>(); // 去重

        queue.add(source);
        inQueue.add(source);

        int steps = 0;
        while (!queue.isEmpty() && steps < MAX_STEPS) {
            Factor curr = queue.poll();
            inQueue.remove(curr);

            double currVal = values.get(curr);
            // 如果当前值已经很小，则不再传播（节省计算）
            if (Math.abs(currVal) < EPSILON) continue;

            for (Edge edge : graph.get(curr)) {
                Factor next = edge.target;
                double delta = currVal * edge.weight;

                if (Math.abs(delta) < EPSILON) continue;

                // 累加影响
                values.put(next, values.get(next) + delta);

                // 如果后继节点不在队列中，则加入队列
                if (!inQueue.contains(next)) {
                    queue.add(next);
                    inQueue.add(next);
                }
            }
            steps++;
        }

        // 4. 输出结果
        System.out.println("经过 " + steps + " 轮传播后各因素的影响值（权重=" + DEFAULT_WEIGHT + "）：");
        for (Factor f : Factor.values()) {
            System.out.printf("%s : %.4f\n", f, values.get(f));
        }

        // 额外说明：若改变权重或增加外部输入，只需调整相应边的权重或初始值即可。
    }
}