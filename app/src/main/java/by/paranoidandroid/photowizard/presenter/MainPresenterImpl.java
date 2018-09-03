package by.paranoidandroid.photowizard.presenter;

import android.util.Log;

import java.util.List;

import androidx.annotation.NonNull;
import by.paranoidandroid.photowizard.common.MainApplication;
import by.paranoidandroid.photowizard.model.PhotoCollection;
import by.paranoidandroid.photowizard.view.MainView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenterImpl implements MainPresenter {
    private String TAG = "MainPresenterImpl";
    private MainView mainView;

    public MainPresenterImpl(MainView mv) {
        this.mainView = mv;
    }

    @Override
    public void getPhotoCollection() {
        getObservable().subscribeWith(getObserver());
    }

    private Observable<List<PhotoCollection>> getObservable(){
        return MainApplication.getApi()
                .getPhotoCollection()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<List<PhotoCollection>> getObserver(){
        return new DisposableObserver<List<PhotoCollection>>() {

            @Override
            public void onNext(@NonNull List<PhotoCollection> photoCollections) {
                Log.d(TAG,"OnNext, collection size: " + photoCollections.size());
                mainView.displayResult(photoCollections);
            }

            @Override
            public void onError(@NonNull Throwable error) {
                Log.d(TAG,"Error: " + error.getMessage());
                mainView.displayError("Error fetching data: " + error.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}