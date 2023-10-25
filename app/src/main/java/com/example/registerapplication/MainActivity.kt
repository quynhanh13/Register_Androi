package com.example.registerapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import android.app.DatePickerDialog

class MainActivity : AppCompatActivity() {
    private lateinit var editTextFirstName: EditText
    private lateinit var editTextLastName: EditText
    private lateinit var editTextDob: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var checkBoxAgree: CheckBox
    private lateinit var buttonRegister: Button
    private lateinit var buttonSelect: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextFirstName = findViewById(R.id.FirstName)
        editTextLastName = findViewById(R.id.LastName)
        editTextDob = findViewById(R.id.dob)
        editTextAddress = findViewById(R.id.adress)
        editTextEmail = findViewById(R.id.email)
        checkBoxAgree = findViewById(R.id.checkBoxAgree)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonSelect = findViewById(R.id.btn_dob)

        // Thêm xử lý cho Selct
        buttonSelect.setOnClickListener {
            showDatePicker()
        }

        buttonRegister.setOnClickListener {
            val firstName = editTextFirstName.text.toString()
            val lastName = editTextLastName.text.toString()
            val dob = editTextDob.text.toString()
            val address = editTextAddress.text.toString()
            val email = editTextEmail.text.toString()
            val agreeToTerms = checkBoxAgree.isChecked

            if (firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() || address.isEmpty() || email.isEmpty()) {
                // Hiển thị thông báo nếu có trường nào đó trống
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            } else if (!agreeToTerms) {
                // Hiển thị thông báo nếu checkbox không được chọn
                Toast.makeText(this, "Bạn cần đồng ý với các điều khoản sử dụng", Toast.LENGTH_SHORT).show()
            } else {

            }
        }
    }

    // Hàm hiển thị DatePickerDialog
    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Xử lý khi ngày được chọn
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val sdf = SimpleDateFormat("dd/MM/yyyy")
                val formattedDate = sdf.format(selectedDate.time)
                editTextDob.setText(formattedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
}
