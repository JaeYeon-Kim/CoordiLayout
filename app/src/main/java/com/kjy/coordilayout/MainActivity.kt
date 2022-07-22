package com.kjy.coordilayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.kjy.coordilayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // 사용할 데이터 생성
        val data: MutableList<Memo> = loadData()

        var adapter = CustomAdapter()
        adapter.listData = data

        binding.recyclerView.adapter = adapter

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }

    // 50개의 데이터를 만드는 코드
    fun loadData(): MutableList<Memo> {
        // 메서드 안에 리턴할 MutableList 컬렉션을 선언
        val data: MutableList<Memo> = mutableListOf()

        // 50개를 출력하기 위해 반복문 사용
        for (no in 1..50) {
            var mainText = "Item ${no}"
            var subText = "Item ${no} 입니다."
            var memo = Memo(mainText, subText)
            data.add(memo)
        }
        return data


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.coordi_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}