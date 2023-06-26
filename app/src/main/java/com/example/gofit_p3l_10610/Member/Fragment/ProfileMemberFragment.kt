package com.example.gofit_p3l_10610.Member.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_p3l_10610.Instruktur.DashboardInstrukturActivity
import com.example.gofit_p3l_10610.Member.*
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentProfileInstrukturBinding
import com.example.gofit_p3l_10610.databinding.FragmentProfileMemberBinding
import com.example.gofit_p3l_10610.izinInstrukturAPI.ClientIzinInstruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.Instruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.ResponseCreateInstruktur
import com.example.gofit_p3l_10610.userAPI.ClientUser
import com.example.gofit_p3l_10610.userAPI.ResponseCreateMember
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileMemberFragment : Fragment() {
    private var _binding: FragmentProfileMemberBinding? = null
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
        _binding = FragmentProfileMemberBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()
        val call: Call<ResponseCreateMember?>? = ClientUser.apiService.getMember(idUser)
        call?.enqueue(object : Callback<ResponseCreateMember?> {
            override fun onResponse(call: Call<ResponseCreateMember?>, response: Response<ResponseCreateMember?>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        binding.txtNama.setText(it.data.NAMA_MEMBER)
                        binding.txtId.setText(it.data.ID_MEMBER)
                        binding.txtAlamat.setText(it.data.ALAMAT_MEMBER)
                        binding.txtTanggalLahir.setText(it.data.TANGGAL_LAHIR_MEMBER)
                        binding.txtNoTelp.setText(it.data.NO_TELEPON_MEMBER)
                        binding.txtEmail.setText(it.data.EMAIL_MEMBER)
                        binding.txtKadaluarsa.setText(it.data.TANGGAL_KADALUARSA_MEMBER)
                        binding.txtDeposit.setText("Rp. " + it.data.SALDO)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseCreateMember?>, t: Throwable) {
            }
        })

        binding.btnPaket.setOnClickListener {
            val intent = Intent(requireActivity(), ReadPaketActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        binding.btnHistoriGym.setOnClickListener {
            val intent = Intent(requireActivity(), FilterHistoryGymActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        binding.btnHistoriKelas.setOnClickListener {
            val intent = Intent(requireActivity(), FilterHistoryActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        return binding.root
    }
}