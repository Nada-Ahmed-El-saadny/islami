package com.example.islamiapp.ui.main.tabs.quran

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentQuranBinding
import com.example.islamiapp.ui.chapterDetails.chapterDetailsActivity
import com.example.islamiapp.ui.constants

class quran_fragment :Fragment() {
    lateinit var viewBinding: FragmentQuranBinding

    var names = listOf(
        "الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
        ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
        ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
        ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
        ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
        ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
        ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
        ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
        ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
        "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentQuranBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    lateinit var adapter :ChapterNameRecyclerAdapter
    private fun initRecyclerView() {
        adapter = ChapterNameRecyclerAdapter(names)
        adapter.onItemClickListener=
            ChapterNameRecyclerAdapter.OnItemClickListener{position, name ->
            startChapterDetailsScreen(position, name)

        }

        viewBinding.rvQran.adapter = adapter
    }

    private fun startChapterDetailsScreen(index: Int, name: String) {
        val intent = Intent(context, chapterDetailsActivity::class.java)
        // context >>  because i am in a fragment , then , (this) parameter is wrong

        intent.putExtra(constants.EXTRA_CAPTER_INDEX, index+1)
        intent.putExtra(constants.EXTRA_CAPTER_NAME, name)
        startActivity(intent)


    }
}