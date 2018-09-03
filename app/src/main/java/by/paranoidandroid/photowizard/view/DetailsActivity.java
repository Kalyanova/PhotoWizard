package by.paranoidandroid.photowizard.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by.paranoidandroid.photowizard.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_details_mode);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        ImageButton btnClose = findViewById(R.id.img_btn_close);
        btnClose.setOnClickListener(view -> finish());

        Button btnVisitCollection = findViewById(R.id.btn_visit_collection);
        btnVisitCollection.setOnClickListener(view -> {
            // TODO: change it!
            String url = "https://unsplash.com/collections/curated/190?client_id=9d49bfead5a1db3e395bb97bcea8fa1242b1434bf310445fe117511fe7434c9f";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            // Verify the intent will resolve to at least one activity
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });
    }
}