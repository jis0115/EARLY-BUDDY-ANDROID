package com.devaon.early_buddy_android.feature.route

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devaon.early_buddy_android.R
import com.devaon.early_buddy_android.feature.HomeActivity
import kotlinx.android.synthetic.main.activity_route.*

class RouteActivity : AppCompatActivity() {

    private lateinit var detailList: ArrayList<ArrayList<String>>
    private lateinit var clicked: ArrayList<Boolean>
    private lateinit var routeAdapter: RouteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route)

        makeListItem()
        intent()

    }

    private fun makeListItem() {
        detailList = ArrayList()
        clicked = ArrayList()

        detailList.add(arrayListOf("상계역", "노원역", "창동역", "쌍문역"))
        detailList.add(arrayListOf("노원역", "중계역", "하계역", "공릉역"))
        detailList.add(arrayListOf("건대입구역", "구의역", "동서울역", "잠실나루"))

        clicked.add(false)
        clicked.add(false)
        clicked.add(false)

        routeAdapter = RouteAdapter(this, clicked, detailList)
        act_route_rv_riding_info.adapter = routeAdapter
        act_route_rv_riding_info.layoutManager = LinearLayoutManager(this)
    }

    private fun intent() {
        act_route_iv_back.setOnClickListener {
            var goBack = Intent(this, HomeActivity::class.java)
            startActivity(goBack)
        }
    }
}