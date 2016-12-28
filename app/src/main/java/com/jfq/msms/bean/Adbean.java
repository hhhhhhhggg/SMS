package com.jfq.msms.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */

public class Adbean {
    /**
     * flag : 0
     * msg : 操作成功
     * data : [{"id":"38","name":"1","pic":"http://www.ysapp.cn/jifenqian/Public/Uploads/images/20161202/5840dbd8dcdec.jpg","type1":"10","product_id":"0","act_id":"0","url":""},{"id":"37","name":"7","pic":"http://www.ysapp.cn/jifenqian/Public/Uploads/images/20161202/5840dbcd1e841.jpg","type1":"1","product_id":"2777","act_id":"0","url":""},{"id":"36","name":"11","pic":"http://www.ysapp.cn/jifenqian/Public/Uploads/images/20161206/58466c160a1f2.jpg","type1":"1","product_id":"2625","act_id":"0","url":""},{"id":"33","name":"吖吖","pic":"http://www.ysapp.cn/jifenqian/Public/Uploads/images/20161207/58477e83695bb.jpg","type1":"1","product_id":"2649","act_id":"0","url":""},{"id":"32","name":"九寨沟","pic":"http://www.ysapp.cn/jifenqian/Public/Uploads/images/20161206/58467bffe68a3.jpg","type1":"4","product_id":"0","act_id":"0","url":"http://mp.weixin.qq.com/s/n2-A29laHmASE54gAY1Iog"},{"id":"18","name":"..","pic":"http://www.ysapp.cn/jifenqian/Public/Uploads/images/20160928/57eb2098ea16c.jpg","type1":"10","product_id":"167","act_id":"0","url":"http://mp.weixin.qq.com/s?__biz=MzI3NTQ0MDUxOQ==&mid=2247483666&idx=1&sn=81bf8ae59087a2e"}]
     */

    private int flag;
    private String msg;
    private List<DataBean> data;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 38
         * name : 1
         * pic : http://www.ysapp.cn/jifenqian/Public/Uploads/images/20161202/5840dbd8dcdec.jpg
         * type1 : 10
         * product_id : 0
         * act_id : 0
         * url :
         */

        private String id;
        private String name;
        private String pic;
        private String type1;
        private String product_id;
        private String act_id;
        private String url;

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

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getType1() {
            return type1;
        }

        public void setType1(String type1) {
            this.type1 = type1;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getAct_id() {
            return act_id;
        }

        public void setAct_id(String act_id) {
            this.act_id = act_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
