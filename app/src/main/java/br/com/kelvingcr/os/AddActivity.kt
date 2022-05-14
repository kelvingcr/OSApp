package br.com.kelvingcr.os

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.kelvingcr.os.databinding.ActivityAddBinding
import br.com.kelvingcr.os.listeners.ClienteAllListener
import br.com.kelvingcr.os.listeners.TecnicosAllListener
import br.com.kelvingcr.os.model.ClienteModel
import br.com.kelvingcr.os.model.TecnicoModel

class AddActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAddBinding
    private lateinit var mViewModel: AddViewModel
    private var mId: Int = 0

    private var tecnico: TecnicoModel? = null
    private var cliente: ClienteModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this)[AddViewModel::class.java]

        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configClicks()
        observe()

        val bundle = intent.extras


        if(bundle != null) {

            binding.rbCliente.isEnabled = false
            binding.rbTecnico.isEnabled = false
            binding.rbTecnico.isChecked = false


           if(intent!!.getSerializableExtra("tecnico") != null ) {

               tecnico = intent.getSerializableExtra("tecnico") as TecnicoModel

               binding.editNome.setText(tecnico!!.nome)
               binding.editTelefone.setText(tecnico!!.telefone)
               binding.editCpf.setText(tecnico!!.cpf)
               binding.editCpf.isEnabled = false

           } else if (intent.getSerializableExtra("cliente") != null)  {

               cliente = intent.getSerializableExtra("cliente") as ClienteModel

               binding.editNome.setText(cliente!!.nome)
               binding.editTelefone.setText(cliente!!.telefone)
               binding.editCpf.setText(cliente!!.cpf)
               binding.editCpf.isEnabled = false

           }
        }

    }

    private fun observe() {
        mViewModel.save.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, "Criado com sucesso!", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onClick(view: View) {

        var nome = binding.editNome.text.toString()
        var telefone = binding.editTelefone.text.toString()
        var cpf = binding.editCpf.text.toString()
        var opcao = binding.rbTecnico.isChecked


        if(tecnico != null) {
            mViewModel.tecnicoUpdate(tecnico!!.id, TecnicoModel(1, nome, cpf, telefone), object : TecnicosAllListener {
                override fun onResponse(model: List<TecnicoModel>) {
                    println("B")
                }

                override fun onFailure(str: String) {
                    println(str)
                }

            })

            return

        } else if (cliente != null) {
            mViewModel.clienteUpdate(cliente!!.id, ClienteModel(1, nome, cpf, telefone), object : ClienteAllListener {
                override fun onResponse(model: List<ClienteModel>) {

                }

                override fun onFailure(str: String) {
                    println(str)
                }

            })
            return
        }

            if (opcao) {

                val tecnico = TecnicoModel(id = 0, nome, cpf, telefone)
                mViewModel.tecnicoCreate(tecnico, object : TecnicosAllListener {
                    override fun onResponse(model: List<TecnicoModel>) {
                    }

                    override fun onFailure(str: String) {
                        Toast.makeText(applicationContext, str, Toast.LENGTH_LONG).show()
                    }

                })

            } else {

                val cliente = ClienteModel(id = 0, nome, cpf, telefone)

                mViewModel.clienteCreate(cliente, object : ClienteAllListener {
                    override fun onResponse(model: List<ClienteModel>) {
                        Toast.makeText(applicationContext, "Criado com sucesso!", Toast.LENGTH_LONG)
                            .show()
                    }

                    override fun onFailure(str: String) {
                        Toast.makeText(applicationContext, str, Toast.LENGTH_LONG).show()
                    }

                })


        }

    }

   private fun configClicks() {
        binding.button.setOnClickListener(this)
    }
}