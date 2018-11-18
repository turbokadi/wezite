package ca.wezite.wezite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView nom = findViewById(R.id.nomProfile);
        TextView res = findViewById(R.id.resumeProfile);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        nom.setText("Email : " + user.getEmail());
        res.setText("Nom : " + user.getDisplayName());
    }
}
