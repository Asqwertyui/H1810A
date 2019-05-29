package com.ks.day02.persent;

import com.ks.day02.bean.Bean;
import com.ks.day02.callback.Mycallback;
import com.ks.day02.model.Mymodel;
import com.ks.day02.view.Myview;

/**
 * Created by F0519 on 2019/5/29.
 */

public class Mypersentimpl implements Mypersent, Mycallback {
    private Mymodel mymodel;
    private Myview myview;

    public Mypersentimpl(Mymodel mymodel, Myview myview) {
        this.mymodel = mymodel;
        this.myview = myview;
    }

    @Override
    public void getData() {
        if(mymodel!=null){
            mymodel.getData(this);
        }
    }

    @Override
    public void OnSuccess(Bean bean) {
        if(myview!=null){
            myview.OnSuccess(bean);
        }
    }

    @Override
    public void OnFail(String msg) {
        if(myview!=null){
            myview.OnFail(msg);
        }
    }
}
