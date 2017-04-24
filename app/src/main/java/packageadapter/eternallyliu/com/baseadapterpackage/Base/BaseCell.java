package packageadapter.eternallyliu.com.baseadapterpackage.Base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by liupei on 2017/4/24.
 * 通过cell对象本身来决定需要使用哪个布局，使用什么数据
 */

public interface BaseCell{
    //释放资源
    public abstract void releaseResouce();

    //获取到当前cell的item类型
    public abstract int getItemType();

    //创建当前cell对应的ViewHolder
    public abstract EtBaseViewHolder onCreateViewHolder(ViewGroup parent,int ViewType);

    //绑定数据
    public abstract void BindData(EtBaseViewHolder holder,int position);
}
