package ya.example.manga4;

import ya.example.manga4.DrawModeActivity.NewClickListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DecideTitleActivity extends Activity {
	TextView title_tv;
	EditText title_et;
	Button decide_bt;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);
		
		title_tv = new TextView(this);
		title_tv.setText("���������������������������������������");
		
		title_et = new EditText(this);
		
		
		decide_bt = new Button(this);
		decide_bt.setText("������");
		
		ll.addView(title_tv);
		ll.addView(title_et);
		ll.addView(decide_bt);
		
		decide_bt.setOnClickListener(new DecideClickListener());
	}
	
	class DecideClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO ���������������������������������������������
			Intent intent;
			intent = new Intent(DecideTitleActivity.this, DrawActivity.class );
			// ���������������������������������������������������
			startActivity( intent );
		}
		
	}

}
