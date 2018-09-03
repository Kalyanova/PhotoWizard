package by.paranoidandroid.photowizard.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.fragment.app.Fragment;
import by.paranoidandroid.photowizard.R;
import by.paranoidandroid.photowizard.model.PhotoCollection;

public class ScreenSlidePageFragment extends Fragment {
    private static final String ARGS_TITLE = "args_title",
            ARGS_DESCR = "args_description",
            ARGS_PREVIEW_PHOTO = "args_preview_photo";

    public static ScreenSlidePageFragment newInstance(PhotoCollection photoCollection) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle bundle = new Bundle(3);
        bundle.putString(ARGS_TITLE, photoCollection.getTitle());
        bundle.putString(ARGS_DESCR, photoCollection.getDescription());
        bundle.putString(ARGS_PREVIEW_PHOTO,
                photoCollection.getPreviewPhotos().get(0).getUrls().getRegular());
        fragment.setArguments(bundle);
        return fragment;
    }

    // TODO: maybe delete it, check whether it will be unnecessary.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        if (getActivity() != null) {
            view.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                startActivity(intent);
            });
        }
        ImageView previewImage = view.findViewById(R.id.iv_preview);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvDescription = view.findViewById(R.id.tv_description);

        String title = getArguments().getString(ARGS_TITLE);
        tvTitle.setText(title);

        String description = getArguments().getString(ARGS_DESCR);
        tvDescription.setText(description);

        String previewPhotoUrl = getArguments().getString(ARGS_PREVIEW_PHOTO);
        Picasso.get()
                .load(Uri.parse(previewPhotoUrl))
                .into(previewImage);
        return view;
    }
}
