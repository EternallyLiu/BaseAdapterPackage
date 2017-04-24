package packageadapter.eternallyliu.com.baseadapterpackage.Base;

import android.content.Context;
import android.view.View;

import java.sql.Savepoint;
import java.util.List;

import packageadapter.eternallyliu.com.baseadapterpackage.Base.Cell.EmptyCell;
import packageadapter.eternallyliu.com.baseadapterpackage.Base.Cell.ErrorCell;
import packageadapter.eternallyliu.com.baseadapterpackage.Base.Cell.LoadingCell;
import packageadapter.eternallyliu.com.baseadapterpackage.Base.Cell.LoadingMoreCell;

/**
 * Created by liupei on 2017/4/24.
 */

public class EtSimpleAdapter extends EtBaseAdapter{
    private static final int DATA_LOADING = 0;
    private static final int DATA_EMPTY= 1;
    private static final int DATA_ERROR = 2;
    private static final int DATA_LOADING_MORE = 3;
    private static final int DATA_SHOW = 4;

    private LoadingCell mLoadingCell;
    private LoadingMoreCell mLoadingMoreCell;
    private EmptyCell mEmptyCell;
    private ErrorCell mErrorCell;

    private boolean isLoadMore = false;
    public EtSimpleAdapter(Context context, List mData) {
        super(context, mData);
        mLoadingCell = new LoadingCell(mContext, null);
        mLoadingMoreCell = new LoadingMoreCell(mContext, null);
        mEmptyCell = new EmptyCell(mContext, null);
        mErrorCell = new ErrorCell(mContext, null);
    }

    public void showLoading() {
        clear();
        mData.add(mLoadingCell);
        notifyDataSetChanged();
    }

    public void showLoading(View loadingView) {
        if (loadingView == null) {
            showLoading();
            return;
        }
        clear();
        mLoadingCell.setLoadindView(loadingView);
        mData.add(mLoadingCell);
    }

    //这里有一种不常用的情况：加载数据的cell展示中时，依然保留一定数量的数据
    public void showLoadind(int saveCount) {
        if (saveCount <= 0 || saveCount > mData.size()) {
            return;
        }
        remove(saveCount, mData.size() - saveCount);
        if (mData.contains(mLoadingCell)) {
            remove(mLoadingCell);
        }
        add(mLoadingCell);
    }

    public void hideLoading() {
        if (mData.contains(mLoadingCell)) {
            remove(mLoadingCell);
        }
    }

    public void showError() {
        clear();
        add(mErrorCell);
    }

    //这里有一种不常用的情况：加载数据的cell的过程中如果出错了，依然保留一定数量的数据
    public void showError(int saveCount) {
        if (saveCount <= 0 || saveCount > mData.size()) {
            return;
        }
        remove(saveCount, mData.size() - saveCount);
        if (mData.contains(mErrorCell)) {
            remove(mErrorCell);
        }
        add(mErrorCell);
    }

    public void hideError() {
        if (mData.contains(mErrorCell)) {
            remove(mErrorCell);
        }
    }

    public void showLoadMore() {
        add(mLoadingMoreCell);
        isLoadMore = true;
    }

    public void hideLoadMore() {
        if (mData.contains(mLoadingMoreCell)) {
            return;
        }
        remove(mLoadingMoreCell);
        isLoadMore = false;
    }

    public boolean isLoadMore() {
        return isLoadMore;
    }

    public void showEmpty() {
        clear();
        add(mEmptyCell);
    }

    //这里有一种不常用的情况：加载数据的cell的过程中如果为空，依然保留一定数量的数据
    public void showEmpty(int saveCount) {
        if (saveCount <= 0 || saveCount > mData.size()) {
            return;
        }
        remove(saveCount, mData.size() - saveCount);
        if (mData.contains(mEmptyCell)) {
            remove(mEmptyCell);
        }
        add(mEmptyCell);
    }

    public void hideEmpty() {
        if (mData.contains(mErrorCell)) {
            remove(mErrorCell);
        }
    }
}
