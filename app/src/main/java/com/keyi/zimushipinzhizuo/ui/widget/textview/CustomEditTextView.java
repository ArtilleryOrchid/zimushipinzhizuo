package com.keyi.zimushipinzhizuo.ui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.bean.FintsPathInfo;
import com.keyi.zimushipinzhizuo.utils.FintsUtils;

public class CustomEditTextView extends AppCompatEditText {

    public CustomEditTextView(Context context) {
        super(context);
    }

    public CustomEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomEditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {
        Typeface typeface = null;
        if (!isInEditMode()) {
            if (null != attrs) {
                TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
                typeface = typefaceFromAttrs(context, a);
                a.recycle();
            }
            if (typeface == null) {
                typeface = Typeface.DEFAULT;
            }
            setTypeface(typeface);
        }
    }

    private Typeface typefaceFromAttrs(Context context, TypedArray a) {
        Typeface typeface = null;

        if (a.hasValue(R.styleable.CustomTextView_typeface)) {
            int typeFaceValue = a.getInt(R.styleable.CustomTextView_typeface, FintsPathInfo.DEFAULT_TEXT_FINT_ATTRS);
            switch (typeFaceValue) {
                case FintsPathInfo.DEFAULT_TEXT_FINT_ATTRS :
                    typeface = Typeface.DEFAULT;
                    break;
                case FintsPathInfo.AA_CHAO_MIAN_JIN_ATTRS :
                    typeface = FintsUtils.getInstance(context).getAaChaoMianJinFont();
                    break;
                case FintsPathInfo.AA_XIN_HUA_SHUANG_JIAN_TI_ATTRS :
                    typeface = FintsUtils.getInstance(context).getAaXinHuaShuangJinTiFont();
                    break;
                case FintsPathInfo.ALI_HYAI_HEI_BETA_ATTRS :
                    typeface = FintsUtils.getInstance(context).getAliHYAiHeiBetaFont();
                    break;
                case FintsPathInfo.GEN_RYU_MIN_JP_BOLD_ATTRS :
                    typeface = FintsUtils.getInstance(context).getGenRyuMinJpBoldFont();
                    break;
                case FintsPathInfo.MU_YAO_SOFTBRUSH_ATTRS :
                    typeface = FintsUtils.getInstance(context).getMuyaoSoftBrushFont();
                    break;
                case FintsPathInfo.SOURCE_HAN_SANS_CN_BOLD_ATTRS :
                    typeface = FintsUtils.getInstance(context).getSourceHanSansCnBoldFont();
                    break;
                case FintsPathInfo.SOURCE_HANSANS_CN_REGULAR_ATTRS :
                    typeface = FintsUtils.getInstance(context).getSourceHanSansCNRegular();
                    break;
                case FintsPathInfo.TAI_WAN_QUAN_ZI_KU_ZENG_KAI_TI_ATTRS :
                    typeface = FintsUtils.getInstance(context).getTaiWanQuanZiKuZhengKaiTiFont();
                    break;
                case FintsPathInfo.ZHAN_KU_KU_HEI_ATTRS :
                    typeface = FintsUtils.getInstance(context).getZhenKuKuHeiFont();
                    break;
                case FintsPathInfo.SOURCE_HAN_SANS_CN_MEDIUM_ATTRS:
                    typeface = FintsUtils.getInstance(context).getSourceHanSansCNMedium();
                    break;
            }
        }

        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }

        return typeface;
    }

}
