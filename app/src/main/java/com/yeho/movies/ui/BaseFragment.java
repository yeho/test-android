package com.yeho.movies.ui;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import com.yeho.movies.R;
import com.yeho.movies.common.MvpPresenter;
import com.yeho.movies.common.MvpView;

/**
 * @author yeho
 *      fecha: 24/04/2018
 */

public class BaseFragment<T extends MvpPresenter> extends Fragment implements MvpView {

    protected T mPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mPresenter != null) mPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) mPresenter.detachView();
    }

    @Override
    public void setProgressIndicator(boolean active) {
        if(active) {
            if (mProgressDialog == null) {
                mProgressDialog = new ProgressDialog(getActivity());
                mProgressDialog.setCancelable(false);
                mProgressDialog.setTitle(null);
                mProgressDialog.setMessage(getString(R.string.loading));
            } else {
                mProgressDialog.show();
            }
        } else  {
            mProgressDialog.hide();
        }

    }

}
