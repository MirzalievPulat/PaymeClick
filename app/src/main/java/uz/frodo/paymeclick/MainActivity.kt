package uz.frodo.paymeclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import uz.frodo.paymeclick.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var list = arrayListOf<Page>(
            Page("Click va Paymega o’tish xizmati",R.drawable.click1),
            Page("Barcha operatorlar bo’yicha statistika",R.drawable.click2),
            Page("Tariflarni filtrlash",R.drawable.click3),
            Page("Yangi imkoniyatlar",R.drawable.click4)
        )

        binding.viewPager.adapter = ClickAdapter(list,supportFragmentManager)
        binding.tab.setupWithViewPager(binding.viewPager)

        binding.textView2.setOnClickListener {
            binding.viewPager.currentItem += 1
        }
        binding.skipButton.setOnClickListener {
            val i = Intent(this,SkipActivity::class.java)
            startActivity(i)
            finish()
        }

        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 3) {
                    binding.textView2.visibility = View.INVISIBLE
                    binding.imageView.visibility = View.INVISIBLE
                } else {
                    binding.textView2.visibility = View.VISIBLE
                    binding.imageView.visibility = View.VISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }


}