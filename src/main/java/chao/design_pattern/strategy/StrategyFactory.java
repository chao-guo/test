package chao.design_pattern.strategy;

import java.util.HashMap;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/14 17:05:00
 */
public class StrategyFactory {

    private HashMap<String, Strategy> strategyHashMap;

    public StrategyFactory(HashMap<String, Strategy> strategyHashMap) {
        this.strategyHashMap = strategyHashMap;
    }

    public int executeStrategy(String strategy, int a, int b) {
        return strategyHashMap.get(strategy).doOperation(a, b);
    }
}
