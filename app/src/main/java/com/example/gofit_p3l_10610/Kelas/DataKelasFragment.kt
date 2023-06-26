package com.example.gofit_p3l_10610.Kelas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_p3l_10610.Instruktur.IzinInstrukturAdapter
import com.example.gofit_p3l_10610.KelasAPI.ClientKelas
import com.example.gofit_p3l_10610.KelasAPI.Kelas
import com.example.gofit_p3l_10610.KelasAPI.ResponseCreateKelas
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentDataIzinBinding
import com.example.gofit_p3l_10610.databinding.FragmentDataKelasBinding
import com.example.gofit_p3l_10610.izinInstrukturAPI.ClientIzinInstruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.IzinInstruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.ResponseCreateIzinInstruktur
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataKelasFragment : Fragment() {
    private var _binding: FragmentDataKelasBinding? = null
    private val binding get() = _binding!!
    private val listKelas = ArrayList<Kelas>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataKelasBinding.inflate(inflater, container, false)
        return binding.root
        getDataKelas()
    }
    override fun onStart() {
        super.onStart()
        getDataKelas()
    }
    private fun getDataKelas() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        binding.progressBar.visibility
        val call: Call<ResponseCreateKelas?>? = ClientKelas.apiService.getKelas()
        call?.enqueue(object : Callback<ResponseCreateKelas?> {
            override fun onResponse(call: Call<ResponseCreateKelas?>, response: Response<ResponseCreateKelas?>) {
                if (response.isSuccessful){
                    listKelas.clear()
                    response.body()?.let {
                        listKelas.addAll(it.data)
                    }
                    val adapter = KelasAdapter(listKelas, requireContext())
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseCreateKelas?>, t: Throwable) {
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}