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
		top_tv.setText("縺ｩ縺ｮ邯壹″繧呈緒縺�");
		
		ll.addView(top_tv);
		
		new_bt = new Button(this);
		new_bt.setText("新規作成");
		
		ll.addView(new_bt);
		
		new_bt.setOnClickListener(new NewClickListener());
		
	}
	
	class NewClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			Intent intent;
			intent = new Intent(DrawModeActivity.this, DecideTitleActivity.class );
			// 驕ｷ遘ｻ蜈医�繧｢繧ｯ繝�ぅ繝薙ユ繧｣繧定ｵｷ蜍輔＆縺帙ｋ
			startActivity( intent );
		}
	}
	

}
