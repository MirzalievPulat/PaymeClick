package uz.frodo.paymeclick

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import uz.frodo.paymeclick.databinding.ActivityMainBinding
import uz.frodo.paymeclick.databinding.FragmentClickBinding
import kotlin.properties.Delegates

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ClickFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClickFragment : Fragment(){
    lateinit var binding: FragmentClickBinding
    lateinit var param1: Page
    var param2  = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable(ARG_PARAM1)!!
            param2 = it.getInt("int")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClickBinding.inflate(layoutInflater)

        binding.fragmentImage.setImageResource(param1.image)
        binding.textView.text = param1.name

        return binding.root
    }

    companion object {
        fun newInstance(param1: Page,position:Int) =
            ClickFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)
                    putInt("int",position)
                }
            }
    }
}