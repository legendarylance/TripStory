package ca.utoronto.ece1778.tripstory;

import io.realm.RealmObject;

/**
 * Created by sssk9797 on 30/10/2016.
 */
public class JSONCreator extends RealmObject {
    private int frame;
    private String framePic;
    private String question;
    private String statement;
    private String im1;
    private String im2;
    private String im3;
    private String im4;
    private String im5;
    private String im6;


    public String getIm1() {
        return im1;
    }
    public String getIm2() {
        return im2;
    }
    public String getIm3() {
        return im3;
    }
    public String getIm4() {
        return im4;
    }
    public String getIm5() {
        return im5;
    }
    public String getIm6() {
        return im6;
    }

    public int getFrame() { return frame; }
    public String getFramePic() { return framePic; }
    public String getQuestion() { return question; }
    public String getStatement() { return statement; }
}

