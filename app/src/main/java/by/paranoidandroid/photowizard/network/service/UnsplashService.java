package by.paranoidandroid.photowizard.network.service;

import java.util.List;

import by.paranoidandroid.photowizard.model.PhotoCollection;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UnsplashService {

    @GET("collections/curated")
    Observable<List<PhotoCollection>> getPhotoCollection();
}
