package com.ks.day02.model;

import android.util.Log;

import com.ks.day02.bean.Bean;
import com.ks.day02.bean.Myservice;
import com.ks.day02.callback.Mycallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by F0519 on 2019/5/29.
 */

public class Mymodelimpl implements Mymodel {
    @Override
    public void getData(final Mycallback mycallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Myservice.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Myservice myservice = retrofit.create(Myservice.class);
        Observable<Bean> data = myservice.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        if(bean!=null){
                            mycallback.OnSuccess(bean);
                        }else {
                            mycallback.OnFail("no");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tga",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("tga","onComplete");
                    }
                });
    }
}
