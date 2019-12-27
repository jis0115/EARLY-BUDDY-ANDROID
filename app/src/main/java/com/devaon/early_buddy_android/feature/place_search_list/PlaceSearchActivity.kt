package com.devaon.early_buddy_android.feature.place_search_list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.devaon.early_buddy_android.R
import com.devaon.early_buddy_android.data.place.GetPlaceData
import kotlinx.android.synthetic.main.activity_place_search.*

class PlaceSearchActivity : AppCompatActivity() {

    private lateinit var placeSearchAdapter: PlaceSearchAdapter
    private var placeDataList = ArrayList<GetPlaceData>()
    private lateinit var searchEdit: EditText
    private  var clearButton: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_search)

        initPlaceSearchList()
        //goToSearchStartPlaceActivity()

    }

    private fun initPlaceSearchList() {
        placeSearchAdapter = PlaceSearchAdapter(this).apply {
            data = listOf(
                GetPlaceData("만수주공10단지아파트 1001동", "인천 남동구 만수동 1043 만수주공10단지아파트 1001", "장승남로 34"),
                GetPlaceData("만수주공10단지아파트 1002동", "인천 남동구 만수동 1043 만수주공10단지아파트 1002", "장승남로 34"),
                GetPlaceData("만수주공10단지아파트 1003동", "인천 남동구 만수동 1043 만수주공10단지아파트 1003", "장승남로 34"),
                GetPlaceData("만수주공10단지아파트 1004동", "인천 남동구 만수동 1043 만수주공10단지아파트 1004", "장승남로 34"),
                GetPlaceData("만수주공10단지아파트 1005동", "인천 남동구 만수동 1043 만수주공10단지아파트 1005", "장승남로 34"),
                GetPlaceData("만수주공10단지아파트 1006동", "인천 남동구 만수동 1043 만수주공10단지아파트 1006", "장승남로 34")
            )
        }
        //test용 데이터
        act_place_search_rv.adapter = placeSearchAdapter
    }

    private fun setData() {
        //데이버 받아오는 함수
        if (placeDataList.isNullOrEmpty()) {
            act_place_search_iv_bird.visibility = View.VISIBLE
            act_place_search_rv.visibility = View.GONE
        } else {
            act_place_search_iv_bird.visibility = View.GONE
            act_place_search_rv.visibility = View.VISIBLE

            //통신할 때 데이터 받아와야함  data =

        }
    }


}