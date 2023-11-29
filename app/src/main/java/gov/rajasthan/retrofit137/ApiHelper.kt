package gov.rajasthan.retrofit137

import gov.rajasthan.retrofit137.model.DataModel
import gov.rajasthan.retrofit137.model.DataProductModel
import gov.rajasthan.retrofit137.model.DataWallpaperModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiHelper {

    @GET("quotes")
    fun getQuotes() : Call<DataModel>

    @GET("products")
    fun getProducts() : Call<DataProductModel>

    //@Headers("Authorization : IsdZkUsWondOOmqNkNSFGtBuaoRofOkF8VKuftMElAFV4KDCD2Bi5rPr")
    @GET("search") //?query="car"&per_page=40
    fun getSearchWallpaper(
        @Header("Authorization") Authorization : String,
        @Query("query") query: String,
        @Query("per_page") per_page : Int,
        @Query("color") color : String) : Call<DataWallpaperModel>



    companion object{

        val BASE_URL = "https://dummyjson.com/"
        val BASE_WALL_URL = "https://api.pexels.com/v1/"

        fun getInstance() : ApiHelper{

            val retrofitClient = Retrofit
                .Builder()
                .baseUrl(BASE_WALL_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofitClient.create(ApiHelper::class.java)
        }

    }


}