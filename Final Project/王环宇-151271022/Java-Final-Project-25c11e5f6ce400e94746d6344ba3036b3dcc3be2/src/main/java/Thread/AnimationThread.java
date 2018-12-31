package Thread;

import Animation.MyAnimation;

public class AnimationThread extends Thread {
    public MyAnimation animation;
    public AnimationThread(MyAnimation animation){
        this.animation = animation;
    }
    @Override
    public void start(){
        animation.run();
    }
}
