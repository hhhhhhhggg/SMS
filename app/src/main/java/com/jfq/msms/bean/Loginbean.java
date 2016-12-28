package com.jfq.msms.bean;

/**
 * Created by Administrator on 2016.12.28.
 */

public class Loginbean {

    /**
     * flag : 3
     * msg : 登录成功
     * data : {"id":"6299","name":"神之fys","integral":"30","tel":"13689099132","phone":"028-85125251","head":"http://www.ysapp.cn/jifenqian/Public/Uploads/6299/585e23c999e24.png","token":"e931a1457040b88555c40eadb92649d7"}
     */

    private String flag;
    private String msg;
    private DataBean data;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 6299
         * name : 神之fys
         * integral : 30
         * tel : 13689099132
         * phone : 028-85125251
         * head : http://www.ysapp.cn/jifenqian/Public/Uploads/6299/585e23c999e24.png
         * token : e931a1457040b88555c40eadb92649d7
         */

        private String id;
        private String name;
        private String integral;
        private String tel;
        private String phone;
        private String head;
        private String token;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
