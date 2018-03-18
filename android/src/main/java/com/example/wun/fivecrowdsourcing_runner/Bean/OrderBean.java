package com.example.wun.fivecrowdsourcing_runner.Bean;

/**
 * Created by WUN on 2018/3/8.
 */

public class OrderBean {

    /**
     * msg : 请求成功
     * status: 0
     * data : [{"createtime":"2017-10-19T20:28:43","orderid":20,"price":100,"status":2,"title":"订单标题测试3","uid":71},{"createtime":"2017-10-19T20:44:40","orderid":31,"price":11800,"status":2,"title":"订单标题测试14","uid":71},{"createtime":"2017-10-19T20:44:51","orderid":32,"price":11800,"status":2,"title":"订单标题测试15","uid":71},{"createtime":"2017-10-20T08:02:07","orderid":43,"price":11800,"status":2,"title":"订单标题测试","uid":71},{"createtime":"2017-10-20T08:02:16","orderid":44,"price":11800,"status":2,"title":"订单标题测试","uid":71},{"createtime":"2017-10-22T15:14:39","orderid":890,"price":11800,"status":2,"title":"","uid":71},{"createtime":"2017-11-09T09:17:20","orderid":1446,"price":99.99,"status":1,"title":"订单标题测试","uid":71},{"createtime":"2017-11-09T09:20:58","orderid":1447,"price":567,"status":2,"title":"订单标题测试","uid":71},{"createtime":"2017-11-09T09:20:58","orderid":1448,"price":256.99,"status":1,"title":"订单标题测试","uid":71},{"createtime":"2017-11-09T09:20:58","orderid":1449,"price":399,"status":2,"title":"订单标题测试","uid":71}]
     * page : 1
     */

    private String msg;

    private String title;
    private int Icon;
    private short status; //状态：1：新建；2：待抢单；3：待取单；4：配送中；5：配送完成

    private int delOrderId;  //配送单id

    private int merchantId;  //商户id
    private int delMethodId; //配送方式id
    private int estimatedTime;   //预估时间
    private int estimatedTotalPrice;    //预估总价
    private Long runnerId;   //跑腿人id
    private String inTime; //接单时间
    private String outTime; //送达时间
    private int extraPrice; //加价费
    private int trueWeight; //真实质量
    private int creditPoints;    //信用分
    private int integral;   //积分
    private String orderTime;   //下单时间
    private String cusName; //客户名
    private String cusPhone; //客户电话
    private String cusAddress;  //客户地址
    private String things;  //内容

    public OrderBean(){}

    public OrderBean(int delOrderId, String title, int Icon)
    {
        this.delOrderId=delOrderId;
        this.Icon=Icon;
        this.title=title;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public int getDelOrderId() {
        return delOrderId;
    }

    public void setDelOrderId(int delOrderId) {
        this.delOrderId = delOrderId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getDelMethodId() {
        return delMethodId;
    }

    public void setDelMethodId(int delMethodId) {
        this.delMethodId = delMethodId;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getEstimatedTotalPrice() {
        return estimatedTotalPrice;
    }

    public void setEstimatedTotalPrice(int estimatedTotalPrice) {
        this.estimatedTotalPrice = estimatedTotalPrice;
    }

    public Long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public int getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(int extraPrice) {
        this.extraPrice = extraPrice;
    }

    public int getTrueWeight() {
        return trueWeight;
    }

    public void setTrueWeight(int trueWeight) {
        this.trueWeight = trueWeight;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }


}

