package com.cy.tabrv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by leifeng on 2018/8/2.
 */

public class CYTabLayout extends HorizontalScrollView {
    private Context context;

    private int postion_current = 0;

    private LinearLayout linearLayout;

    private GradientDrawable view_indicator;

    private OnTabSelectListener onTabSelectListener;

    private int width_indicator = 30;
    private int height_indicator = 10;
    public static  final int FIXED=0;
    public static  final  int SCROLLABLE=1;

    private int tabMode=0;

    public CYTabLayout(Context context) {
        this(context, null);
    }

    public CYTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setOverScrollMode(View.OVER_SCROLL_NEVER);
        setScrollBarSize(0);


        linearLayout = new LinearLayout(context);

        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        HorizontalScrollView.LayoutParams layoutParams2 = new HorizontalScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        linearLayout.setLayoutParams(layoutParams2);
        addView(linearLayout);

        view_indicator = new GradientDrawable();

        view_indicator.setColor(0xffffff00);

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.CYTabLayout);
        width_indicator = arr.getDimensionPixelSize(R.styleable.CYTabLayout_width_indicator, 0);
        height_indicator = arr.getDimensionPixelSize(R.styleable.CYTabLayout_height_indicator, 0);

        float cornerRadius=arr.getFloat(R.styleable.CYTabLayout_cornerRadius_indicator,0);
        view_indicator.setCornerRadius(cornerRadius);

        if (width_indicator==0){
            width_indicator=30;
        }
        if (height_indicator==0){
            height_indicator=10;
        }

    }

    public void setTabMode(int tabMode){
        this.tabMode=tabMode;

        if (linearLayout.getChildCount()==0){
            return;
        }
        int count_child=linearLayout.getChildCount();
        for (int i=0;i<count_child;i++){
            /** 每一个Tab的布局参数 */
            LinearLayout.LayoutParams layoutParams = tabMode==0 ?
                    new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1.0f) :
                    new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            linearLayout.getChildAt(i).setLayoutParams(layoutParams);
        }
        invalidate();


    }
    public void addTab(final View view) {


        /** 每一个Tab的布局参数 */
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1.0f) ;

        linearLayout.addView(view,layoutParams);

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                if (postion_current == linearLayout.indexOfChild(view)) {
                    if (onTabSelectListener != null) {
                        onTabSelectListener.onTabReselect(linearLayout.indexOfChild(view));

                    }

                    return;
                }

                postion_current = linearLayout.indexOfChild(view);


                int scrollX_now = view.getLeft();
                scrollX_now -= getWidth() / 2 - getPaddingLeft();


                smoothScrollTo(scrollX_now, 0);

                invalidate();

                if (onTabSelectListener != null) {
                    onTabSelectListener.onTabSelect(linearLayout.indexOfChild(view));
                }

            }
        });


        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        View view_current = (TextView) linearLayout.getChildAt(postion_current);


        int left_indicator = view_current.getLeft() + view_current.getPaddingLeft();

        int right_indicator = view_current.getRight() - view_current.getPaddingRight();

        Log.e("width", "++++++++++++++++++++++++++++++" + view_current.getWidth());
//        int left = width_indicator == 0 ? left_indicator : (view_current.getWidth() - width_indicator) / 2;
//        int top = getHeight() - (height_indicator == 0 ? 10 : height_indicator);
//        int right = width_indicator == 0 ? right_indicator : (left + width_indicator);
//        int bottom = getHeight();
        int left =view_current.getLeft()+ (view_current.getWidth() - width_indicator) / 2;
        int top = getHeight() - height_indicator;
        int right = left + width_indicator;
        int bottom = getHeight();


        view_indicator.setBounds(left, top, right, bottom);
        view_indicator.draw(canvas);

    }

    public GradientDrawable getView_indicator() {
        return view_indicator;
    }

    public int getHeight_indicator() {
        return height_indicator;
    }

    /**
     * 设置指示器高度
     *
     * @param height_indicator
     */
    public void setHeight_indicator(int height_indicator) {
        this.height_indicator = height_indicator;

        invalidate();
    }

    public int getWidth_indicator() {
        return width_indicator;
    }

    /**
     * 设置指示器宽度
     *
     * @param width_indicator
     */

    public void setWidth_indicator(int width_indicator) {
        this.width_indicator = width_indicator;
        invalidate();

    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        this.onTabSelectListener = onTabSelectListener;
    }

    public interface OnTabSelectListener {
        void onTabSelect(int position);

        void onTabReselect(int position);

    }


}
