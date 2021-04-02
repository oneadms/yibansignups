package com.yiban.test.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.yiban.test.R;

import org.jetbrains.annotations.NotNull;

public class NameImageView extends AppCompatImageView {

    private String name;

    private Bitmap bitmap;

    public NameImageView(@NonNull @NotNull Context context) {
        this(context,null,0);
    }

    public NameImageView(@NonNull @NotNull Context context, @Nullable  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NameImageView(@NonNull @NotNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NameImageView);
        String name = typedArray.getString(R.styleable.NameImageView_text);
        if (name != null) {
            this.name = name;
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setName(String name) {
        this.name = name;
        invalidate();
    }

    public void setOK(int flag) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inMutable = true;
        if (flag==1) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_ok,opts);
        }else{
            if (flag==2){
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_no,opts);
            }

        }

        invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#0000FF"));
        float dimension = getResources().getDimension(R.dimen.size);
        canvas.scale(0.5f,0.5f,dimension/2.0f,dimension/2.0f);
        canvas.drawCircle(dimension/2f,dimension/2f,dimension/2.0f, paint);
        if (name != null) {

            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#FF0000"));
            paint.setStrokeWidth(8);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(30);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            paint.getTextBounds(name, 0, name.length(), new Rect());
            canvas.drawText(name,dimension/2f,dimension/2f+fontMetrics.bottom,paint);
        }

        if (bitmap != null) {
            canvas.save();
            canvas.scale(0.5f,0.5f);

            canvas.drawBitmap(bitmap,
                    new Rect(0, 0, (int) bitmap.getWidth(), (int) bitmap.getHeight()),
                    new Rect((int) dimension, (int) dimension, (int) dimension*2,(int)dimension*2), paint);
        }


    }
}
