package chao.design_pattern.adapter.implementation2;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Mp4Player.java
 * @Description TODO
 * @createTime 2020年06月15日 14:32:00
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name:" + fileName);
    }
}
