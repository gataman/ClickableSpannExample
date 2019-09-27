package com.gurcanataman.clickablespannexample

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.BackgroundColorSpan
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Matcher
import java.util.regex.Pattern



class MainActivity : AppCompatActivity(), IClickSpannableListener {


    private lateinit var turkceListe:List<String>
    private lateinit var inglizceListe:List<String>
    private lateinit var cevrilecekMetin:SpannableString
    val spannRenkVer by lazy { BackgroundColorSpan(Color.LTGRAY) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ingilizceHikaye = "In ancient times, ships didn’t have any engines. They had sails. The wind pushed the sails and the ships sailed away. The sailors discovered new countries. They wrote books about their discoveries. Gulliver was a doctor on a ship. One day there was a very bad storm. The ship hit a rock and broke into pieces. All the crew in the ship except Gulliver drowned and sank in the sea. Gulliver swam to the shore. He was very tired. He went to sleep. When he woke up, he could not move. Because he was tied to the ground with a rope. His long hair was pinned to the ground. Some little creatures climbed on his hips, waist, chest, neck, chin, lips, tongue, moustache, chick, eye-lid, eye-lash, eye-brow, and fore-head. Gulliver gave a loud shout. All the little creatures ran away. They shot their little arrows into Gulliver. But they didn’t hurt him. They wanted to speak to Gulliver. So they made a platform. They stood on the platform. They talked to Gulliver. Gulliver wanted some food. Because he was hungry. They gave Gulliver some food, vegetables, and fruit. Gulliver put them in his mouth. He chewed and swallowed them. They went through his throat into his stomach. His stomach digested the food. The food changed into blood. The blood went through his vessels to his heart. His heart pumped the blood to his lungs, liver, kidneys and brain. Gulliver opened his eyes. They put wheels under the platform. They put Gulliver on the platform. Five hundred horses pulled the platform. There were a lot of guards around it. They were carrying torches. They went to another city. Because their king lived there. There were small houses there. Gulliver had to crawl (creep) into the houses. so they built a big house for Gulliver. They joined five hundred mattresses. They made a big mattress. Gulliver went to bed. They next morning he woke up refreshed. A man came to Gulliver. And pointed at an island in the middle of the sea. He said, “The people living on that island are our enemies. Tomorrow they are going to attack us. “Gulliver said,”Don’t worry. I will help you. Gulliver took iron bars and bent them. He made them hooks. He tied string[thread] to them. He went to the island. He pulled them to the shore. They became very happy. Just then the king came. He wanted all the enemy ships. But Gulliver didn’t like war, he liked peace. The king and the little people got angry with Gulliver. They wanted to kill Gulliver.So he got into a ship and sailed away. He didn’t come back again"
        val turkceHikaye = "Eski zamanlarda, gemilerin motorları yoktu. Yelkenleri vardı. Yelkenleri rüzgâr ittiriyordu ve gemiler denize açılıyordu. Gemiciler yeni ülkeler keşfettiler. Keşifleri hakkında kitaplar yazdılar. Gulliver bir gemide doktordu. Bir gün kötü bir fırtına çıktı. Gemi bir kayaya çarptı ve parçalara ayrıldı. Gemide Gulliver haricindeki tüm mürettebat denize battı ve boğuldu. Guliver kıyıya yüzdü. Çok yorgundu. Uykuya daldı. Uyandığında, kıpırdayamıyordu. Çünkü yere iplerle bağlanmıştı. Uzun saçları yere tutturulmuştu. Bazı küçük yaratıklar onun kalçalarına, beline, göğsüne, boynuna, çenesine, dudaklarına, diline, bıyığına, yanaklarına, göz kapaklarına, kirpiklerine, kaşlarına, alnına tırmandılar. Guliver yüksek  sesle bağırdı. Bütün küçük yaratıklar kaçtı. Küçük oklarını Gulliver’e attılar. Ama onlar onu acıtamadılar. Gulliver’le konuşmak istediler. Böylece bir platform yaptılar. Platformun üzerinde dikildiler. Gulliver’le konuştular. Guliver biraz yiyecek istedi. Çünkü o açtı. Onlar Gulliver’e biraz sebze meyve ve yiyecek verdi. Guliver onları ağzına koydu. Onları çiğnedi ve yuttu. Boğazından midesine gittiler. Midesi yemekleri sindirdi. Yiyecekler kana dönüştü. Kan damarlarından kalbine gitti. Kalbi, kanı akciğerine, karaciğerine, böbreklerine ve beynine pompaladı. Gulliver gözlerini açtı. Platformun altına tekerlekler koydular. Gulliver’i platforma koydular. Beş yüz at platformu çekti. Etraflarında pek çok muhafız vardı. Onlar meşale taşıyorlardı. Başka bir şehre gittiler. Çünkü onların kralları orda yaşıyordu. Orada küçük evler vardı. Gulliver küçük evlere sürünerek girmek zorunda kalmıştı. O yüzden Gulliver’e büyük bir ev inşa ettiler. Beş yüz döşeği birleştirdiler. Büyük bir döşek yaptılar. Gulliver uyudu. Ertesi gün dinlenmiş olarak kalktı. Bir adam Gulliver’in yanına geldi. Ve denizin ortasındaki bir adayı gösterdi. O adada yaşayan insanlar bizim düşmanımız dedi. Yarın bize saldıracaklar. Gulliver üzülmeyin dedi. Size yardım edeceğim. Gulliver demir çubuklar aldı ve onları eğdi. Onları kanca yaptı. Onlara ip bağladı. Adaya gitti. Onları kıyıya çekti. Çok mutlu oldular. O sırada kral geldi. o bütün düşman gemilerini istedi. Ama Gulliver savaşı sevmiyordu, barışı seviyordu. Kral ve diğer insanlar Gulliver’e kızdılar. Gulliver’i öldürmek istediler. Bir gemiye bindi ve uzaklaştı. Bir daha geri gelmedi"
        listeleriDoldur(ingilizceHikaye,turkceHikaye)
        metniAyir(ingilizceHikaye,true)
        switchTranslateMode(ingilizceHikaye,turkceHikaye)
    }

    private fun switchTranslateMode(ingilizceHikaye: String, turkceHikaye: String) {
        switchMode.setOnCheckedChangeListener{ _: CompoundButton, isChecked: Boolean ->
            if(isChecked){
                metniAyir(ingilizceHikaye,false)
            }else{
                metniAyir(ingilizceHikaye,true)
            }
        }
    }


    // Interface override edildi.
    override fun onClickCumle(text: String, starts: Int, ends: Int) {
        cevrilecekMetin.removeSpan(spannRenkVer)
        cevrilecekMetin.setSpan(spannRenkVer, starts, ends, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvSpannable.text = cevrilecekMetin

        cumleCevir(text)

    }

    override fun onClickKelime(text: String, starts: Int, ends: Int) {
        cevrilecekMetin.removeSpan(spannRenkVer)
        cevrilecekMetin.setSpan(spannRenkVer, starts, ends, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvSpannable.text = cevrilecekMetin

        kelimeCevir(text)

    }

    private fun listeleriDoldur(ingilizceHikaye: String, turkceHikaye: String) {
        turkceListe = turkceHikaye.split(".")
        inglizceListe = ingilizceHikaye.split(".")
    }

    private fun metniAyir(metinGelen: String, isCumle:Boolean) {
        tvTranslate.text = ""
        cevrilecekMetin = SpannableString(metinGelen)
        val ayirac: Matcher? = if(isCumle) {
            Pattern.compile("([^.]+[^ .])").matcher(cevrilecekMetin)
        }else{
            Pattern.compile("([^ .?”!“\",]+[^.?”!“,\"])").matcher(cevrilecekMetin)
        }

        while (ayirac!!.find()) {
            val ingilizceCumle = ayirac.group(0)
            cevrilecekMetin.setSpan(
                SpecialClickableSpan(ingilizceCumle, this, ayirac.start(), ayirac.end(),isCumle),
                ayirac.start(),
                ayirac.end(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        }

        tvSpannable.setText(cevrilecekMetin, TextView.BufferType.SPANNABLE)
        tvSpannable.movementMethod = LinkMovementMethod.getInstance()
        tvSpannable.highlightColor = Color.TRANSPARENT

    }

    private fun cumleCevir(ingilizceCumle: String) {

        for(i in inglizceListe.indices){
            if (inglizceListe[i].contains(ingilizceCumle)){
                tvTranslate.text=turkceListe[i]
            }
        }

    }

    private fun kelimeCevir(text: String) {
        tvTranslate.text = text
    }


}
