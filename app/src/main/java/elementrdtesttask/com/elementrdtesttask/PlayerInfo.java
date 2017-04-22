package elementrdtesttask.com.elementrdtesttask;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerInfo extends AppCompatActivity {
    private ImageView imageViewPhoto;
    private TextView textViewName;
    private TextView textViewPosition;
    private TextView textViewNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewPosition = (TextView) findViewById(R.id.textViewPosition);
        textViewNumber = (TextView) findViewById(R.id.textViewNumber);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String position = intent.getStringExtra("position");
        String number = intent.getStringExtra("number");
        int photo = intent.getIntExtra("photo", R.drawable.ic_aina);

        textViewName.setText(name);
        textViewPosition.setText(position);
        textViewNumber.setText(number);
        imageViewPhoto.setBackgroundResource(photo);
    }
}
