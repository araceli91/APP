package windtre.windtre;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int PASSWORD_LENGTH = 5;

    EditText etNome,etPass;
    Button btnLogin;
    public static final String WELCOME ="WELCOME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNome = findViewById(R.id.user_utente);
        etPass = findViewById(R.id.pass_utente);
        btnLogin = findViewById(R.id.login_utente);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(isValidEmail()){
            if(isValidPassword()){
                Intent i = new Intent(this,WelcomeActivity.class);
                String mail = etNome.getText().toString();
                i.putExtra(WELCOME,mail);
                startActivity(i);
            }else{
                Toast.makeText(this, "La password non è valida", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Inserisci una mail", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidEmail() {
        String email = etNome.getText().toString();
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }


    private boolean isValidPassword() {
        String password = etPass.getText().toString();
        return (password.length() > PASSWORD_LENGTH);
    }
}
