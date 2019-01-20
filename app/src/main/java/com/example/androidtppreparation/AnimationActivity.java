package com.example.androidtppreparation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        StarView starView = new StarView(this);
        setContentView(starView);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim);
        starView.startAnimation(anim);
    }

    class StarView extends View {
        Paint paint;
        Path path;
        int N = 5; // Количество вершин звезды
        double K = 1.0 - 3.0 / (double)N; // Коэффициент домножения

        public StarView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);

            path = new Path();
        }

        private void init() {
            paint.setColor(Color.RED);
        }


        @Override
        protected void onDraw(Canvas canvas) {
            double midX = getWidth() / 2;
            double midY = getHeight() / 2;
            double min = Math.min(getWidth(), getHeight());
            double fat = min / 17;
            double half = min / 2;
            // float rad = half - fat;
            // mid = mid - half;

            paint.setStrokeWidth((float) fat);
            paint.setStyle(Paint.Style.STROKE);

            // canvas.drawCircle(mid + half, half, rad, paint);

            path.reset();

            paint.setStyle(Paint.Style.FILL);

            double step = Math.PI * 2 / 2 / N;
            double startAngle = -Math.PI;

            path.moveTo((float)(midX + half * Math.sin(startAngle)),
                    (float)(midY + half * Math.cos(startAngle)));

            for (int i = 1; i <= 2 * N; i++) {
                if (i % 2 == 1) {
                    // Малый радиус
                    path.lineTo((float) (midX + K *half * Math.sin(startAngle + step * (double)i)),
                            (float) (midY + K * half * Math.cos(startAngle + step * (double)i)));
                } else {
                    // Большой радиус
                    path.lineTo((float) (midX + half * Math.sin(startAngle + step * (double)i)),
                            (float) (midY + half * Math.cos(startAngle + step * (double)i)));
                }
            }

            path.close();
            canvas.drawPath(path, paint);

            super.onDraw(canvas);
        }
    }
}
