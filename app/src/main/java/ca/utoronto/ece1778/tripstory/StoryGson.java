package ca.utoronto.ece1778.tripstory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoryGson {

    @SerializedName("story")
    @Expose
    private String story;
    @SerializedName("btn_1")
    @Expose
    private String btn1;
    @SerializedName("btn_2")
    @Expose
    private String btn2;
    @SerializedName("btn_3")
    @Expose
    private String btn3;
    @SerializedName("btn_4")
    @Expose
    private String btn4;
    @SerializedName("btn_5")
    @Expose
    private String btn5;
    @SerializedName("btn_6")
    @Expose
    private String btn6;

    /**
     *
     * @return
     * The story
     */
    public String getStory() {
        return story;
    }

    /**
     *
     * @param story
     * The story
     */
    public void setStory(String story) {
        this.story = story;
    }

    /**
     *
     * @return
     * The btn1
     */
    public String getBtn1() {
        return btn1;
    }

    /**
     *
     * @param btn1
     * The btn_1
     */
    public void setBtn1(String btn1) {
        this.btn1 = btn1;
    }

    /**
     *
     * @return
     * The btn2
     */
    public String getBtn2() {
        return btn2;
    }

    /**
     *
     * @param btn2
     * The btn_2
     */
    public void setBtn2(String btn2) {
        this.btn2 = btn2;
    }

    /**
     *
     * @return
     * The btn3
     */
    public String getBtn3() {
        return btn3;
    }

    /**
     *
     * @param btn3
     * The btn_3
     */
    public void setBtn3(String btn3) {
        this.btn3 = btn3;
    }

    /**
     *
     * @return
     * The btn4
     */
    public String getBtn4() {
        return btn4;
    }

    /**
     *
     * @param btn4
     * The btn_4
     */
    public void setBtn4(String btn4) {
        this.btn4 = btn4;
    }

    /**
     *
     * @return
     * The btn5
     */
    public String getBtn5() {
        return btn5;
    }

    /**
     *
     * @param btn5
     * The btn_5
     */
    public void setBtn5(String btn5) {
        this.btn5 = btn5;
    }

    /**
     *
     * @return
     * The btn6
     */
    public String getBtn6() {
        return btn6;
    }

    /**
     *
     * @param btn6
     * The btn_6
     */
    public void setBtn6(String btn6) {
        this.btn6 = btn6;
    }

}