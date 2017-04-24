package packageadapter.eternallyliu.com.baseadapterpackage.Base;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.List;

/**
 * Created by liupei on 2017/4/24.
 */

public abstract class EtCell<T> implements BaseCell{
    public T mData;
    public LayoutInflater inflater;
    public Context mContext;

    //创建cell对象的时候需要把数据传进来
    public EtCell(Context context,T mData) {
        this.mData = mData;
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void releaseResouce() {
        //这里实现了释放资源的方法，如果子类对象有需要的话就可以重写该方法不需要每次都去实现了
    }
}
