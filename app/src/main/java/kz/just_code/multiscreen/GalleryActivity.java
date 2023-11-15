package kz.just_code.multiscreen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView infoTextView;
    private int currentImageIndex = 0;

    private int[] imageResources = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        imageView = findViewById(R.id.imageView);
        infoTextView = findViewById(R.id.infoTextView);
        Button prevButton = findViewById(R.id.prevButton);
        Button nextButton = findViewById(R.id.nextButton);

        updateImageAndInfo();

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviousImage();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextImage();
            }
        });
    }

    private void updateImageAndInfo() {
        if (currentImageIndex >= 0 && currentImageIndex < imageResources.length) {
            imageView.setImageResource(imageResources[currentImageIndex]);
            String infoText = "Image " + (currentImageIndex + 1) + " of " + imageResources.length;
            infoTextView.setText(infoText);
        }
    }

    private void showPreviousImage() {
        if (currentImageIndex > 0) {
            currentImageIndex--;
            updateImageAndInfo();
        }
    }

    private void showNextImage() {
        if (currentImageIndex < imageResources.length - 1) {
            currentImageIndex++;
            updateImageAndInfo();
        }
    }
}