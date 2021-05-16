package dalian.razvan.cucer.githubandroidrepos.core.baseClasses

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import dalian.razvan.cucer.githubandroidrepos.screens.GitHubAndroidReposActivity

abstract class BaseFragment: Fragment(), BaseFragmentView {

    protected var wasPaused = false
    protected lateinit var appActivity: GitHubAndroidReposActivity

    abstract fun whichLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            appActivity = it as GitHubAndroidReposActivity
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
                = inflater.inflate(whichLayout(), container, false)

    override fun onPause() {
        super.onPause()
        wasPaused = true
    }

    override fun showProgressBar(show: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showPopup(text: String, onClickListener: DialogInterface.OnClickListener?, onDismissClickListener: DialogInterface.OnDismissListener?) {
        val alertDialogBuilder = AlertDialog.Builder(appActivity)
        alertDialogBuilder.setTitle("")
        alertDialogBuilder.setMessage(text)
        alertDialogBuilder.setPositiveButton(resources.getString(android.R.string.ok)) { dialog: DialogInterface?, which: Int ->
            onClickListener?.onClick(dialog, which)
            dialog?.dismiss()
        }
        alertDialogBuilder.setOnDismissListener { dialog: DialogInterface? ->
            onDismissClickListener?.onDismiss(dialog)
            dialog?.dismiss()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.setOnShowListener { dialog: DialogInterface? ->

        }
        alertDialog.show()
    }

    override fun showPopup(text: String) {
        showPopup(text, null, null)
    }

    override fun showPopup(resId: Int) {
        showPopup(resources.getString(resId))
    }

    override fun goBack() {
        view?.let {
            val navController = Navigation.findNavController(it)
            if (navController.previousBackStackEntry == null) {
                activity?.finish()
            } else {
                navController.popBackStack()
            }
        }
    }

    override fun isActivityStateSaved(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isActivityVisible(): Boolean {
        TODO("Not yet implemented")
    }
}