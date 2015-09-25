package com.uzairshah.introductorytutorial.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.uzairshah.introductorytutorial.R;

/**
 * Created by venexel on 26/9/15.
 */
public class TutorialAdapter extends PagerAdapter {

    // context of caller activity
    private Context context;

    // array of slide images
    private int[] images;

    // array of colors we will use as slide background
    private String[] colors;

    // layout inflator
    private LayoutInflater inflater;

    public TutorialAdapter(Context context,  int[] images, String[] colors) {
        this.context = context;
        this.images = images;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imgSlide;
        RelativeLayout rlTutorialSlide;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container,
                false);

        imgSlide = (ImageView) itemView.findViewById(R.id.slide);
        rlTutorialSlide = (RelativeLayout) itemView.findViewById(R.id.rl_tutorial_item);
        rlTutorialSlide.setBackgroundColor(Color.parseColor(colors[position]));

        imgSlide.setImageResource(images[position]);
        ((ViewPager) container).addView(itemView,0);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}