package com.example.wun.testservlet.Bean;

/**
 * Created by WUN on 2018/3/8.
 */
import java.util.List;

public class OrderBean {

    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2017-10-19T20:28:43","orderid":20,"price":100,"status":2,"title":"订单标题测试3","uid":71},{"createtime":"2017-10-19T20:44:40","orderid":31,"price":11800,"status":2,"title":"订单标题测试14","uid":71},{"createtime":"2017-10-19T20:44:51","orderid":32,"price":11800,"status":2,"title":"订单标题测试15","uid":71},{"createtime":"2017-10-20T08:02:07","orderid":43,"price":11800,"status":2,"title":"订单标题测试","uid":71},{"createtime":"2017-10-20T08:02:16","orderid":44,"price":11800,"status":2,"title":"订单标题测试","uid":71},{"createtime":"2017-10-22T15:14:39","orderid":890,"price":11800,"status":2,"title":"","uid":71},{"createtime":"2017-11-09T09:17:20","orderid":1446,"price":99.99,"status":1,"title":"订单标题测试","uid":71},{"createtime":"2017-11-09T09:20:58","orderid":1447,"price":567,"status":2,"title":"订单标题测试","uid":71},{"createtime":"2017-11-09T09:20:58","orderid":1448,"price":256.99,"status":1,"title":"订单标题测试","uid":71},{"createtime":"2017-11-09T09:20:58","orderid":1449,"price":399,"status":2,"title":"订单标题测试","uid":71}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;

    private List<DataBean> data;

    //测试用
    private String OrderId;
    private String title;
    private int Icon;
    public OrderBean(String OrderId,String title,int Icon){
        this.OrderId=OrderId;
        this.title=title;
        this.Icon=Icon;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public static class DataBean {
        /**
         * createtime : 2017-10-19T20:28:43
         * orderid : 20
         * price : 100
         * status : 2
         * title : 订单标题测试3
         * uid : 71
         */

        private String createtime;
        private double orderid;
        private double price;
        private double status;
        private String title;
        private double uid;
        private double distance;
        private String kind;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public double getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public double getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }
    }
}