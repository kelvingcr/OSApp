package br.com.kelvingcr.os.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.kelvingcr.os.AddActivity
import br.com.kelvingcr.os.listeners.ClienteListeber
import br.com.kelvingcr.os.adapter.ClienteAdapter
import br.com.kelvingcr.os.databinding.FragmentGalleryBinding

class ClienteFragment : Fragment() {


    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private lateinit var mViewModel: ClienteViewModel

    private lateinit var mListener: ClienteListeber
    private val mAdapter: ClienteAdapter = ClienteAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mViewModel = ViewModelProvider(this)[ClienteViewModel::class.java]

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root


        //RecyclerView
        val recycler = binding.rvClientes

        //Definir layout
        recycler.layoutManager = LinearLayoutManager(context)

        //Adapter
        recycler.adapter = mAdapter

        mListener = object : ClienteListeber {
            override fun onClick(id: Int) {

                val object1 = mViewModel.clienteList.value!!.filter { it.id == id }
                val cliente = object1[0]

                val intent = Intent(context, AddActivity::class.java)

                intent.putExtra("cliente", cliente)
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
        mViewModel.clienteList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateCliente(it)
        })
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load()
    }
}