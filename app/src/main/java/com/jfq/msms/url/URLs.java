package com.jfq.msms.url;

/**
 * Created by Administrator on 2016.12.27.
 */

public class URLs {

    /**
     * 拼接方式：基本地址+类型基本地址+具体内容
     */

    public static final String BASE_URL = "http://www.ysapp.cn/jifenqian/api.php";//基本地址


    //类型基本地址
    public static final String USER = "/User";//用户基本地址
    public static final String MALL = "/Mall";//购物主页基本地址
    public static final String SET = "/Set";//设置基本地址



     //以下使用用户基本地址拼接
    public static final String MY_SELF = "/personal";//个人信息
    public static final String LOGIN = "/login";//登录
    public static final String SHOPPING_ADDRESS = "/getAddressList";//收货地址
    public static final String CITY = "/getCityList";//所在区域
    public static final String ADD_ADDRESS = "/addressadd";//添加地址
    public static final String SOLID_SHOP = "/authentication";//实体店铺
    public static final String SHOP_INTRODUCTION = "/users_info";//店铺简介
    public static final String VERIFYCOD = "/Send_code";//得到验证码
    public static final String CHANGEPASSWORD = "/recoverPass";//修改密码


    //以下使用购物页面基本地址拼接
    public static final String CLASSIFY = "/homeCategory";//分类
    public static final String HOME = "/homeRecommend";//主页
    public static final String HOME_BANNER = "/homeBanner";//主页广告
    public static final String HOME_TITLE = "/homeLanmu";//主页标题栏
    public static final String PRODUCTDETAIL = "/productDetail";//物品具体内容
    public static final String SHOPPING_CAR = "/cartList";//购物车
    public static final String SHOPPING_MALL = "/productList1";//购物商城
    public static final String INTEGRAL_MALL = "/productList2";//积分商城
    public static final String SHOPPING_MALL_SEEK = "/productSearch1";//购物商城搜索
    public static final String INTEGRAL_MALL_SEEK= "/productSearch2";//积分商城搜索
    public static final String ORDER= "/orderList";//订单


    //以下使用设置基本地址拼接
    public static final String SIGN = "/sign";//签到积分
    public static final String ACTION = "/actList";//活动
    public static final String ABUOTALL = "/aboutAll";//平台动态
    public static final String ABUOTALL_SHOW = "/aboutShow";//平台动态选项内容
    public static final String ISSIGN = "/isSign";//签到
    public static final String INTEGRALINCOME = "/integralIncome";//积分收入明细
    public static final String INTEGRALEXPEND = "/integralExpenditure";//积分支出明细
}
