package com.keyi.zimushipinzhizuo.bean;

import com.huopaolan.lib_core.Base.BaseEntity;

public class AppEntity {
    public VersionInfoVo versionInfoVo;

    public static class VersionInfoVo {
        public String title;
        public String version;
        public String content;
        public String linkUrl;
        public boolean forceUp;
        public String mdConfig;
    }
}