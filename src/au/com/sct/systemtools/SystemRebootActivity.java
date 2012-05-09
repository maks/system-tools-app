package au.com.sct.systemtools;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SystemRebootActivity extends Activity {
    
    private static final String TAG = SystemRebootActivity.class
                    .getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button rebootButton = (Button) findViewById(R.id.reboot_button);
        rebootButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Log.d(TAG, "PwrMgr Reboot now!");
                rebootDevice();
            }
        });
    }
    
    private void rebootDevice() {
        // sendBroadcast(new Intent(Intent.ACTION_REBOOT));
        PowerManager pm = (PowerManager)
                        getSystemService(Context.POWER_SERVICE);
        pm.reboot("now");
    }
}