package Bowling;

public class FinalFrame extends Frame{

    int ball3 = 0;
    
    public FinalFrame(int ball1, int ball2, int ball3) {
        super(ball1, ball2);
        this.ball3 = ball3;

        if (this.ball1 == 10) {
            this.frameType = "Final Strike";
        } else if (ball1 + ball2 == 10) {
            this.frameType = "Spare";
        } else {
            this.frameType = "Normal";          
        }
        this.frameValue = ball1 + ball2 + ball3;

    }
}
