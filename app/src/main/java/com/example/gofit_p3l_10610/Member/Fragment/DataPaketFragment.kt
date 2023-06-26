package com.example.gofit_p3l_10610.Member.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_p3l_10610.BookingKelasAPI.BookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.ClientBookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.ResponseCreateBookingKelas
import com.example.gofit_p3l_10610.Member.BookingKelasAdapter
import com.example.gofit_p3l_10610.Member.DepositKelasMemberAdapter
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentDataBookingKelasBinding
import com.example.gofit_p3l_10610.databinding.FragmentDataPaketBinding
import com.example.gofit_p3l_10610.userAPI.ClientUser
import com.example.gofit_p3l_10610.userAPI.DepositKelasMember
import com.example.gofit_p3l_10610.userAPI.ResponseCreateDepositKelasMember
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataPaketFragment : Fragment() {
    private var _binding: FragmentDataPaketBinding? = null
    private val binding get() = _binding!!
    private val listPaket = ArrayList<DepositKelasMember>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataPaketBinding.inflate(inflater, container, false)
        return binding.root
        getDataPaket()
    }
    override fun onStart() {
        super.onStart()
        getDataPaket()
    }
    private fun getDataPaket() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        val value = bundle?.getString("idUser")
        val nama = bundle?.getString("nama")
        binding.progressBar.visibility
        val call: Call<ResponseCreateDepositKelasMember>? = ClientUser.apiService.getDepositKelasMember(
            value!!
        )
        call?.enqueue(object : Callback<ResponseCreateDepositKelasMember> {
            override fun onResponse(call: Call<ResponseCreateDepositKelasMember>, response: Response<ResponseCreateDepositKelasMember>) {
                if (response.isSuccessful){
                    listPaket.clear()
                    response.body()?.let {
                        listPaket.addAll(it.data)
                    }
                    val adapter = DepositKelasMemberAdapter(listPaket, requireContext(),nama.toString()
                    )
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseCreateDepositKelasMember>, t: Throwable) {
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}