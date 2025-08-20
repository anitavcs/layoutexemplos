class MainActivity : AppCompatActivity() {

    private val listaRecycler = listOf(
        Item("Item 1", "Subtítulo 1"),
        Item("Item 2", "Subtítulo 2"),
        Item("Item 3", "Subtítulo 3"),
        Item("Item 4", "Subtítulo 4"),
        Item("Item 5", "Subtítulo 5")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewExample)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MeuAdapter(listaRecycler)
    }
}

data class Item(val titulo: String, val subtitulo: String)

class MeuAdapter(private val lista: List<Item>) :
    RecyclerView.Adapter<MeuAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo: TextView = view.findViewById(R.id.textTitulo)
        val subtitulo: TextView = view.findViewById(R.id.textSubtitulo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lista[position]
        holder.titulo.text = item.titulo
        holder.subtitulo.text = item.subtitulo
    }
}
