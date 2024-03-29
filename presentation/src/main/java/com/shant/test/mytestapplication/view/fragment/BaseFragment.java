package com.shant.test.mytestapplication.view.fragment;

import com.shant.test.mytestapplication.di.HasComponent;
import com.shant.test.mytestapplication.utils.NetworkHelper;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * Base {@link Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment {

    @Inject
    NetworkHelper networkHelper;

    protected abstract void requestData(boolean isOffline);

    protected abstract void showRetry();

    public void requestDataFromNetwork() {
        if (networkHelper.isNetworkAvailable()) {
            requestData(false);
        } else {
            requestData(true);
        }
    }

    /**
     * Shows a {@link Toast} message.
     *
     * @param message An string representing a message to be shown.
     */
    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
