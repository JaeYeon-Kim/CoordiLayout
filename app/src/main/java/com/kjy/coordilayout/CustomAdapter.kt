package com.kjy.coordilayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kjy.coordilayout.databinding.ItemRecyclerBinding

class CustomAdapter: RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<Memo>()
    // 한 화면에 그려지는 아이템 개수 만큼 레이아웃 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(binding)
    }

    // 생성된 아이템 레이아웃에 값 입력 후 목록에 출력
    // 생성된 뷰 홀더를 화면에 보여줌
    // listData에서 현재 위치에 해당하는 메모를 하나 꺼내 memo변수에 저장한 후 홀더에 전달.
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    // 목록에 보여줄 아이템 개수
    override fun getItemCount(): Int {
        return listData.size
    }
}


class Holder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
    fun setMemo(memo:Memo) {
        binding.mainText.text = "${memo.mainText}"
        binding.subText.text="${memo.subText}"
    }

}