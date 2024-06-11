package br.com.ulbra.exemplorecycler.presentation.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.ulbra.exemplorecycler.data.Product
import br.com.ulbra.exemplorecycler.R
import br.com.ulbra.exemplorecycler.databinding.ProductItemBinding
import com.bumptech.glide.Glide

class ProductAdapter(
//    private val list: MutableList<Product>,
    val goToDetails: (product: Product) -> Unit,
    val removeItem: (product: Product) -> Unit,
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var list: List<Product> = emptyList()
    private lateinit var binding: ProductItemBinding
    private lateinit var context: Context


    fun setUpList(list: List<Product>) {
        this.list = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        binding = ProductItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(view: ProductItemBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(product: Product) {
            binding.product = product

            binding.root.setOnClickListener {
                goToDetails(product)
            }

            binding.root.setOnLongClickListener {
                showPopUpMenu(it, position, context)
                true
            }
        }
    }

    private fun showPopUpMenu(view: View, position: Int, context: Context) {
        PopupMenu(context, view).apply {
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.remove -> {
                        removeItem(list[position])
                        true
                    }

                    else -> {
                        Log.i("erro", "erro")
                        false
                    }
                }
            }
            inflate(R.menu.menu_popup)
            show()
        }
    }
}

