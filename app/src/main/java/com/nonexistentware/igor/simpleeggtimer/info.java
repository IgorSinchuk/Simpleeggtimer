package com.nonexistentware.igor.simpleeggtimer;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class info extends AppCompatActivity {

    private ImageView faceBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        faceBook = (ImageView) findViewById(R.id.faceBook);


        faceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder faceAlert = new AlertDialog.Builder(info.this);
                faceAlert.setMessage("Do you want to proceed?")
                        .setTitle("To developer profile")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent openFacebook = new Intent(Intent.ACTION_VIEW);
                                openFacebook.setData(Uri.parse("https://www.facebook.com/profile.php?id=100003140149327"));
                                startActivity(openFacebook);


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).create();
                faceAlert.show();
            }
        });
    }
}
