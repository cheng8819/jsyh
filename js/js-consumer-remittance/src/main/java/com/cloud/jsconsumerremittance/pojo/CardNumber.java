package com.cloud.jsconsumerremittance.pojo;




public class CardNumber {
    private int cardnumberid;
    private String carenumbername;
    private String carenumbermark;
    private Double money;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getCardnumberid() {
        return cardnumberid;
    }

    public void setCardnumberid(int cardnumberid) {
        this.cardnumberid = cardnumberid;
    }

    public String getCarenumbername() {
        return carenumbername;
    }

    public void setCarenumbername(String carenumbername) {
        this.carenumbername = carenumbername;
    }

    public String getCarenumbermark() {
        return carenumbermark;
    }

    public void setCarenumbermark(String carenumbermark) {
        this.carenumbermark = carenumbermark;
    }
}
