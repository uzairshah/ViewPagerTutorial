package com.uzairshah.introductorytutorial.activities;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.uzairshah.introductorytutorial.R;
import com.uzairshah.introductorytutorial.adapters.TutorialAdapter;
import com.viewpagerindicator.CirclePageIndicator;

public class TutorialActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener{

    // declaration of global variables
    private ViewPager viewPager;
    private PagerAdapter adapter;

    // Skip button will be used to skip tutorial if user is not interested to view full tutorial
    private Button btnSkip;

    // finish button will be displayed when user will complete tutorial, enabling user to navigate to home screen.
    private Button btnFinish;

    // Array of Resource images ids
    private int[] images;
    private String[] colors;

    // In this demo we are using CirclePageIndicator, you can use other if you want
    private CirclePageIndicator titleIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        // initialization of skip and finish buttons
        btnFinish = (Button) findViewById(R.id.btn_finish);
        btnSkip   = (Button) findViewById(R.id.btn_skip);

        // populate array of images to be shown
        images = new int[] { R.drawable.slide_1,R.drawable.slide_2,R.drawable.slide_3};
        colors = new String[]{"#ad6ddf","#28bb83","#595963"};

        // Locate View pager in activity tutorial
        viewPager = (ViewPager) findViewById(R.id.pager);

        // Pass results to ViewPagerAdapter Class
        adapter = new TutorialAdapter(TutorialActivity.this,images,colors);
        // Binds the Adapter to the ViewPager
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);

//        TitlePageIndicator titleIndicator = (TitlePageIndicator)findViewById(R.id.titles);
        titleIndicator = (CirclePageIndicator)findViewById(R.id.titles);
        titleIndicator.setViewPager(viewPager,0);
        viewPager.setOnPageChangeListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tutorial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        // check if showing last slide, hide skip button and show finish buton

        if (position == 2){
            btnSkip.setVisibility(View.INVISIBLE);
            btnFinish.setVisibility(View.VISIBLE);

        }else{
            // if user is not on last slide show skip button
            btnSkip.setVisibility(View.VISIBLE);
            btnFinish.setVisibility(View.INVISIBLE);
        }

        // select current position of title indicator
        titleIndicator.setCurrentItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void finishTutorial(View view) {
        // implement finish functionality
    }

    public void skipTutorial(View view) {

        // implement skip functionality here
    }
}
