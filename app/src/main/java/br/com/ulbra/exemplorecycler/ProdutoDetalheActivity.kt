package br.com.ulbra.exemplorecycler

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import br.com.ulbra.exemplorecycler.data.Product
import br.com.ulbra.exemplorecycler.databinding.ActivityProdutoDetalheBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class ProdutoDetalheActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProdutoDetalheBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdutoDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        configureToolbar("Detalhe do produto", true)

        val productBundle = if (Build.VERSION.SDK_INT >= 33) {
            intent?.getSerializableExtra("data", Product::class.java)
        } else {
            intent?.getSerializableExtra("data") as? Product
        }

        productBundle?.let { product ->
            binding.product = product
        }
    }
}