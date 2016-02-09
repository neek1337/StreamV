package ui.component;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.artem.streamv.R;

public class CustomButton extends RelativeLayout {
    private TextView mainText;

    public void setMainText(String caption) {
        this.mainText.setText(caption);
    }


    public TextView getMainText() {
        return mainText;
    }


    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initComponent();

        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MyCustomButton);
        try {
            this.setMainText(styledAttributes.getString(R.styleable.MyCustomButton_mcb_main_text));
        } finally {
            styledAttributes.recycle();
        }

    }

    private void initComponent() {
        // Создаем View из XML файла
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_button, this);

        // Ищем элементы
        mainText = (TextView) findViewById(R.id.uiMyButtonMainText);
        //icon = (ImageView) findViewById(R.id.uiMyButtonIcon);
    }


}

