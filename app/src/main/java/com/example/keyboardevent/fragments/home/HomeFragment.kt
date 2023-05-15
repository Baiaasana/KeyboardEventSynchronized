package com.example.keyboardevent.fragments.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.view.ViewCompat
import androidx.navigation.fragment.findNavController
import com.example.keyboardevent.animationUtils.animation_for_view.InsetsWithKeyboardAnimationCallback
import com.example.keyboardevent.animationUtils.animation_for_view.InsetsWithKeyboardCallback
import com.example.keyboardevent.databinding.FragmentBlankBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listeners()
        setUpKeyboard()
        
    }

    private fun setUpKeyboard(){
        val insetsWithKeyboardCallback = InsetsWithKeyboardCallback(requireActivity().window)
        ViewCompat.setOnApplyWindowInsetsListener(binding.rootId2, insetsWithKeyboardCallback)
        ViewCompat.setWindowInsetsAnimationCallback(binding.rootId2, insetsWithKeyboardCallback)

        val insetsWithKeyboardAnimationCallback = InsetsWithKeyboardAnimationCallback(binding.button)
        val insetsWithKeyboardAnimationCallback2 = InsetsWithKeyboardAnimationCallback(binding.btnBottomSheetDialog)
        ViewCompat.setWindowInsetsAnimationCallback(binding.button, insetsWithKeyboardAnimationCallback)
        ViewCompat.setWindowInsetsAnimationCallback(binding.btnBottomSheetDialog, insetsWithKeyboardAnimationCallback2)
//        showSoftKeyboard(binding.input)
    }

    private fun showSoftKeyboard(view: View) {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        view.requestFocus()
        imm?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    private fun listeners(){
        binding.btnBottomSheetDialog.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionBlankFragmentToBottomSheetDialogFragment())
        }
    }

}