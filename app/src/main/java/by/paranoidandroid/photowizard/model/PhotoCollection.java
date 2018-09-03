package by.paranoidandroid.photowizard.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoCollection {
    private String title;

    private String description;

    @SerializedName("preview_photos")
    private List<PreviewPhoto> previewPhotos;

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
}
