
package ya.example.manga4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Show4KomaActivity extends Activity implements OnClickListener {
	
	private final int BTN_START = 0;
	private final int BTN_PREV = 1;
	private final int BTN_NEXT = 2;
	private final int BTN_END = 3;
	private ArrayList<ImageButton> _btnList = new ArrayList<ImageButton>();
	private ViewPager _viewPager = null;
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		
		TextView textView = (TextView)findViewById(R.id.textViewTitle);  
		Intent title_it = getIntent();
		String title = title_it.getStringExtra("title");
		textView.setText(title);  
		

		 
		_btnList.add((ImageButton) findViewById(R.id.btn_start));
		_btnList.add((ImageButton) findViewById(R.id.btn_prev));
		_btnList.add((ImageButton) findViewById(R.id.btn_next));
		_btnList.add((ImageButton) findViewById(R.id.btn_end));
		for (ImageButton btn : _btnList) {
			btn.setOnClickListener(this);
		}
		
		_viewPager = (ViewPager) findViewById(R.id.viewpager);
		PagerAdapter mPagerAdapter = new CustomPagerAdapter(this);
		_viewPager.setAdapter(mPagerAdapter);
	}

	public void onClick(View v) {
		for (int i = 0; i < _btnList.size(); i++) {
			if (v != _btnList.get(i)) {
				continue;
			}
			switch (i) {
			case BTN_START:
				_viewPager.setCurrentItem(0);
				break;
			case BTN_PREV:
				_viewPager.arrowScroll(View.FOCUS_LEFT);
				break;
			case BTN_NEXT:
				_viewPager.arrowScroll(View.FOCUS_RIGHT);
				break;
			case BTN_END:
				_viewPager.setCurrentItem(CustomPagerAdapter.N - 1);
				break;
			}
		}
	}

}

