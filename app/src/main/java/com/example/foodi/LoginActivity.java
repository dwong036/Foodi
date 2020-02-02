package com.example.foodi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private CoordinatorLayout loginLayout;
    private TextView loginTextView;
    private TextView httpResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginTextView = findViewById(R.id.loginTextView);
        loginLayout = findViewById(R.id.loginLayout);
        httpResponse = findViewById(R.id.http_response);

        loginTextView.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fade_in));
        loginLayout.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.slide_up));
    }

    /**
     * Establish connection to server Tomcat
     * Perform some input validations and proceed to authentication
     *
     * @param v button to click to establish connection
     */
    public void connectToServer(final View v) {
        final String username = usernameEditText.getText().toString();
        final String password = passwordEditText.getText().toString();
        boolean valid1 = true;

        if (username.isEmpty()) {
            usernameEditText.setError(getText(R.string.empty_username));
            valid1 = false;
        }
        if (password.isEmpty()) {
            passwordEditText.setError(getText(R.string.empty_password));
            valid1 = false;
        }
        if (valid1) {
            if(username.equals("hackUCI") && password.equals("2020")) {
                startActivity(new Intent(this, CategoryActivity.class));
                httpResponse.setText("Connected");
            }
            else {
                httpResponse.setText("Try again!");
                loginLayout.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.error_shake));
                this.finish();
            }
        }

        if (!valid1) {
            loginLayout.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.error_shake));
        }
    }
}
