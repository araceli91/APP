package windtre.windtre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText emailEt;
    EditText passwordEt;
    EditText phoneNumberEt;

    Button registerBtn;

    boolean emailValidated, passwordValidated, phoneValidated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        emailEt = findViewById(R.id.user_utente);
        passwordEt = findViewById(R.id.pass_utente);
        phoneNumberEt = findViewById(R.id.phone_utente);
        registerBtn = findViewById(R.id.registro_utente);

        emailEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                emailValidated = isValidEmail(editable.toString());
                enableButton();



            }
        });

        phoneNumberEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                phoneValidated = isValidPhone(editable.toString());
                enableButton();
            }
        });


        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                passwordValidated = isValidPassword(editable.toString());
                enableButton();
            }
        });


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEt.getText().toString();
                String password = passwordEt.getText().toString();
                String phoneNumber = phoneNumberEt.getText().toString();

                createAccount(email, password, phoneNumber);

            }
        });

    }

    private boolean isValidPassword(String string) {
        return (string.length() > 6);
    }

    private boolean isValidPhone(String string) {
        return (string.length() == 10);
    }


    private void createAccount(String email, String password, String phoneNumber) {

        // TODO cose
    }


    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }


    private void enableButton() {
            registerBtn.setEnabled((emailValidated && passwordValidated && phoneValidated));
    }


}
