package com.example.gofit_p3l_10610.ManagerOperasional.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_p3l_10610.BookingKelasAPI.JadwalHarian
import com.example.gofit_p3l_10610.Instruktur.IzinInstrukturAdapter
import com.example.gofit_p3l_10610.ManagerOperasional.PresensiInstrukturAdapter
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.ClientPresensiInstruktur
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.PresensiInstruktur
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.ResponseCreateJadwalHarian
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.ResponseCreatePresensiInstruktur
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentDataIzinBinding
import com.example.gofit_p3l_10610.databinding.FragmentDataPresensiInstrukturBinding
import com.example.gofit_p3l_10610.izinInstrukturAPI.ClientIzinInstruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.IzinInstruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.ResponseCreateIzinInstruktur
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataPresensiInstrukturFragment : Fragment() {
    private var _binding: FragmentDataPresensiInstrukturBinding? = null
    private val binding get() = _binding!!
    private val listJadwalHarian = ArrayList<com.example.gofit_p3l_10610.PresensiInstrukturAPI.JadwalHarian>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataPresensiInstrukturBinding.inflate(inflater, container, false)
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
        val call: Call<ResponseCreateJadwalHarian>? = ClientPresensiInstruktur.apiService.getData("blank")
        call?.enqueue(object : Callback<ResponseCreateJadwalHarian> {
            override fun onResponse(call: Call<ResponseCreateJadwalHarian>, response: Response<ResponseCreateJadwalHarian>) {
                if (response.isSuccessful){
                    listJadwalHarian.clear()
                    response.body()?.let {
                        listJadwalHarian.addAll(it.data)
                    }
                    val adapter = PresensiInstrukturAdapter(listJadwalHarian, requireContext(),nama.toString()
                    )
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseCreateJadwalHarian>, t: Throwable) {
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}