package windtre.windtre;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView welcomeTW, emailTv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_welcome);

        welcomeTW = findViewById(R.id.welcome_tv);
        emailTv = findViewById(R.id.user_utente);

    }
}