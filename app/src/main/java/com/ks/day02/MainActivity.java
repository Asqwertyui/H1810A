package com.ks.day02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ks.day02.adapter.Myadaoter;
import com.ks.day02.bean.Bean;
import com.ks.day02.model.Mymodelimpl;
import com.ks.day02.persent.Mypersentimpl;
import com.ks.day02.view.Myview;

import java.util.ArrayList;

//苏清芬
public class MainActivity extends AppCompatActivity implements Myview {

    private RecyclerView mRv;
    private ArrayList<Bean.RecentBean> mRecentBeans;
    private Myadaoter mMyadaoter;
    private Mypersentimpl mMypersentimpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mMypersentimpl = new Mypersentimpl(new Mymodelimpl(), this);
        mMypersentimpl.getData();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRecentBeans = new ArrayList<>();
        mMyadaoter = new Myadaoter(mRecentBeans, this);
        mRv.setAdapter(mMyadaoter);
    }

    @Override
    public void OnSuccess(Bean bean) {
        if(bean!=null){
            mRecentBeans.addAll(bean.getRecent());
            mMyadaoter.notifyDataSetChanged();
        }
    }

    @Override
    public void OnFail(String msg) {
        Log.e("tag",msg);
    }
}
