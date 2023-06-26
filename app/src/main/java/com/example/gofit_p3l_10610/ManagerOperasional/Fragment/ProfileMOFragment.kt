package com.example.gofit_p3l_10610.ManagerOperasional.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_p3l_10610.ManagerOperasional.DashboardMOActivity
import com.example.gofit_p3l_10610.Member.DashboardMemberActivity
import com.example.gofit_p3l_10610.Member.ReadHistoryGymActivity
import com.example.gofit_p3l_10610.Member.ReadHistoryKelasActivity
import com.example.gofit_p3l_10610.Member.ReadPaketActivity
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentProfileInstrukturBinding
import com.example.gofit_p3l_10610.databinding.FragmentProfileMOBinding
import com.example.gofit_p3l_10610.databinding.FragmentProfileMemberBinding
import com.example.gofit_p3l_10610.userAPI.ClientUser
import com.example.gofit_p3l_10610.userAPI.ResponseCreateMO
import com.example.gofit_p3l_10610.userAPI.ResponseCreateMember
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileMOFragment : Fragment() {
    private var _binding: FragmentProfileMOBinding? = null
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
        _binding = FragmentProfileMOBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()
        val call: Call<ResponseCreateMO?>? = ClientUser.apiService.getMO(idUser)
        call?.enqueue(object : Callback<ResponseCreateMO?> {
            override fun onResponse(call: Call<ResponseCreateMO?>, response: Response<ResponseCreateMO?>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        binding.txtNama.setText(it.data.NAMA_PEGAWAI)
                        binding.txtId.setText(it.data.ID_PEGAWAI)
                        binding.txtAlamat.setText(it.data.ALAMAT_PEGAWAI)
                        binding.txtTanggalLahir.setText(it.data.TANGGAL_LAHIR_PEGAWAI)
                        binding.txtNoTelp.setText(it.data.NO_TELEPON_PEGAWAI)
                        binding.txtEmail.setText(it.data.EMAIL_PEGAWAI)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseCreateMO?>, t: Throwable) {
            }
        })

        return binding.root
    }
}