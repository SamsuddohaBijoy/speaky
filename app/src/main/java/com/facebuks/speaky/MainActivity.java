package com.facebuks.speaky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText roomName;

    Button joinRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roomName = findViewById(R.id.roomName);
        joinRoom = findViewById(R.id.joinRoom);

        try {

            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions
                    .Builder()
                    .setServerURL(new URL("https://meet.jit.si"))
                    .setWelcomePageEnabled(false)
                    .build();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        joinRoom.setOnClickListener(view -> {
            String room = roomName.getText().toString().trim();


            JitsiMeetConferenceOptions callOptions =
                    new JitsiMeetConferenceOptions
                            .Builder()
                            .setRoom(room)
                            .build();

            JitsiMeetActivity.launch(MainActivity.this, callOptions);


        });


    }
}