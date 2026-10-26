package com.example.baitapevent

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.baitapevent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edtHoTen.setOnFocusChangeListener { _, focus ->
            if (!focus && binding.edtHoTen.text.isNotBlank())
                Toast.makeText(this, "Da nhap ho ten", Toast.LENGTH_SHORT).show()
        }

        binding.edtMSSV.setOnFocusChangeListener { _, focus ->
            if (!focus && binding.edtMSSV.text.isNotBlank())
                Toast.makeText(this, "Da nhap MSSV", Toast.LENGTH_SHORT).show()
        }

        binding.edtEmail.setOnFocusChangeListener { _, focus ->
            if (!focus && binding.edtEmail.text.isNotBlank())
                Toast.makeText(this, "Da nhap email", Toast.LENGTH_SHORT).show()
        }

        binding.rgGioiTinh.setOnCheckedChangeListener { _, id ->
            val gt = if (id == binding.rbNam.id) "Nam" else "Nu"
            Toast.makeText(this, "Gioi tinh: $gt", Toast.LENGTH_SHORT).show()
        }

        binding.cbFacebook.setOnCheckedChangeListener { _, checked ->
            Toast.makeText(this, if (checked) "Chon Facebook" else "Bo Facebook", Toast.LENGTH_SHORT).show()
        }

        binding.cbInstagram.setOnCheckedChangeListener { _, checked ->
            Toast.makeText(this, if (checked) "Chon Instagram" else "Bo Instagram", Toast.LENGTH_SHORT).show()
        }

        binding.cbTikTok.setOnCheckedChangeListener { _, checked ->
            Toast.makeText(this, if (checked) "Chon TikTok" else "Bo TikTok", Toast.LENGTH_SHORT).show()
        }

        binding.btnDangKy.setOnClickListener {
            val ten = binding.edtHoTen.text.toString().trim()
            val mssv = binding.edtMSSV.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()

            if (ten.isEmpty() || mssv.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Nhap day du thong tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (binding.rgGioiTinh.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Chon gioi tinh", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gt = if (binding.rbNam.isChecked) "Nam" else "Nu"
            val mxh = mutableListOf<String>()

            if (binding.cbFacebook.isChecked) mxh.add("Facebook")
            if (binding.cbInstagram.isChecked) mxh.add("Instagram")
            if (binding.cbTikTok.isChecked) mxh.add("TikTok")

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("hoten", ten)
            intent.putExtra("mssv", mssv)
            intent.putExtra("email", email)
            intent.putExtra("gioitinh", gt)
            intent.putExtra("mangxahoi", mxh.joinToString(", "))

            startActivity(intent)
        }
    }
}