package br.com.pokedex_android.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.pokedex_android.R
import br.com.pokedex_android.domain.Pokemon

class PokemonAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) = with(itemView) {
            val ivPokemonImage = findViewById<ImageView>(R.id.ivPokemonImage)
            val tvPokemonNumber = findViewById<TextView>(R.id.tvPokemonNumber)
            val tvPokemonName = findViewById<TextView>(R.id.tvPokemonName)
            val tvPokemonType1 = findViewById<TextView>(R.id.tvPokemonType1)
            val tvPokemonType2 = findViewById<TextView>(R.id.tvPokemonType2)

            // TODO: Load image with Glide

            tvPokemonNumber.text = "Nº ${item.formattedNumber}"
            tvPokemonName.text = item.name
            tvPokemonType1.text = item.types[0].name

            if (item.types.size > 1) {
                tvPokemonType2.text = item.types[1].name
                tvPokemonType2.visibility = View.VISIBLE
            } else {
                tvPokemonType2.visibility = View.GONE
            }
        }
    }
}