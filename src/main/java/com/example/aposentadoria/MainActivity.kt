package com.example.aposentadoria
import android.R
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
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
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        //if ()
        binding.botao.setOnClickListener {
            val sexo = binding.spinner.selectedItem as String
            val idade = binding.edittexto.text.toString().toLongOrNull()
            var resultado: Long
            if (idade != null) {
                if (sexo.trim() == "MASCULINO") {
                    resultado = 65 - idade
                } else {
                    resultado = 62 - idade
                }
                binding.resposta.text = "Os Anos Restantes Para Você Se Aposentar São: $resultado"
                if (resultado <= 0){
                    binding.muitovelho.text = "Você já deveria estar APOSENTADO."
                } else{
                    binding.muitovelho.text = ""
                }
            }else{
                binding.resposta.text ="informe uma idade valida."

            }
        }

    }
    }
