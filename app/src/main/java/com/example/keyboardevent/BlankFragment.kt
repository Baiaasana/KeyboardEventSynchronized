package com.example.keyboardevent

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.view.ViewCompat
import com.example.keyboardevent.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

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

        val insetsWithKeyboardCallback = InsetsWithKeyboardCallback(requireActivity().window)
        ViewCompat.setOnApplyWindowInsetsListener(binding.rootId2, insetsWithKeyboardCallback)
        ViewCompat.setWindowInsetsAnimationCallback(binding.rootId2, insetsWithKeyboardCallback)

        val insetsWithKeyboardAnimationCallback = InsetsWithKeyboardAnimationCallback(binding.button)
        ViewCompat.setWindowInsetsAnimationCallback(binding.button, insetsWithKeyboardAnimationCallback)

        showSoftKeyboard(binding.input)
    }

    private fun showSoftKeyboard(view: View) {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        view.requestFocus()
        imm?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

}