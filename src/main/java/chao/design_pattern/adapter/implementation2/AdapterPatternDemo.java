package chao.design_pattern.adapter.implementation2;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName AdapterPatternDemo.java
 * @Description TODO
 * @createTime 2020年06月15日 14:56:00
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
