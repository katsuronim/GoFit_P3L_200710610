package com.example.gofit_p3l_10610.Instruktur.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gofit_p3l_10610.Instruktur.DashboardInstrukturActivity
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentDashboardInstrukturBinding
import com.example.gofit_p3l_10610.userAPI.User


class DashboardInstrukturFragment : Fragment() {
    private var _binding : FragmentDashboardInstrukturBinding? = null
    private val binding get() = _binding!!
    private val listUser = ArrayList<User>()
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

        val activity: DashboardInstrukturActivity? = activity as DashboardInstrukturActivity?
        _binding = FragmentDashboardInstrukturBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser().toString()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()

        binding.namaInstruktur.setText(nama)

        return binding.root
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_dashboard_instruktur, container, false)
    }
}