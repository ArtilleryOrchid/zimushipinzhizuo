package com.keyi.zimushipinzhizuo.bean;

public class AppEntity {
    public VersionInfoVo versionInfoVo;
    public String accountId;
    public String token;
    public String isNew;

    public class VersionInfoVo {
        public String title;
        public String version;
        public String content;
        public String linkUrl;
        public boolean forceUp;
        public String mdConfig;
    }

    public class Data {
        public String productId;
        public double price;
        public double discountPrice;
        public String tag;
        public String productName;
        public String type;
        public int days;
        public String autoType;
    }

    public class Pay {
        public String type;
        public String desc;
    }

    public class Submit {
        public String resultCode;
        public String resultMsg;
        public String payInfo;
    }
}