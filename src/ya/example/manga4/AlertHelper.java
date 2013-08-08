package ya.example.manga4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertHelper {

	/** 
     * 警告メッセージを表示します。 
     * @param context 
     * @param message 
     * @param listenerOK 
     */  
    public static void showPreImg(Context context,String message,DialogInterface.OnClickListener listenerOK,int img_int){  
        LayoutInflater inflater = LayoutInflater.from(context);  
        final View view = inflater.inflate(R.layout.alert,null);  
        ImageView imgAlertIcon = (ImageView)view.findViewById(R.id.imageAlertIcon);  
        imgAlertIcon.setImageResource(img_int);  
        TextView lblMessage = (TextView)view.findViewById(R.id.lblMessage);  
        lblMessage.setText(message);  
        AlertDialog.Builder alert = new AlertDialog.Builder(context);          
        alert.setPositiveButton("OK",listenerOK);  
        alert.setView(view);  
        alert.show();      
    }  
      
}
