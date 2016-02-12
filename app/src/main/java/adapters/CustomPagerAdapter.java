package adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.artem.streamv.Helper;

import java.util.ArrayList;

import enums.CustomPagerEnum;

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private String streamerName;

    public CustomPagerAdapter(Context context, String streamerName) {
        mContext = context;
        this.streamerName = streamerName;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(customPagerEnum.getLayoutResId(), collection, false);
        int id = mContext.getResources().getIdentifier(streamerName + "_background", "drawable", mContext.getPackageName());
        Log.w("id", String.valueOf(id));
        layout.setBackground(ContextCompat.getDrawable(mContext, id));
        ArrayList<String> listOfPhrases = Helper.phrases.get(streamerName);
        Log.w("streamerName", streamerName);
        if (position == 0 && streamerName.equals("sing_sing")) {
            for (int i = 0; i < 9; i++) {
                int n = 2131558511 + i * 2;
                TextView textView = (TextView) layout.findViewById(n);
                String phrase = listOfPhrases.get(i);
                Log.w("phrase" + String.valueOf(i), listOfPhrases.get(i));
                textView.setText(phrase);
                Log.w("phrase" + String.valueOf(i) + "setted", listOfPhrases.get(i));
            }
        }
        collection.addView(layout);
        return layout;
    }


    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return CustomPagerEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
//        return mContext.getString(customPagerEnum.getTitleResId());
//    }

}