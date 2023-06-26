package com.example.gofit_p3l_10610.ManagerOperasional.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_p3l_10610.Instruktur.DashboardInstrukturActivity
import com.example.gofit_p3l_10610.ManagerOperasional.DashboardMOActivity
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentDashboardInstrukturBinding
import com.example.gofit_p3l_10610.databinding.FragmentDashboardMoBinding
import com.example.gofit_p3l_10610.userAPI.User

class DashboardMOFragment : Fragment() {
    private var _binding : FragmentDashboardMoBinding? = null
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

        val activity: DashboardMOActivity? = activity as DashboardMOActivity?
        _binding = FragmentDashboardMoBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser().toString()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()

        binding.namaMO.setText(nama)

        return binding.root
    }
}