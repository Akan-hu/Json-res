package android.example.assignment

import android.example.assignment.model.Data
import android.example.assignment.model.request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    private val dataList : MutableList<Data> = mutableListOf()
    private lateinit var myAdapter : Adapter
    lateinit var layoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       myAdapter = Adapter(this,dataList)

        recyclerView = findViewById(R.id.recycler_view)
        layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = myAdapter



        //setup recycler view


        //setup android networking
        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://run.mocky.io/v3/4509d8cc-2fe4-439c-9075-b9196c6ac455")
            .build()
            .getAsObject(request::class.java,object : ParsedRequestListener<request>{
                override fun onResponse(response: request?) {
                    if (response != null) {
                        dataList.addAll(response.data)
                        myAdapter.notifyDataSetChanged()
                    }
                    else{
                        Toast.makeText(this@MainActivity,"Error occurred",Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onError(anError: ANError?) {

                }

            })
    }
}