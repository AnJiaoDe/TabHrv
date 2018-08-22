//package com.cy.tabrv;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.View;
//import android.widget.HorizontalScrollView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
///**
// * Created by leifeng on 2018/8/22.
// */
//
//public class Tab {
//    package com.cy.tabrv;
//
//    import android.content.Context;
//    import android.graphics.Canvas;
//    import android.util.AttributeSet;
//    import android.util.Log;
//    import android.view.View;
//    import android.widget.HorizontalScrollView;
//    import android.widget.LinearLayout;
//    import android.widget.TextView;
//
//    /**
//     * Created by leifeng on 2018/8/2.
//     */
//
//    public class CYTabLayout extends LinearLayout {
//        private Context context;
//
//        private int postion_current = 0;
//
//        private HorizontalScrollView horizontalScrollView;
//        private LinearLayout linearLayout;
//
//        private View view_indicator;
//
//        private com.cy.tabrv.CYTabLayout.OnTabSelectListener onTabSelectListener;
//
//        private int left_indicator_last = 0;
//        private int left_tab_last = 0;
//
//        public CYTabLayout(Context context) {
//            this(context, null);
//        }
//
//        public CYTabLayout(Context context, AttributeSet attrs) {
//            super(context, attrs);
//            this.context = context;
//
//            setOrientation(VERTICAL);
//
//        }
//
//
//        @Override
//        protected void onFinishInflate() {
//            super.onFinishInflate();
//            horizontalScrollView = (HorizontalScrollView) getChildAt(0);
//            horizontalScrollView.setOverScrollMode(View.OVER_SCROLL_NEVER);
//            horizontalScrollView.setScrollBarSize(0);
//
//            linearLayout = new LinearLayout(context);
//            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
//            HorizontalScrollView.LayoutParams layoutParams2 = new HorizontalScrollView.LayoutParams(
//                    HorizontalScrollView.LayoutParams.MATCH_PARENT, HorizontalScrollView.LayoutParams.MATCH_PARENT);
//            linearLayout.setLayoutParams(layoutParams2);
//            horizontalScrollView.addView(linearLayout);
//
//            view_indicator = getChildAt(1);
//        }
//
//        public void addTab(final View view) {
//
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            view.setLayoutParams(layoutParams);
//
//            linearLayout.addView(view);
//
//            view.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
////                Log.e("position", "=====================================" + linearLayout.indexOfChild(view));
//
//                    if (postion_current == linearLayout.indexOfChild(view)) {
//                        onTabSelectListener.onTabReselect(linearLayout.indexOfChild(view));
//
//                        return;
//                    }
//
//                    postion_current = linearLayout.indexOfChild(view);
//
//
//                    int scrollX_now = view.getLeft();
//                    scrollX_now -= getWidth() / 2 - getPaddingLeft();
//
//
//                    horizontalScrollView.smoothScrollTo(scrollX_now, 0);
//
//                    invalidate();
//
//                    if (onTabSelectListener != null) {
//                        onTabSelectListener.onTabSelect(linearLayout.indexOfChild(view));
//                    }
//
//                }
//            });
//
//
//            invalidate();
//        }
//
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//
//            View view_current = (TextView) linearLayout.getChildAt(postion_current);
//            view_indicator.measure(MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED),MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED));
//
//
//            int left_indicator = (view_current.getWidth() - view_indicator.getMeasuredWidth()) / 2;
//
//            int right_indicator = view_current.getRight() - view_current.getPaddingRight();
//
//
//            Log.e("getWidth", "=====================================" + view_indicator.getMeasuredWidth());
//
////        rect_indicator.left = view_current.getLeft() + view_current.getPaddingLeft();
////        rect_indicator.right = view_current.getRight() - view_current.getPaddingRight();
//
////        view_indicator.setLeft(left_indicator);
////        view_indicator.setTop(getHeight());
////        view_indicator.setRight(right_indicator);
////        view_indicator.setBottom( getHeight()+10);
//
////        view_indicator.layout(left_indicator, horizontalScrollView.getHeight(), right_indicator, horizontalScrollView.getHeight()+10);
//
//            view_indicator.setLeft(left_indicator);
//            left_tab_last = view_current.getLeft();
//            left_indicator_last = left_indicator;
////        view_indicator.draw(canvas);
//
//        }
//
//        public void setOnTabSelectListener(com.cy.tabrv.CYTabLayout.OnTabSelectListener onTabSelectListener) {
//            this.onTabSelectListener = onTabSelectListener;
//        }
//
//        public interface OnTabSelectListener {
//            void onTabSelect(int position);
//
//            void onTabReselect(int position);
//
//        }
//
//
//    }
//
//}
