package by.paranoidandroid.photowizard.view;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import by.paranoidandroid.photowizard.R;
import by.paranoidandroid.photowizard.adapters.ScreenSlidePagerAdapter;
import by.paranoidandroid.photowizard.model.PhotoCollection;
import by.paranoidandroid.photowizard.presenter.MainPresenter;
import by.paranoidandroid.photowizard.presenter.MainPresenterImpl;

public class ScreenSlidePagerActivity extends FragmentActivity implements MainView {
    private ScreenSlidePagerAdapter pagerAdapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        ViewPager pager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        setupMVP();
        getPhotoCollection();
    }

    private void setupMVP() {
        presenter = new MainPresenterImpl(this);
    }

    private void getPhotoCollection() {
        presenter.getPhotoCollection();
    }

    @Override
    public void displayResult(List<PhotoCollection> photoCollections) {
        pagerAdapter.updateData(photoCollections);
    }

    @Override
    public void displayError(String errorMsg) {
        // TODO: change it!
        Toast.makeText(this, getString(R.string.error, errorMsg), Toast.LENGTH_SHORT).show();
    }
}