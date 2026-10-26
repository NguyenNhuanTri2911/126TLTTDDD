package com.example.baitapevent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baitapevent.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ten = intent.getStringExtra("hoten")
        val mssv = intent.getStringExtra("mssv")
        val email = intent.getStringExtra("email")
        val gt = intent.getStringExtra("gioitinh")
        val mxh = intent.getStringExtra("mangxahoi")

        binding.tvChiTiet.text = """
            Ho ten: $ten
            Ma sinh vien: $mssv
            Email: $email
            Gioi tinh: $gt
            Mang xa hoi: ${mxh?.ifBlank { "Chua chon" } ?: "Chua chon"}
        """.trimIndent()

        binding.btnQuayLai.setOnClickListener {
            finish()
        }
    }
}