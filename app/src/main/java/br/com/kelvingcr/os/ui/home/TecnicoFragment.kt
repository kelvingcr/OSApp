package br.com.kelvingcr.os.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.kelvingcr.os.AddActivity
import br.com.kelvingcr.os.AddViewModel
import br.com.kelvingcr.os.adapter.ClienteAdapter
import br.com.kelvingcr.os.adapter.TecnicoAdapter
import br.com.kelvingcr.os.databinding.FragmentHomeBinding
import br.com.kelvingcr.os.listeners.ClienteListeber
import br.com.kelvingcr.os.model.TecnicoModel
import br.com.kelvingcr.os.ui.gallery.ClienteViewModel
import java.io.Serializable

class TecnicoFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var mViewModel: TecnicoViewModel

    private lateinit var mListener: ClienteListeber
    private val mAdapter: TecnicoAdapter = TecnicoAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mViewModel = ViewModelProvider(this)[TecnicoViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //RecyclerView
        val recycler = binding.rvTecnicos

        //Definir layout
        recycler.layoutManager = LinearLayoutManager(context)

        //Adapter
        recycler.adapter = mAdapter

        mListener = object : ClienteListeber {
            override fun onClick(id: Int) {

                val object1 = mViewModel.tecnicoList.value!!.filter { it.id == id }
                val tecnico = object1[0]

                val intent = Intent(context, AddActivity::class.java)

                intent.putExtra("tecnico", tecnico)
                startActivity(intent)

            }

            override fun onDelete(id: Int) {
                context?.let { mViewModel.delete(id, it) }
                mViewModel.load()
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
        mViewModel.tecnicoList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateTecnico(it)
        })
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load()
    }
}