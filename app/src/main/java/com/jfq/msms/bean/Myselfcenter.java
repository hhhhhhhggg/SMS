package com.jfq.msms.bean;

/**
 * Created by Administrator on 2016.12.27.
 */

public class Myselfcenter {

    /**
     * ordinary : 普通会员
     * state : 0
     * text : 未开店
     * isSign : 2
     * adress_num : 0
     * integral_num : 30
     * photo : http://www.ysapp.cn/jifenqian/Public/Uploads/6299/585e23c999e24.png
     * name : 神之fys
     * cart_num : 0
     * not_pay : 0
     * pay : 0
     * is_agent : 0
     * pay_send : 0
     * refund : 0
     */

    private String ordinary;
    private int state;
    private String text;
    private int isSign;
    private String adress_num;
    private String integral_num;
    private String photo;
    private String name;
    private String cart_num;
    private int not_pay;
    private int pay;
    private int is_agent;
    private int pay_send;
    private int refund;

    public String getOrdinary() {
        return ordinary;
    }

    public void setOrdinary(String ordinary) {
        this.ordinary = ordinary;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIsSign() {
        return isSign;
    }

    public void setIsSign(int isSign) {
        this.isSign = isSign;
    }

    public String getAdress_num() {
        return adress_num;
    }

    public void setAdress_num(String adress_num) {
        this.adress_num = adress_num;
    }

    public String getIntegral_num() {
        return integral_num;
    }

    public void setIntegral_num(String integral_num) {
        this.integral_num = integral_num;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCart_num() {
        return cart_num;
    }

    public void setCart_num(String cart_num) {
        this.cart_num = cart_num;
    }

    public int getNot_pay() {
        return not_pay;
    }

    public void setNot_pay(int not_pay) {
        this.not_pay = not_pay;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getIs_agent() {
        return is_agent;
    }

    public void setIs_agent(int is_agent) {
        this.is_agent = is_agent;
    }

    public int getPay_send() {
        return pay_send;
    }

    public void setPay_send(int pay_send) {
        this.pay_send = pay_send;
    }

    public int getRefund() {
        return refund;
    }

    public void setRefund(int refund) {
        this.refund = refund;
    }
}
