package com.view.shinx.horizontalgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

import com.view.shinx.horizontalgridview.adapter.HItemAdapter;
import com.view.shinx.horizontalgv.HorizontalGridView;
import com.view.shinx.horizontalgv.OnChildSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private HorizontalGridView horizontalGridView;

    private HItemAdapter adapter;

    //默认选中的第一个
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horizontalGridView = (HorizontalGridView) findViewById(R.id.horizontal_gv);

        adapter = new HItemAdapter(this);
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            dataList.add("Item " + i);
        }
        adapter.updateData(dataList);
//        horizontalGridView.bringChildToFront();
        horizontalGridView.setAdapter(adapter);
        horizontalGridView.setOnChildSelectedListener(new OnChildSelectedListener() {
            @Override
            public void onChildSelected(ViewGroup parent, View view, int position, long id) {
                // TODO: 2017/4/18 这里可以执行选中动画
                MainActivity.this.position = position;
            }
        });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return handleKeyDownEvent(event) || super.dispatchKeyEvent(event);
    }

    private boolean handleKeyDownEvent(KeyEvent event){
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch (event.getKeyCode()){
                // TODO: 2017/4/18 这里就不分配焦点问题了，直接分配到HorizontalGridView 上
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    if(position <= 0) {
                        // TODO: 2017/4/18 可以执行抖动动画
                        return false;
                    }
                    horizontalGridView.setSelectedPositionSmooth(position - 1);
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    if(position == adapter.getItemCount() - 1){
                        return false;
                    }
                    horizontalGridView.setSelectedPositionSmooth(position + 1);
                    break;
            }
        }
        return false;
    }
}
