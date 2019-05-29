package com.ks.day02.bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by F0519 on 2019/5/29.
 */

public interface Myservice {
    //http://news-at.zhihu.com/api/4/news/hot
    public String url="http://news-at.zhihu.com/api/";
    @GET("4/news/hot")
    Observable<Bean> getData();
}
