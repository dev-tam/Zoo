package net.torora.jtam.zoo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // load Animals
        listOfAnimals.add(Animal("Baboon","Id at sagittis et, pretium consequat.",R.drawable.baboon,true))
        listOfAnimals.add(Animal("Bulldog","Id at sagittis et, pretium consequat.",R.drawable.bulldog,false))
        listOfAnimals.add(Animal("Panda","Id at sagittis et, pretium consequat.",R.drawable.panda,false))
        listOfAnimals.add(Animal("Swallow Bird","Id at sagittis et, pretium consequat.",R.drawable.swallow_bird,false))
        listOfAnimals.add(Animal("White Tiger","Id at sagittis et, pretium consequat.",R.drawable.white_tiger,true))
        listOfAnimals.add(Animal("Zebra","Id at sagittis et, pretium consequat.",R.drawable.zebra,true))

        adapter = AnimalsAdapter(this,listOfAnimals)
        tvListAnimal.adapter=adapter
    }
    fun delete(index:Int){
        listOfAnimals.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }
    inner class AnimalsAdapter:BaseAdapter{
        var listOfAnimals = ArrayList<Animal>()
        var context:Context?=null
        constructor(context: Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals=listOfAnimals
            this.context=context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            if(animal.isKiller==true){
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_killer_ticket, null)
                myView.tvName.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener {
                    delete(position)
//                    val intent = Intent(context,AnimalInfo::class.java)
//                    intent.putExtra("name",animal.name!!)
//                    intent.putExtra("des",animal.des!!)
//                    intent.putExtra("image", animal.image!!)
//                    context!!.startActivity(intent)
                }
                return myView
            }else {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_ticket, null)
                myView.tvName.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener {
                    delete(position)
//                    val intent = Intent(context,AnimalInfo::class.java)
//                    intent.putExtra("name",animal.name!!)
//                    intent.putExtra("des",animal.des!!)
//                    intent.putExtra("image", animal.image!!)
//                    context!!.startActivity(intent)
                }
                return myView
            }
        }


        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

    }
}
