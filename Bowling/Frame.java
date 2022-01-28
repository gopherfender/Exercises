package Bowling;
public class Frame {

    int frameValue;
    String frameType;
    int ball1;
    int ball2;

public Frame(int ball1, int ball2) {
    this.ball1 = ball1;
    this.ball2 = ball2;

    if (this.ball1 == 10) {
        this.frameType = "Strike";
        this.frameValue = 10;
    } else if (ball1 + ball2 == 10) {
        this.frameType = "Spare";
        this.frameValue = 10;
    } else {
        this.frameType = "Normal";
        this.frameValue = ball1 + ball2;
    }
}
}
