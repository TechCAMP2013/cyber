package ya.example.manga4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrawModeActivity extends Activity {
	TextView top_tv;
	Button new_bt;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);
		
		top_tv = new TextView(this);
		top_tv.setText("続きを書きたいコマを選択してください");
		
		ll.addView(top_tv);
		
		new_bt = new Button(this);
		new_bt.setText("新規作成");
		
		ll.addView(new_bt);
		
		new_bt.setOnClickListener(new NewClickListener());
		
	}
	
	class NewClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 髢ｾ�ｪ陷肴�蜃ｽ隰瑚���ｹｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽ郢晢ｿｽ繝ｩ郢晢ｽｻ郢ｧ�ｹ郢ｧ�ｿ郢晢ｿｽ			
			Intent intent;
			intent = new Intent(DrawModeActivity.this, DecideTitleActivity.class );
			// 鬩包ｽｷ驕假ｽｻ陷亥現�ｽ郢ｧ�｢郢ｧ�ｯ郢晢ｿｽ縺�ｹ晁侭繝ｦ郢ｧ�｣郢ｧ螳夲ｽｵ�ｷ陷崎ｼ費ｼ�ｸｺ蟶呻ｽ�			
			startActivity( intent );
		}
	}
	

}
