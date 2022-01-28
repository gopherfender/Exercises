package Bowling;

import java.util.ArrayList;

public class Bowler {

    String name;
    ArrayList<Frame> frames = new ArrayList<>();

    public Bowler(String name) {
        this.name = name;
    }

    public void AddFrame(Frame frame) {
        this.frames.add(frame);
    }

    public int CurrentScore() {
        int score = 0;
        try {
            for (Frame frame : frames) {
                if (frame.frameType == "Normal") {
                    score += frame.frameValue;
                } else if (frame.frameType == "Spare") {
                    int nextFrame = frames.indexOf(frame) + 1;
                    int nextBallValue = frames.get(nextFrame).ball1;
                    score += frame.frameValue + nextBallValue;
                } else if (frame.frameType == "Strike") {
                    int nextFrame = frames.indexOf(frame) + 1;
                    if (frames.get(nextFrame).frameType == "Final Strike") {
                        score += frame.frameValue + frames.get(nextFrame).frameValue;                   
                    } else if 
                    (frames.get(nextFrame).frameType == "Strike") {
                        score += frame.frameValue + frames.get(nextFrame).frameValue + frames.get(nextFrame + 1).ball1;
                    } else {
                        score += frame.frameValue + frames.get(nextFrame).frameValue;
                    }
                }
            }
        } catch (IndexOutOfBoundsException ioob) {
        }
        return score;
    }
}
