package ya.example.manga4;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class CustomPagerAdapter extends PagerAdapter {
	
	public final static int N = 4;
	private LayoutInflater _inflater = null;

	public CustomPagerAdapter(Context c) {
		super();
		_inflater = (LayoutInflater) c
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		
		System.out.println("THIS THING HERE");
		
		LinearLayout layout = (LinearLayout) _inflater.inflate(R.layout.page, null);
		int brt = 255*position/N;
		layout.setBackgroundColor(Color.rgb(brt,brt,brt));//�K���ɐF���Z�b�g(���Ȃ��Ă���)
		ImageView img = (ImageView) layout.findViewById(R.id.img_scroll);
		//int rsrc[] = { R.drawable.sample1, R.drawable.sample2, R.drawable.sample3, R.drawable.sample4 };
		//img.setImageResource(rsrc[position]);
		ImageView iv = MyGalleryActivity.images[position];
		img.setImageDrawable(iv.getDrawable());
		container.addView(layout);
		return layout;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((View) object);
	}

	@Override
	public int getCount() {
		return N;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.equals(object);
	}
}