package ya.example.manga4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class HowToActivity extends Activity {


  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_how_to);
		
		// 繝懊ち繝ｳ繧ｪ繝悶ず繧ｧ繧ｯ繝亥叙蠕�		
		Button button = (Button) findViewById(R.id.button1);
				// 繝懊ち繝ｳ繧ｪ繝悶ず繧ｧ繧ｯ繝医↓繧ｯ繝ｪ繝�け繝ｪ繧ｹ繝翫�險ｭ螳�		
		button.setOnClickListener(new ButtonClickListener());
	}
	
	class ButtonClickListener implements OnClickListener{
		public void onClick(View v){
			Intent intent =new Intent(HowToActivity.this,LoginActivity.class);
			startActivity(intent);
		
	}
}
	



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.how_to, menu); 
		return true;  
	}

}
