package by.paranoidandroid.photowizard.adapters;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import by.paranoidandroid.photowizard.model.PhotoCollection;
import by.paranoidandroid.photowizard.view.ScreenSlidePageFragment;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private List<PhotoCollection> photoCollections;

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
        photoCollections = new ArrayList<>();
    }

    public void updateData(List<PhotoCollection> data) {
        photoCollections = data;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return ScreenSlidePageFragment.newInstance(photoCollections.get(position));
    }

    @Override
    public int getCount() {
        return photoCollections.size();
    }
}