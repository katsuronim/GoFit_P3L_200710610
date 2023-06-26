package com.example.gofit_p3l_10610.Member.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_p3l_10610.Member.*
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentBookingGymBinding
import com.example.gofit_p3l_10610.databinding.FragmentBookingKelasBinding

class BookingGymFragment : Fragment() {
    private var _binding : FragmentBookingGymBinding? = null
    private val binding get() = _binding!!
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ft = parentFragmentManager.beginTransaction()
        ft.detach(this).attach(this).commit()

        val activity: DashboardMemberActivity? = activity as DashboardMemberActivity?
        _binding = FragmentBookingGymBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser().toString()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()
        binding.btnBooking.setOnClickListener {
            val intent = Intent(requireActivity(), AddBookingGymActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }
        binding.btnLihat.setOnClickListener{
            val intent = Intent(requireActivity(), ReadBookingGymActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }
        return binding.root
    }
}