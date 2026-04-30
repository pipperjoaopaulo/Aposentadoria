package com.example.aposentadoria

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val items = listOf("MASCULINO", "FEMININA")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        //if ()
        binding.botao.setOnClickListener {
            val idade = binding.edittexto.text.toString().toLong()
            val sexo = binding.spinner.adapter.toString()
            when{ sexo == "MASCULINO" ->{
                var resultado = 65L - idade
            }
            sexo == "FEMININA" -> {
                var resultado = 62 - idade
            }
            else ->{
                "abc"
            }
            }
            if (resultado > 0L) {
                Log.d("Estimativa de Aposentadoria:", "${resultado}")
            } else if (resultado < 0L) {
                Log.d("Você já deveria estar aposentado:", "${resultado}")
            } else {
                Log.d("Hora da Aposentadoria:", "${resultado}")
            }


        }
    }
}