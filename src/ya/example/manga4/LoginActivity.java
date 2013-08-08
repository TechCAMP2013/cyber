package ya.example.manga4;

import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends HttpActivity {  // Httpつける
	TextView name_tv,pass_tv,test_tv;
	EditText name_et,pass_et;
	Button decide_bt, howto_bt;
	ImageView iv;
	HttpActivity activity = this;		//this line
	
	public void receiveMessage(Map<String, Object> map)    //this
	{
		if ("login".equals(map.get("id")))
		{
			if (Integer.parseInt((String)map.get("status")) == 1)
			{
				test_tv.setText("");
				Intent intent;
				intent = new Intent(LoginActivity.this, TopActivity.class );
				// 鬩包ｽｷ驕假ｽｻ陷亥現�ｽ郢ｧ�｢郢ｧ�ｯ郢晢ｿｽ縺�ｹ晁侭繝ｦ郢ｧ�｣郢ｧ螳夲ｽｵ�ｷ陷崎ｼ費ｼ�ｸｺ蟶呻ｽ�				
				startActivity( intent );
			}
			else
			{
				test_tv.setText("passかuserが間違ってます");
			}
		}
		else
		{
			test_tv.setText("エラー");
		}
	
		//test_tv.setText("result: " + map.toString());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);
		

		name_tv = new TextView(this);
		name_tv.setText("ユーザ名を入力してください");
		name_et = new EditText(this);
		
		pass_tv = new TextView(this);
		pass_tv.setText("パスワードを入力してください");
		pass_et = new EditText(this);
		
		decide_bt = new Button(this);
		decide_bt.setText("決定");
		
		howto_bt = new Button(this);
		howto_bt.setText("使い方");
		
		test_tv = new TextView(this);
		test_tv.setText("");
		
		ll.addView(name_tv);
		ll.addView(name_et);
		
		ll.addView(pass_tv);
		ll.addView(pass_et);
		
		ll.addView(decide_bt);
		ll.addView(howto_bt);
		
		ll.addView(test_tv);
		
		decide_bt.setOnClickListener(new DecideClickListener());
		howto_bt.setOnClickListener(new HowtoClickListener());
		
		iv = new ImageView(this);
		AsyncHttpDownload asyncHttpDownload = new AsyncHttpDownload("a.jpg",iv);
		asyncHttpDownload.send();
		ll.addView(iv);

		
		
		
		
		
		
		
	}
	
	class DecideClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 髢ｾ�ｪ陷肴�蜃ｽ隰瑚���ｹｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽ郢晢ｿｽ繝ｩ郢晢ｽｻ郢ｧ�ｹ郢ｧ�ｿ郢晢ｿｽ			
			test_tv.setText("ユーザー名を入力してください");
			
			HashMap<String, Object> data = new HashMap<String, Object>();		//koko
			data.put("id","login");
			data.put("name", name_et.getText().toString());
			data.put("pass", pass_et.getText().toString());						
			AsyncHttpPost asyncHttpPost = new AsyncHttpPost(data, activity);
			asyncHttpPost.send();
		}
	}
	
	class HowtoClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 髢ｾ�ｪ陷肴�蜃ｽ隰瑚���ｹｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽ郢晢ｿｽ繝ｩ郢晢ｽｻ郢ｧ�ｹ郢ｧ�ｿ郢晢ｿｽ			
			test_tv.setText("使い方");
			Intent intent2;
			intent2 = new Intent(LoginActivity.this, HowToActivity.class );
			// 鬩包ｽｷ驕假ｽｻ陷亥現�ｽ郢ｧ�｢郢ｧ�ｯ郢晢ｿｽ縺�ｹ晁侭繝ｦ郢ｧ�｣郢ｧ螳夲ｽｵ�ｷ陷崎ｼ費ｼ�ｸｺ蟶呻ｽ�			
			startActivity( intent2 );
		}
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	}
