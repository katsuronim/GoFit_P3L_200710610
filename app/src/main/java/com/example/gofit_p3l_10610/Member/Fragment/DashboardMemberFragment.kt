package com.example.gofit_p3l_10610.Member.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_p3l_10610.Instruktur.DashboardInstrukturActivity
import com.example.gofit_p3l_10610.Member.DashboardMemberActivity
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentDashboardInstrukturBinding
import com.example.gofit_p3l_10610.databinding.FragmentDashboardMemberBinding
import com.example.gofit_p3l_10610.userAPI.User

class DashboardMemberFragment : Fragment() {
    private var _binding : FragmentDashboardMemberBinding? = null
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
        _binding = FragmentDashboardMemberBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()

        binding.namaMember.setText(nama)

        return binding.root
    }
}