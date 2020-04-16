package com.keyi.zimushipinzhizuo.utils;

import android.content.Context;
import android.graphics.Typeface;

import com.keyi.zimushipinzhizuo.bean.FintsPathInfo;

public class FintsUtils {

    private volatile static FintsUtils fintsUtils;
    private static Context mContext;

    private FintsUtils() {

    }

    public static FintsUtils getInstance(Context context) {
        mContext = context.getApplicationContext();
        if (fintsUtils == null) {
            synchronized (FintsUtils.class) {
                if (fintsUtils == null) {
                    fintsUtils = new FintsUtils();
                }
            }
        }
        return fintsUtils;
    }

    public Typeface getAaChaoMianJinFont() {
        return Typeface.createFromAsset(mContext.getAssets(), FintsPathInfo.AA_CHAO_MIAN_JIN);
    }

    public Typeface getAaXinHuaShuangJinTiFont() {
        return Typeface.createFromAsset(mContext.getAssets(), FintsPathInfo.AA_XIN_HUA_SHUANG_JIAN_TI);
    }
    public Typeface getAliHYAiHeiBetaFont() {
        return Typeface.createFromAsset(mContext.getAssets(), FintsPathInfo.ALI_HYAI_HEI_BETA);
    }
    public Typeface getGenRyuMinJpBoldFont() {
        return Typeface.createFromAsset(mContext.getAssets(), FintsPathInfo.GEN_RYU_MIN_JP_BOLD);
    }
    public Typeface getMuyaoSoftBrushFont() {
        return Typeface.createFromAsset(mContext.getAssets(), FintsPathInfo.MU_YAO_SOFTBRUSH);
    }
    public Typeface getSourceHanSansCnFont() {
        return Typeface.createFromAsset(mContext.getAssets(), FintsPathInfo.SOURCE_HAN_SANS_CN_BOLD);
    }
    public Typeface getTaiWanQuanZiKuZhengKaiTiFont() {
        return Typeface.createFromAsset(mContext.getAssets(), FintsPathInfo.TAI_WAN_QUAN_ZI_KU_ZENG_KAI_TI);
    }
    public Typeface getZhenKuKuHeiFont() {
        return Typeface.createFromAsset(mContext.getAssets(), FintsPathInfo.ZHAN_KU_KU_HEI);
    }

    public Typeface getSourceHanSansCNRegular() {
        return Typeface.createFromAsset(mContext.getAssets(), FintsPathInfo.SOURCE_HANSANS_CN_REGULAR);
    }
}
