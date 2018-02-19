package test.propertyfinder.com.propertyfinder.propertylist.presentation.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import test.propertyfinder.com.propertyfinder.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashActivity.this, PropertyListActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}
