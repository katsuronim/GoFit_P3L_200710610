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
import com.example.gofit_p3l_10610.BookingKelasAPI.ClientBookingKelas
import com.example.gofit_p3l_10610.Member.DepositKelasMemberAdapter
import com.example.gofit_p3l_10610.Member.HistoriGymAdapter
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentDataHistoryGymBinding
import com.example.gofit_p3l_10610.databinding.FragmentDataPaketBinding
import com.example.gofit_p3l_10610.userAPI.ClientUser
import com.example.gofit_p3l_10610.userAPI.DepositKelasMember
import com.example.gofit_p3l_10610.userAPI.ResponseCreateDepositKelasMember
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataHistoryGymFragment : Fragment() {
    private var _binding: FragmentDataHistoryGymBinding? = null
    private val binding get() = _binding!!
    private val listHistoryGym = ArrayList<BookingPresensiGym>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataHistoryGymBinding.inflate(inflater, container, false)
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
        val call: Call<ResponseCreateBookingPresensiGym> = ClientGym.apiService.getHistori(
            value!!, tglMulai, tglAkhir
        )
        call?.enqueue(object : Callback<ResponseCreateBookingPresensiGym> {
            override fun onResponse(call: Call<ResponseCreateBookingPresensiGym>, response: Response<ResponseCreateBookingPresensiGym>) {
                if (response.isSuccessful){
                    listHistoryGym.clear()
                    response.body()?.let {
                        listHistoryGym.addAll(it.data)
                    }
                    val adapter = HistoriGymAdapter(listHistoryGym, requireContext(),nama.toString()
                    )
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseCreateBookingPresensiGym>, t: Throwable) {
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}