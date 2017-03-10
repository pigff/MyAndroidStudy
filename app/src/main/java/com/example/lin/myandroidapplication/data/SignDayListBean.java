package com.example.lin.myandroidapplication.data;

import java.io.Serializable;

/**
 * Created by lin on 2017/3/10.
 */

public class SignDayListBean {

    private SignDayBean signDay;
    private boolean signed;
    private boolean prize;


    public SignDayBean getSignDay() {
        return signDay;
    }

    public void setSignDay(SignDayBean signDay) {
        this.signDay = signDay;
    }

    public boolean isPrize() {
        return prize;
    }

    public void setPrize(boolean prize) {
        this.prize = prize;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }


    public static class SignDayBean implements Serializable {
        private int probability;
        private int signDayId;
        private String signDayValue;
        private int signIntegral;
        private int signMonthId;

        public int getProbability() {
            return probability;
        }

        public void setProbability(int probability) {
            this.probability = probability;
        }

        public int getSignDayId() {
            return signDayId;
        }

        public void setSignDayId(int signDayId) {
            this.signDayId = signDayId;
        }

        public String getSignDayValue() {
            return signDayValue;
        }

        public void setSignDayValue(String signDayValue) {
            this.signDayValue = signDayValue;
        }

        public int getSignIntegral() {
            return signIntegral;
        }

        public void setSignIntegral(int signIntegral) {
            this.signIntegral = signIntegral;
        }

        public int getSignMonthId() {
            return signMonthId;
        }

        public void setSignMonthId(int signMonthId) {
            this.signMonthId = signMonthId;
        }
    }


}
