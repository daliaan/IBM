package dalian.razvan.cucer.githubandroidrepos.screens.repoDetails

import android.os.Bundle
import android.view.View
import dalian.razvan.cucer.githubandroidrepos.R
import dalian.razvan.cucer.githubandroidrepos.core.baseClasses.BaseFragment
import kotlinx.android.synthetic.main.fragment_repo_details.*
import org.koin.android.viewmodel.ext.android.viewModel

class RepoDetailsFragment: BaseFragment(), RepoDetailsFragmentView {

    private val repoDetailsViewModel by viewModel<RepoDetailsViewModel>()

    override fun whichLayout(): Int = R.layout.fragment_repo_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        display_name.text = repoDetailsViewModel.getDisplayName()
        owner_name.text = repoDetailsViewModel.getOwnerName()
        description.text = repoDetailsViewModel.getDescription()

        try_api_load.setOnClickListener {
            repoDetailsViewModel.tryAPILoad(this)
        }
    }
}