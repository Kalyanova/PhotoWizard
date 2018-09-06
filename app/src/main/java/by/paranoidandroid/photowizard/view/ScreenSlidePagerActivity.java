package by.paranoidandroid.photowizard.view;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import by.paranoidandroid.photowizard.R;
import by.paranoidandroid.photowizard.adapters.ScreenSlidePagerAdapter;
import by.paranoidandroid.photowizard.model.PhotoCollection;
import by.paranoidandroid.photowizard.presenter.MainPresenter;
import by.paranoidandroid.photowizard.presenter.MainPresenterImpl;

public class ScreenSlidePagerActivity extends FragmentActivity implements MainView {
    private final String ARGS_DATA = "args_data";
    private ScreenSlidePagerAdapter pagerAdapter;
    private MainPresenter presenter;
    private ArrayList<PhotoCollection> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        ViewPager pager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        pager.setAdapter(pagerAdapter);

        setupMVP();
        if (savedInstanceState == null) {
            getPhotoCollection();
        } else {
            data = savedInstanceState.getParcelableArrayList(ARGS_DATA);
            if (data != null) {
                pagerAdapter.updateData(data);
            }
        }
    }

    private void setupMVP() {
        presenter = new MainPresenterImpl(this);
    }

    private void getPhotoCollection() {
        presenter.getPhotoCollection();
    }

    @Override
    public void displayResult(List<PhotoCollection> photoCollections) {
        data = (ArrayList<PhotoCollection>) photoCollections;
        pagerAdapter.updateData(photoCollections);
    }

    @Override
    public void displayError(String errorMsg) {
        // TODO: change it!
        Toast.makeText(this, getString(R.string.error, errorMsg), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(ARGS_DATA, data);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        savedInstanceState.getParcelableArrayList(ARGS_DATA);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPause() {
        if (isFinishing()) {
            detachPresenter();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        detachPresenter();
        super.onDestroy();
    }

    private void detachPresenter() {
        if (presenter != null) {
            presenter.detachView();
        }
    }
}