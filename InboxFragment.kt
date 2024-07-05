package id.pinterest.app.inbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import id.pinterest.app.R
import id.pinterest.app.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {

    private var _binding: FragmentInboxBinding? = null
    private val binding get() = _binding!!
    private val messageAdapter by lazy { MessageAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInboxBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMessage.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = messageAdapter

            messageAdapter.submitList(
                listOf(
                    Message(1, "Nadila", "hahaha besok gue upload!!", "18.29"),
                    Message(2, "Andregumilaar", "foto yang mana sih?", "18.00"),
                    Message(3, "Yusrizal", "iya oke", "17.48"),
                    Message(4, "Lala", "gue udah bilang jangan pake foto itu ", "15.13"),
                )
            )
        }

        binding.rlMessages.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_inbox_to_newMessageFragment)
        }

        binding.rlInvite.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_inbox_to_shareFragment)
        }
    }
}