package ca.utoronto.ece1778.tripstory;

/**
 * Created by sssk9797 on 13/11/2016.
 */
public class StoryModel {

        String cardName;
        int imageResourceId;
        int isfav;
        int isturned;

        public int getIsturned() {
            return isturned;
        }

        public void setIsturned(int isturned) {
            this.isturned = isturned;
        }

        public int getIsfav() {
            return isfav;
        }

        public void setIsfav(int isfav) {
            this.isfav = isfav;
        }

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public int getImageResourceId() {
            return imageResourceId;
        }

        public void setImageResourceId(int imageResourceId) {
            this.imageResourceId = imageResourceId;
        }
    }
