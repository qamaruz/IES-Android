package ies.kmutt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import ies.kmutt.R;

/**
 * Created by Qamaruz on 25/06/2015.
 */
public class optionMain extends Activity {
    Button button;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.notifications);
        addListenerOnButton();

    }
    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.backB);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }
        });

    }
    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        final Context context = this;

        if((keyCode == KeyEvent.KEYCODE_BACK) )
        {
            Intent intent = new Intent(context, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
            /*else if(keyCode == KeyEvent.KEYCODE_HOME)
            {
                Log.d("Test", "Home button pressed!");
            }*/
        return super.onKeyDown(keyCode, event);

    }
}
