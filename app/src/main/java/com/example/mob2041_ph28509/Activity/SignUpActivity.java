package com.example.mob2041_ph28509.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.mob2041_ph28509.DAO.ThanhVienDAO;
import com.example.mob2041_ph28509.Model.ThanhVien;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mob2041_ph28509.databinding.ActivitySignUpBinding;

import com.example.mob2041_ph28509.R;

import org.apache.commons.validator.routines.EmailValidator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

public class SignUpActivity extends AppCompatActivity {

    private EditText etSignUpDate,etSignUpEmail,etSignUpHoTen,etSignUpPass,etSignUpDC,etSignUpPhone;
    private Button btnSignUp;
    private TextView tv_LogIn;
    private ThanhVienDAO thanhVienDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etSignUpDate = findViewById(R.id.ed_SignUpDate);
        etSignUpEmail = findViewById(R.id.ed_SignUpEmail);
        etSignUpHoTen = findViewById(R.id.ed_SignUpHoTen);
        etSignUpPass = findViewById(R.id.ed_SignUpPassword);
        etSignUpDC = findViewById(R.id.ed_SignUpDC);
        etSignUpPhone = findViewById(R.id.ed_SignUpSDT);
        btnSignUp = findViewById(R.id.btn_SignUp);
        tv_LogIn = findViewById(R.id.tv_logIn);
        thanhVienDAO = new ThanhVienDAO(SignUpActivity.this);
        thanhVienDAO.open();
        EmailValidator validator = EmailValidator.getInstance(true, false);
        String namePattern = "^([\\p{L}']+(\\s[\\p{L}']+)*)+$";
        String phonePattern = "^(0[2|3|5|7|8|9])+([0-9]{8})$";

        etSignUpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etSignUpDate.getText().toString().isEmpty() || etSignUpEmail.getText().toString().isEmpty() || etSignUpHoTen.getText().toString().isEmpty() || etSignUpPass.getText().toString().isEmpty() || etSignUpDC.getText().toString().isEmpty() || etSignUpPhone.getText().toString().isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Hãy điền đầy đủ thông tin cần thiết", Toast.LENGTH_SHORT).show();
                } else if (!validator.isValid(etSignUpEmail.getText().toString().trim())) {
                    Toast.makeText(SignUpActivity.this, "Email không đúng định dạng", Toast.LENGTH_SHORT).show();
                } else if (!etSignUpHoTen.getText().toString().trim().matches(namePattern))  {
                    Toast.makeText(SignUpActivity.this, "Họ và tên không đúng định dạng(Viết hoa những chữ cái đầu)", Toast.LENGTH_SHORT).show();
                } else if (!etSignUpPhone.getText().toString().trim().matches(phonePattern)) {
                    Toast.makeText(SignUpActivity.this, "Số điện thoại không đúng định dạng", Toast.LENGTH_SHORT).show();
                } else {
                    ThanhVien thanhVien = new ThanhVien();
                    thanhVien.setEmail(etSignUpEmail.getText().toString().trim());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        thanhVien.setNgaysinh(LocalDate.parse(etSignUpDate.getText().toString().trim()));
                    }
                    thanhVien.setSdt(Integer.parseInt(etSignUpPhone.getText().toString().trim()));
                    thanhVien.setMatkhau(etSignUpPass.getText().toString().trim());
                    thanhVien.setDiachi(etSignUpDC.getText().toString().trim());
                    thanhVien.setHoten(etSignUpHoTen.getText().toString().trim());
                    long res = thanhVienDAO.insertNew(thanhVien);
                    if (res != 0 ){
                        Toast.makeText(SignUpActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUpActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                    }

                    
                }
            }
        });
        tv_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                SignUpActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String formattedDate = dateFormat.format(calendar.getTime());
                        etSignUpDate.setText(formattedDate);
                    }
                }, year, month, dayOfMonth);
        datePickerDialog.show();
    }

}