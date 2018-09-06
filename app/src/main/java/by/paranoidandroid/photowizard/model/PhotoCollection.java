package by.paranoidandroid.photowizard.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection implements Parcelable {
    private String title;

    private String description;

    @SerializedName("preview_photos")
    private List<PreviewPhoto> previewPhotos;

    private PhotoCollection(Parcel parcel) {
        String[] data = new String[4];
        parcel.writeStringArray(data); //parcel.readStringArray(data);
        title = data[0];
        description = data[1];
        previewPhotos = new ArrayList<>();
        PreviewPhoto previewPhoto = new PreviewPhoto();
        PhotoUrl photoUrl = new PhotoUrl();
        photoUrl.setRegular(data[2]);
        photoUrl.setThumb(data[3]);
        previewPhoto.setUrls(photoUrl);
        previewPhotos.add(previewPhoto);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PreviewPhoto> getPreviewPhotos() {
        return previewPhotos;
    }

    public void setPreviewPhotos(List<PreviewPhoto> previewPhotos) {
        this.previewPhotos = previewPhotos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        String regularUrl =  previewPhotos.get(0).getUrls().getRegular();
        String thumbUrl =  previewPhotos.get(0).getUrls().getThumb();
        parcel.writeStringArray(new String[] {title, description, regularUrl, thumbUrl});
    }

    public static final Creator<PhotoCollection> CREATOR = new Creator<PhotoCollection>() {
        @Override
        public PhotoCollection createFromParcel(Parcel in) {
            return new PhotoCollection(in);
        }

        @Override
        public PhotoCollection[] newArray(int size) {
            return new PhotoCollection[size];
        }
    };
}