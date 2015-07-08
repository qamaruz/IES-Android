package com.example.qamaruz.ies;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.Toast;
/*import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import java.util.logging.Handler;
import android.webkit.WebChromeClient;
import android.media.RingtoneManager;
import android.net.Uri;
import android.view.View;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.app.AlertDialog;
import android.app.TaskStackBuilder;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.TextView;
*/
public class MainActivity extends Activity {
    private WebView mWebView;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        //addListenerOnButton();
        //getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        mWebView=(WebView)findViewById(R.id.webview);

      /*BEGIN CACHING FOR OFFLINE ACCESS*/
        mWebView.getSettings().setAppCacheMaxSize(5 * 1024 * 1024); // 5MB
        mWebView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT); // load online by default
        if ( !isNetworkAvailable() ) { // loading offline
            mWebView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
        }
        /*END CACHING FOR OFFLINE ACCESS*/
        mWebView.loadUrl("http://www.ies-2015.org/mobile");
        /*BEGIN ENABLE JAVASCRIPT*/
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        /*END ENABLE JAVASCRIPT*/

        /*BEGIN LOAD PAGE IN APP*/
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        /*END LOAD PAGE IN APP */



        //mWebView.setWebChromeClient(new WebChromeClient());//for extra functions
        //this.setContentView(mWebView);
        //showNotification();
    }
    /*BEGIN CHECK INTERNET CONNECTION METHOD*/
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService( CONNECTIVITY_SERVICE );
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    /*public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.notification_option);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(context, optionMain.class);
                startActivity(intent);
            }
        });

    }*/
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        return true;
    }
    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.menu_bookmark:
                // Single menu item is selected do something
                // Ex: launching new activity/screen or show alert message
                Toast.makeText(MainActivity.this, "Bookmark is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_save:
                Toast.makeText(MainActivity.this, "Save is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_search:
                Toast.makeText(MainActivity.this, "Search is Selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /*public void showNotification(){

        // define sound URI, the sound to be played when there's a notification
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        // intent triggered, you can add other intent for other actions
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
        // this is it, we'll build the notification!
        // in the addAction method, if you don't want any icon, just set the first param to 0
        Notification mNotification = new Notification.Builder(this)

                .setContentTitle("New Post!")
                .setContentText("Here's an awesome update for you!")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentIntent(pIntent)
                .setSound(soundUri)
                .addAction(R.drawable.notification_icon, "View", pIntent)
                .addAction(0, "Remind", pIntent)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // If you want to hide the notification after it was selected, do the code below
        // myNotification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, mNotification);
    }*/


        @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {

            if((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack())
            {
                mWebView.goBack();
                return true;
            }
            else if (keyCode == KeyEvent.KEYCODE_MENU)
            {
                Toast.makeText(MainActivity.this, "OPTION KEY PRESSED", Toast.LENGTH_SHORT).show();
            }
            return super.onKeyDown(keyCode, event);
    }
    /*public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }*/
}
