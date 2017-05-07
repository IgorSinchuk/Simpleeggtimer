package com.nonexistentware.igor.simpleeggtimer;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.TimeUnit;
import android.media.Image;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.util.TimeUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView soft, softMedium, medium, mediumHard, hard, info, stop, bar2, bar, imageView;
    private TextView timer;
    private CountDownTimer myCountDownTimer;
    private Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    private Button softBtn, softMediumBtn, mediumBtn, mediumHardBtn, hardBtn;

    int count = 0;
    boolean[] timerProcessing = { false };
    boolean[] timerStarts = { false };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttons
        softBtn = (Button) findViewById(R.id.softBtn);
        softMediumBtn = (Button) findViewById(R.id.softMediumBtn);
        mediumBtn = (Button) findViewById(R.id.mediumBtn);
        mediumHardBtn = (Button) findViewById(R.id.mediumHardBtn);
        hardBtn = (Button) findViewById(R.id.hardBtn);


        //images
        soft = (ImageView) findViewById(R.id.soft);
        softMedium = (ImageView) findViewById(R.id.softMedium);
        medium = (ImageView) findViewById(R.id.medium);
        mediumHard = (ImageView) findViewById(R.id.mediumHard);
        hard = (ImageView) findViewById(R.id.hard);
        stop = (ImageView) findViewById(R.id.stop);
        info = (ImageView) findViewById(R.id.info);
        bar = (ImageView) findViewById(R.id.bar);
        bar2 = (ImageView) findViewById(R.id.bar2);
        imageView = (ImageView) findViewById(R.id.imageView);

        //disable
        stop.setVisibility(View.INVISIBLE);
        soft.setVisibility(View.INVISIBLE);
        softMedium.setVisibility(View.INVISIBLE);
        medium.setVisibility(View.INVISIBLE);
        mediumHard.setVisibility(View.INVISIBLE);
        hard.setVisibility(View.INVISIBLE);


        //timer
        timer = (TextView) findViewById(R.id.timer);

        //visibility
        stop.setVisibility(View.VISIBLE);


        //buttons
        softBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soft.setVisibility(View.VISIBLE);
                softMedium.setVisibility(View.INVISIBLE);
                medium.setVisibility(View.INVISIBLE);
                mediumHard.setVisibility(View.INVISIBLE);
                hard.setVisibility(View.INVISIBLE);
            }
        });

        softMediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soft.setVisibility(View.INVISIBLE);
                softMedium.setVisibility(View.VISIBLE);
                medium.setVisibility(View.INVISIBLE);
                mediumHard.setVisibility(View.INVISIBLE);
                hard.setVisibility(View.INVISIBLE);

            }
        });


        mediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soft.setVisibility(View.INVISIBLE);
                softMedium.setVisibility(View.INVISIBLE);
                medium.setVisibility(View.VISIBLE);
                mediumHard.setVisibility(View.INVISIBLE);
                hard.setVisibility(View.INVISIBLE);

            }
        });

        mediumHardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soft.setVisibility(View.INVISIBLE);
                softMedium.setVisibility(View.VISIBLE);
                medium.setVisibility(View.INVISIBLE);
                mediumHard.setVisibility(View.VISIBLE);
                hard.setVisibility(View.INVISIBLE);

            }
        });

        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soft.setVisibility(View.INVISIBLE);
                softMedium.setVisibility(View.INVISIBLE);
                medium.setVisibility(View.INVISIBLE);
                mediumHard.setVisibility(View.INVISIBLE);
                hard.setVisibility(View.VISIBLE);

            }
        });





        soft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop.setVisibility(View.VISIBLE);

                myCountDownTimer = new CountDownTimer(120*1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timer.setText("" + millisUntilFinished / 1000);
                        soft.setClickable(false);
                        softMedium.setClickable(false);
                        medium.setClickable(false);
                        mediumHard.setClickable(false);
                        hard.setClickable(false);

                        softBtn.setClickable(true);
                        softMediumBtn.setClickable(false);
                        mediumBtn.setClickable(false);
                        mediumHardBtn.setClickable(false);
                        hardBtn.setClickable(false);

                    }

                    @Override
                    public void onFinish() {
                        timerNotification();
                        stop.setVisibility(View.INVISIBLE);
                        soft.setClickable(true);
                        softMedium.setClickable(true);
                        medium.setClickable(true);
                        mediumHard.setClickable(true);
                        hard.setClickable(true);

                        softBtn.setClickable(true);
                        softMediumBtn.setClickable(true);
                        mediumBtn.setClickable(true);
                        mediumHardBtn.setClickable(true);
                        hardBtn.setClickable(true);
                    }
                }.start();

            }
        });

        softMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop.setVisibility(View.VISIBLE);

                myCountDownTimer = new CountDownTimer(240*1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timer.setText("" + millisUntilFinished / 1000);
                        soft.setClickable(false);
                        softMedium.setClickable(false);
                        medium.setClickable(false);
                        mediumHard.setClickable(false);
                        hard.setClickable(false);

                        softBtn.setClickable(false);
                        softMediumBtn.setClickable(true);
                        mediumBtn.setClickable(false);
                        mediumHardBtn.setClickable(false);
                        hardBtn.setClickable(false);
                    }

                    @Override
                    public void onFinish() {
                        timerNotification();
                        stop.setVisibility(View.INVISIBLE);
                        soft.setClickable(true);
                        softMedium.setClickable(true);
                        medium.setClickable(true);
                        mediumHard.setClickable(true);
                        hard.setClickable(true);

                        softBtn.setClickable(true);
                        softMediumBtn.setClickable(true);
                        mediumBtn.setClickable(true);
                        mediumHardBtn.setClickable(true);
                        hardBtn.setClickable(true);
                    }
                }.start();

            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop.setVisibility(View.VISIBLE);

                myCountDownTimer = new CountDownTimer(360*1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timer.setText("" + millisUntilFinished / 1000);
                        soft.setClickable(false);
                        softMedium.setClickable(false);
                        medium.setClickable(false);
                        mediumHard.setClickable(false);
                        hard.setClickable(false);

                        softBtn.setClickable(false);
                        softMediumBtn.setClickable(false);
                        mediumBtn.setClickable(true);
                        mediumHardBtn.setClickable(false);
                        hardBtn.setClickable(false);
                    }

                    @Override
                    public void onFinish() {
                        timerNotification();
                        stop.setVisibility(View.INVISIBLE);
                        soft.setClickable(true);
                        softMedium.setClickable(true);
                        medium.setClickable(true);
                        mediumHard.setClickable(true);
                        hard.setClickable(true);

                        softBtn.setClickable(true);
                        softMediumBtn.setClickable(true);
                        mediumBtn.setClickable(true);
                        mediumHardBtn.setClickable(true);
                        hardBtn.setClickable(true);
                    }
                }.start();

            }
        });

        mediumHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop.setVisibility(View.VISIBLE);

                myCountDownTimer = new CountDownTimer(480*1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timer.setText("" + millisUntilFinished / 1000);
                        soft.setClickable(false);
                        softMedium.setClickable(false);
                        medium.setClickable(false);
                        mediumHard.setClickable(false);
                        hard.setClickable(false);

                        softBtn.setClickable(false);
                        softMediumBtn.setClickable(false);
                        mediumBtn.setClickable(false);
                        mediumHardBtn.setClickable(true);
                        hardBtn.setClickable(false);
                    }

                    @Override
                    public void onFinish() {
                        timerNotification();
                        stop.setVisibility(View.INVISIBLE);
                        soft.setClickable(true);
                        softMedium.setClickable(true);
                        medium.setClickable(true);
                        mediumHard.setClickable(true);
                        hard.setClickable(true);

                        softBtn.setClickable(true);
                        softMediumBtn.setClickable(true);
                        mediumBtn.setClickable(true);
                        mediumHardBtn.setClickable(true);
                        hardBtn.setClickable(true);
                    }
                }.start();

            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop.setVisibility(View.VISIBLE);

                myCountDownTimer = new CountDownTimer(600*1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished ) {
                        timer.setText("" + millisUntilFinished / 1000);
                        soft.setClickable(false);
                        softMedium.setClickable(false);
                        medium.setClickable(false);
                        mediumHard.setClickable(false);
                        hard.setClickable(false);

                        softBtn.setClickable(false);
                        softMediumBtn.setClickable(false);
                        mediumBtn.setClickable(false);
                        mediumHardBtn.setClickable(false);
                        hardBtn.setClickable(true);
                    }

                    @Override
                    public void onFinish() {
                        timerNotification();
                        stop.setVisibility(View.INVISIBLE);
                        soft.setClickable(true);
                        softMedium.setClickable(true);
                        medium.setClickable(true);
                        mediumHard.setClickable(true);
                        hard.setClickable(true);

                        softBtn.setClickable(true);
                        softMediumBtn.setClickable(true);
                        mediumBtn.setClickable(true);
                        mediumHardBtn.setClickable(true);
                        hardBtn.setClickable(true);
                    }
                }.start();

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerProcessing[0] = true;
                count = 0;
                timer.setText(String.valueOf(count));
                myCountDownTimer.cancel();

                soft.setClickable(true);
                softMedium.setClickable(true);
                medium.setClickable(true);
                mediumHard.setClickable(true);
                hard.setClickable(true);

                softBtn.setClickable(true);
                softMediumBtn.setClickable(true);
                mediumBtn.setClickable(true);
                mediumHardBtn.setClickable(true);
                hardBtn.setClickable(true);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info = new Intent(MainActivity.this, com.nonexistentware.igor.simpleeggtimer.info.class);
                startActivity(info);
            }
        });

    }

    public void stopOnClickListener(View view) {




    }

    public void startOnClickListener(View view) {

        myCountDownTimer.start();
    }

    public void timerNotification () {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle("From simple egg timer")
                .setContentText("Eggs are ready")
                .setSound(soundUri);
        //.setSound();

        Intent fullIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, fullIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());


    }

    //disable return btn
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;

            }
        }

        return super.dispatchKeyEvent(event);
    }
}
