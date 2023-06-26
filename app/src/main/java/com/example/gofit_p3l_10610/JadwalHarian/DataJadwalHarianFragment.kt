package com.example.gofit_p3l_10610.JadwalHarian

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_p3l_10610.Kelas.KelasAdapter
import com.example.gofit_p3l_10610.KelasAPI.ClientKelas
import com.example.gofit_p3l_10610.KelasAPI.Kelas
import com.example.gofit_p3l_10610.KelasAPI.ResponseCreateKelas
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.ClientPresensiInstruktur
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.JadwalHarian
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.ResponseCreateJadwalHarian
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentDataJadwalHarianBinding
import com.example.gofit_p3l_10610.databinding.FragmentDataKelasBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataJadwalHarianFragment : Fragment() {
    private var _binding: FragmentDataJadwalHarianBinding? = null
    private val binding get() = _binding!!
    private val listJadwalHarian = ArrayList<JadwalHarian>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataJadwalHarianBinding.inflate(inflater, container, false)
        return binding.root
        getDataJadwalHarian()
    }
    override fun onStart() {
        super.onStart()
        getDataJadwalHarian()
    }
    private fun getDataJadwalHarian() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        binding.progressBar.visibility
        val call: Call<ResponseCreateJadwalHarian>? = ClientPresensiInstruktur.apiService.getJadwalHarian("blank")
        call?.enqueue(object : Callback<ResponseCreateJadwalHarian?> {
            override fun onResponse(call: Call<ResponseCreateJadwalHarian?>, response: Response<ResponseCreateJadwalHarian?>) {
                if (response.isSuccessful){
                    listJadwalHarian.clear()
                    response.body()?.let {
                        listJadwalHarian.addAll(it.data)
                    }
                    val adapter = JadwalHarianAdapter(listJadwalHarian, requireContext())
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseCreateJadwalHarian?>, t: Throwable) {
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}