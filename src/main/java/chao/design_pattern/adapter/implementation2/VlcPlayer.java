package chao.design_pattern.adapter.implementation2;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName VlcPlayer.java
 * @Description TODO
 * @createTime 2020年06月15日 14:30:00
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name:" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //do nothing
    }
}
