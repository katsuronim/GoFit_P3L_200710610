package com.example.gofit_p3l_10610.Instruktur.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_p3l_10610.Instruktur.AddIzinActivity
import com.example.gofit_p3l_10610.Instruktur.DashboardInstrukturActivity
import com.example.gofit_p3l_10610.Instruktur.ReadIzinActivity
import com.example.gofit_p3l_10610.databinding.FragmentIzinInstrukturBinding

class IzinInstrukturFragment : Fragment() {
    private var _binding : FragmentIzinInstrukturBinding? = null
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

        val activity: DashboardInstrukturActivity? = activity as DashboardInstrukturActivity?
        _binding = FragmentIzinInstrukturBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser().toString()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()
        binding.btnUpload.setOnClickListener {
            val intent = Intent(requireActivity(), AddIzinActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }
        binding.btnLihat.setOnClickListener{
            val intent = Intent(requireActivity(), ReadIzinActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }
        return binding.root
    }
}