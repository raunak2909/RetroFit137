package gov.rajasthan.retrofit137

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import gov.rajasthan.retrofit137.databinding.ActivityMainBinding
import gov.rajasthan.retrofit137.model.ColorModel
import gov.rajasthan.retrofit137.model.DataWallpaperModel
import gov.rajasthan.retrofit137.model.WallpaperModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val arrColors = ArrayList<ColorModel>().apply {
        add(ColorModel("F57C00", R.color.orange))
        add(ColorModel("7B1FA2", R.color.purple))
        add(ColorModel("1976D2", R.color.blue))
        add(ColorModel("ACA298", R.color.grey))
        add(ColorModel("C2185B", R.color.pink))
        add(ColorModel("D32F2F", R.color.red))
        add(ColorModel("FFFFFF", R.color.white))
        add(ColorModel("000000", R.color.black))
    }

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerColor.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = RecyclerColorAdapter(this@MainActivity, arrColors)
        }






















        /*apiHelper.getQuotes().enqueue(object : Callback<DataModel>{
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {

                if(response.code()==200){
                    Log.d("Response", response.body()!!.quotes.toString())

                }

            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Log.d("Network Error", "Can't hit API due to ${t.message}")
                t.printStackTrace()
            }

        })

        apiHelper.getProducts().enqueue(object : Callback<DataProductModel>{
            override fun onResponse(
                call: Call<DataProductModel>,
                response: Response<DataProductModel>
            ) {
                if(response.code()==200){
                    Log.d("Response", response.body()!!.products.toString())

                }
            }

            override fun onFailure(call: Call<DataProductModel>, t: Throwable) {
                Log.d("Network Error", "Can't hit API due to ${t.message}")
                t.printStackTrace()
            }

        })*/
    }

    fun getColorWallpaper(colorCode : String){
        var edtSearchValue = binding.edtSearch.text.ifEmpty {
            "nature"
        }

        val apiHelper = ApiHelper.getInstance()

        apiHelper.getSearchWallpaper(
            "IsdZkUsWondOOmqNkNSFGtBuaoRofOkF8VKuftMElAFV4KDCD2Bi5rPr",
            edtSearchValue.toString(),
            50,
            colorCode
        ).enqueue(object : Callback<DataWallpaperModel>{
            override fun onResponse(
                call: Call<DataWallpaperModel>,
                response: Response<DataWallpaperModel>
            ) {
                if(response.code()==200) {
                    Log.d("Response", response.body().toString())

                    binding.recyclerWallPaper.layoutManager = GridLayoutManager(this@MainActivity, 2)
                    binding.recyclerWallPaper.adapter = RecyclerWallAdapter(this@MainActivity, response.body()!!.photos as ArrayList<WallpaperModel>)
                }
            }

            override fun onFailure(call: Call<DataWallpaperModel>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

        })

    }
}