package by.paranoidandroid.photowizard.view;

import java.util.List;

import by.paranoidandroid.photowizard.model.PhotoCollection;

public interface MainView {
    void displayResult(List<PhotoCollection> photoCollections);
    void displayError(String error);
}
