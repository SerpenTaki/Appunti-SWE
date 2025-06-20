package Strutturali.Proxy;

public class VideoProxy implements Video{ 
    private final String filePath;
    private RealVideo video;

    public VideoProxy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void reproduce() {
        byte[] bytes = null; // Using file path, retrieve the byte array from the filesystem
        this.video = new RealVideo(bytes);
        this.video.reproduce();
    }
}
