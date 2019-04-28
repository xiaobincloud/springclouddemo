package com.cloud.base.utils;

public interface SysConstant {

    /** 用户类型 后台管理用户*/
    Integer USER_MANAGER=1;
    /** 用户类型 会员用户 */
    Integer USER_MEMBER=2;
    /**
     * 默认分页数量
     */
    Integer DEFAULT_SIZE = 10;

    String ENCODING="UTF-8";

    /**
     * 默认排序字段
     */
    String SORT_PROPERTIES = "createTime";

    /**
     * 格式化字符串
     */
    String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式化字符串
     */
    String YYYY_MM_DD = "yyyy-MM-dd";

    String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    String MMDD = "MM/dd";
    /**
     * 格式化字符串
     */
    String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    String HH_MM = "HH:mm";

    String HH_MM_SS = "HH:mm:ss";
    /**
     * 服务接口版本
     */
    String AMC_SERVER_VERSION = "v1.0";
    /**
     * 前缀
     */
    String ROLE_PREFIX = "ROLE_";

    /**
     * OUT_EXCEL_TITLES:导出Excel 表头 标题
     */
    String OUT_EXCEL_TITLES = "OUT_EXCEL_TITLES";

    /**
     * OUT_EXCEL_TITLES:导出Excel 数据
     */
    String OUT_EXCEL_DATA = "OUT_EXCEL_DATA";

    /**
     * EXCEL_TITLE 文件名称
     */
    String OUT_EXCEL_TITLE = "OUT_EXCEL_TITLE";

    /**
     * 毫秒
     */
    long MILLISECOND = 1000;

    /**
     * 秒
     */
    Integer CHECK_TIME = 60;

    /**
     * 取WGS84标准参考椭球中的地球长半径
     */
    Double WGS84 = 6378.137;
    /**
     * 超级管理员角色名称
     */
    String ADMIN_ROLE_NAME = "admin";
    /**
     * 不满足取消课程并退款
     */
    int REFUND = 1;
    /**
     * 预约人数不足不取消课程
     */
    int UN_REFUND = 0;
    /**
     * 毫秒转秒
     */
    long MS = 1000;
    /**
     * 秒转分
     */
    long MM = 60;
    /**
     * 一周7天
     */
    int WEEK_COUNT = 7;
    /**
     * 一天24小时
     */
    int DAY_HOUR_COUNT = 24;
    /**
     * 一小时3600000毫秒
     */
    int HOUR_MSEL_COUNT = 3600000;

//    Date OPEN_TIME=UlinkcareDataFormatUtils.string2date("10:00:00",HH_MM_SS);


//    Date CLOSE_TIME=UlinkcareDataFormatUtils.string2date("21:30:00",HH_MM_SS);

    /**
     * 微信端用户取值sessionkey
     */
    String FITNESS_USER_SESSION_KEY = "fitness";
    /**
     * 微信端用户ID取值sessionkey
     */
    String FITNESS_USER_ID_SESSION_KEY = "fitnessUserId";
    /**
     *  结束时间串
     */
    String END_TIME_STRING = "endTimeString";
    /**
     * 体测仪型号
     */
    String MODELS = "models";
    /**
     * 访问路径
     */
    String PARAM_URL = "paramUrl";

    String UNKNOWN = "unknown";
}
