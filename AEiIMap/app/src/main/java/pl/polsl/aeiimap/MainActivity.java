package pl.polsl.aeiimap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import pl.polsl.aeiimap.adapters.PagerAdapter;
import pl.polsl.aeiimap.model.DataParser;
import pl.polsl.aeiimap.model.Floor;
import pl.polsl.aeiimap.model.Room;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_view_pager)
    VerticalViewPager viewPager;

    private int currentFloor = PagerAdapter.GROUND_FLOOR;

    @OnClick(R.id.activity_main_floor_up_ib)
    public void onUp() {
        if (currentFloor < 1)
            return;
        currentFloor--;
        viewPager.setCurrentItem(currentFloor);
    }

    @OnClick(R.id.activity_main_floor_down_ib)
    public void onDown() {
        if (currentFloor == PagerAdapter.PAGER_COUNTER - 1)
            return;
        currentFloor++;
        viewPager.setCurrentItem(currentFloor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initPager();
    }

    private void initPager() {
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        currentFloor = PagerAdapter.GROUND_FLOOR;
        viewPager.setCurrentItem(currentFloor);
    }

}
