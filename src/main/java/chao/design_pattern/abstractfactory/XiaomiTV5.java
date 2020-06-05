package chao.design_pattern.abstractfactory;

public class XiaomiTV5 implements Television {

    @Override
    public void play(String tvShow) {
        System.out.println("XiaomiTV5播放节目：" + tvShow);
    }
}
