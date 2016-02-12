package enums;


import com.example.artem.streamv.R;

public enum CustomPagerEnum {

    PHRASES(R.layout.second_layout),
    INFO(R.layout.info_layout);


    private int mLayoutResId;

    CustomPagerEnum(int layoutResId) {
        mLayoutResId = layoutResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}