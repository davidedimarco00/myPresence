package com.app.mypresence.presenter;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.app.mypresence.R;
import com.app.mypresence.model.UserActivityModel;
import com.app.mypresence.model.UserActivityModelInterface;
import com.app.mypresence.view.AdminFragment;
import com.app.mypresence.view.SettingsFragment;
import com.app.mypresence.view.StatisticsFragment;
import com.app.mypresence.view.UserFragment;

public class UserActivityPresenter extends Presenter implements UserActivityPresenterInterface {

    private final AppCompatActivity activity;
    private final UserActivityModelInterface model = new UserActivityModel(this);

    public UserActivityPresenter(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    public void showUserFragment(Class<UserFragment> userFragment) {
        this.showFragment(userFragment);
    }

    @Override
    public void showAdminFragment(Class<AdminFragment> adminFragment) {
        this.showFragment(adminFragment);
    }

    @Override
    public void showStatisticFragment(Class<StatisticsFragment> statisticsFragment) {
        this.showFragment(statisticsFragment);
    }

    @Override
    public void showSettingsFragment(Class<SettingsFragment> settingsFragment) {
        this.showFragment(settingsFragment);
    }

    private void showFragment(Class<? extends Fragment> fragment) {
        this.activity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.anim_left_to_right, R.anim.exit_left_to_right)
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container_view, fragment, null)
                .commit();
    }
}
