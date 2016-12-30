package com.jfq.msms.bean;

import java.io.Serializable;

/**
 * Created by lyp13 on 2016/12/29.
 * Mode会员商城实体类
 */

public class Mode implements Serializable{
        /**
         * product_id : 138
         * name : 标致4008（进口）2.0L两驱时尚型
         * headpic : http://www.ysapp.cn/jifenqian/Public/Uploads/images/20160824/20160824201313_58686.jpg
         * pricex : 219800.00
         * pricey : 0.00
         * sale : 12
         * is_integral : 2
         * integral : 219800
         */

        private String product_id;
        private String name;
        private String headpic;
        private String pricex;
        private String pricey;
        private String sale;
        private String is_integral;
        private int integral;

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeadpic() {
            return headpic;
        }

        public void setHeadpic(String headpic) {
            this.headpic = headpic;
        }

        public String getPricex() {
            return pricex;
        }

        public void setPricex(String pricex) {
            this.pricex = pricex;
        }

        public String getPricey() {
            return pricey;
        }

        public void setPricey(String pricey) {
            this.pricey = pricey;
        }

        public String getSale() {
            return sale;
        }

        public void setSale(String sale) {
            this.sale = sale;
        }

        public String getIs_integral() {
            return is_integral;
        }

        public void setIs_integral(String is_integral) {
            this.is_integral = is_integral;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }
    }
