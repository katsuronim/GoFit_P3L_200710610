package com.example.gofit_p3l_10610.Member.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_p3l_10610.BookingGymAPI.BookingPresensiGym
import com.example.gofit_p3l_10610.BookingGymAPI.ClientGym
import com.example.gofit_p3l_10610.BookingGymAPI.ResponseCreateBookingPresensiGym
import com.example.gofit_p3l_10610.BookingKelasAPI.BookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.ClientBookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.ResponseCreateBookingKelas
import com.example.gofit_p3l_10610.Member.HistoriGymAdapter
import com.example.gofit_p3l_10610.Member.HistoryKelasAdapter
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentDataHistoryGymBinding
import com.example.gofit_p3l_10610.databinding.FragmentDataHistoryKelasBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataHistoryKelasFragment : Fragment() {
    private var _binding: FragmentDataHistoryKelasBinding? = null
    private val binding get() = _binding!!
    private val listHistoryKelas = ArrayList<BookingKelas>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataHistoryKelasBinding.inflate(inflater, container, false)
        return binding.root
        getDataHistori()
    }
    override fun onStart() {
        super.onStart()
        getDataHistori()
    }
    private fun getDataHistori() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        val value = bundle?.getString("idUser")
        val nama = bundle?.getString("nama")
        val tglMulai = bundle?.getString("tglMulai")
        val tglAkhir = bundle?.getString("tglAkhir")
        binding.progressBar.visibility
        val call: Call<ResponseCreateBookingKelas> = ClientBookingKelas.apiService.getHistori(
            value!!, tglMulai, tglAkhir
        )
        call?.enqueue(object : Callback<ResponseCreateBookingKelas> {
            override fun onResponse(call: Call<ResponseCreateBookingKelas>, response: Response<ResponseCreateBookingKelas>) {
                if (response.isSuccessful){
                    listHistoryKelas.clear()
                    response.body()?.let {
                        listHistoryKelas.addAll(it.data)
                    }
                    val adapter = HistoryKelasAdapter(listHistoryKelas, requireContext(),nama.toString()
                    )
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseCreateBookingKelas>, t: Throwable) {
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}