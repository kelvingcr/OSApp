package br.com.kelvingcr.os.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.kelvingcr.os.adapter.ClienteAdapter
import br.com.kelvingcr.os.adapter.OSAdapter
import br.com.kelvingcr.os.databinding.FragmentSlideshowBinding
import br.com.kelvingcr.os.listeners.ClienteListeber

class OSFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!
    private lateinit var mViewModel: OSViewModel

    private lateinit var mListener: ClienteListeber
    private val mAdapter: OSAdapter = OSAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        mViewModel = ViewModelProvider(this)[OSViewModel::class.java]

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root


        //RecyclerView
        val recycler = binding.rvOS

        //Definir layout
        recycler.layoutManager = LinearLayoutManager(context)

        //Adapter
        recycler.adapter = mAdapter

        mListener = object : ClienteListeber {
            override fun onClick(id: Int) {

                /*   val intent = Intent(context, GuestFormActivity::class.java)
                val bundle = Bundle()

                bundle.putInt(GuestConstants.GUESTID, id)
                intent.putExtras(bundle)

                startActivity(intent) */

                println("CLIQUEI " + id)

            }
        }
        mAdapter.attachListener(mListener)
        observer()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observer() {
        mViewModel.osList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateOS(it)
        })
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load()
    }
}