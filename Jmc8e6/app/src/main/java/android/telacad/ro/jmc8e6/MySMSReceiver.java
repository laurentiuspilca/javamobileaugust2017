package android.telacad.ro.jmc8e6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by student on 10/28/2017.
 */

public class MySMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MySMSReceiver", "Reached onReceive");
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();
            SmsMessage[] msgs = null;
            String from;
            if (bundle != null){
                Object[] pdus = (Object[]) bundle.get("pdus");
                msgs = new SmsMessage[pdus.length];
                for(int i=0; i<msgs.length; i++){
                    msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                    from = msgs[i].getOriginatingAddress();
                    String msgBody = msgs[i].getMessageBody();

                    Log.d("MySMSReceiver", from+": "+msgBody);
                    Toast.makeText(context, from+": "+msgBody, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
