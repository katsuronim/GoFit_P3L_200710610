package com.example.gofit_p3l_10610.Instruktur.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_p3l_10610.Instruktur.IzinInstrukturAdapter
import com.example.gofit_p3l_10610.databinding.FragmentDataIzinBinding
import com.example.gofit_p3l_10610.izinInstrukturAPI.ClientIzinInstruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.IzinInstruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.ResponseCreateIzinInstruktur
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataIzinFragment : Fragment() {
    private var _binding: FragmentDataIzinBinding? = null
    private val binding get() = _binding!!
    private val listIzinInstruktur = ArrayList<IzinInstruktur>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataIzinBinding.inflate(inflater, container, false)
        return binding.root
        getDataIzin()
    }
    override fun onStart() {
        super.onStart()
        getDataIzin()
    }
    private fun getDataIzin() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        val value = bundle?.getString("idUser")
        val nama = bundle?.getString("nama")
        binding.progressBar.visibility
        val call: Call<ResponseCreateIzinInstruktur> = ClientIzinInstruktur.apiService.getIzin(value)
        call?.enqueue(object : Callback<ResponseCreateIzinInstruktur> {
            override fun onResponse(call: Call<ResponseCreateIzinInstruktur>, response: Response<ResponseCreateIzinInstruktur>) {
                if (response.isSuccessful){
                    listIzinInstruktur.clear()
                    response.body()?.let {
                        listIzinInstruktur.addAll(it.data)
                    }
                    val adapter =IzinInstrukturAdapter(listIzinInstruktur, requireContext(),nama.toString()
                    )
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
            }
        }

            override fun onFailure(call: Call<ResponseCreateIzinInstruktur>, t: Throwable) {
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}