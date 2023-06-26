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
import com.example.gofit_p3l_10610.Member.BookingGymAdapter
import com.example.gofit_p3l_10610.Member.BookingKelasAdapter
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentDataBookingGymBinding
import com.example.gofit_p3l_10610.databinding.FragmentDataBookingKelasBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataBookingGymFragment : Fragment() {
    private var _binding: FragmentDataBookingGymBinding? = null
    private val binding get() = _binding!!
    private val listBookingGym = ArrayList<BookingPresensiGym>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataBookingGymBinding.inflate(inflater, container, false)
        return binding.root
        getDataBooking()
    }
    override fun onStart() {
        super.onStart()
        getDataBooking()
    }
    private fun getDataBooking() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        val value = bundle?.getString("idUser")
        val nama = bundle?.getString("nama")
        binding.progressBar.visibility
        val call: Call<ResponseCreateBookingPresensiGym> = ClientGym.apiService.getBookingUser(value)
        call?.enqueue(object : Callback<ResponseCreateBookingPresensiGym> {
            override fun onResponse(call: Call<ResponseCreateBookingPresensiGym>, response: Response<ResponseCreateBookingPresensiGym>) {
                if (response.isSuccessful){
                    listBookingGym.clear()
                    response.body()?.let {
                        listBookingGym.addAll(it.data)
                    }
                    val adapter = BookingGymAdapter(listBookingGym, requireContext(),nama.toString()
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