package co.lujun.sample;

import android.bluetooth.BluetoothAdapter;
import android.util.Log;

import com.diing.bluetooth.base.State;
import diing.com.core.util.Logger;

/**
 * Author: lujun(http://blog.lujun.co)
 * Date: 2016-1-26 10:12
 */
public class Utils {

    public static String transConnStateAsString(int state){
        String result;
        if (state == State.STATE_NONE) {
            result = "NONE";
        } else if (state == State.STATE_LISTEN) {
            result = "LISTEN";
        } else if (state == State.STATE_CONNECTING) {
            result = "CONNECTING";
        } else if (state == State.STATE_CONNECTED) {
            result = "CONNECTED";
        } else if (state == State.STATE_DISCONNECTED){
            result = "DISCONNECTED";
        }else if (state == State.STATE_GOT_CHARACTERISTICS){
            result = "CONNECTED, GOT ALL CHARACTERISTICS";
        }
        else{
            result = "UNKNOWN";
        }
        return result;
    }

    public static String transBtStateAsString(int state){
        String result = "UNKNOWN";
        if (state == BluetoothAdapter.STATE_TURNING_ON) {
            result = "TURNING_ON";
        } else if (state == BluetoothAdapter.STATE_ON) {
            result = "ON";
        } else if (state == BluetoothAdapter.STATE_TURNING_OFF) {
            result = "TURNING_OFF";
        }else if (state == BluetoothAdapter.STATE_OFF) {
            result = "OFF";
        }
        return result;
    }

    public static String logCommand(String tag, byte[] data) {
        if (data != null && data.length > 0) {
            final StringBuilder stringBuilder = new StringBuilder(data.length);
            for (byte byteChar : data)
                stringBuilder.append(String.format("%02X ", byteChar));
            Log.e(tag, stringBuilder.toString());
            return stringBuilder.toString();
        }
        Logger.e(tag, "Not a command");
        return "Not a command";
    }
}
