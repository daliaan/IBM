package dalian.razvan.cucer.githubandroidrepos.screens.reposList

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import dalian.razvan.cucer.githubandroidrepos.R
import dalian.razvan.cucer.githubandroidrepos.core.baseClasses.BaseFragment
import dalian.razvan.cucer.githubandroidrepos.customViews.ReposAdapter
import dalian.razvan.cucer.githubandroidrepos.models.Repo
import kotlinx.android.synthetic.main.fragment_repos_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class ReposListFragment: BaseFragment(), ReposListFragmentView {

    private lateinit var adapter: ReposAdapter
    private val reposViewModel by viewModel<ReposListViewModel>()

    override fun whichLayout(): Int = R.layout.fragment_repos_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repos_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        repos_list.setHasFixedSize(true)
        adapter = ReposAdapter()
        adapter.addItemClickListener(reposViewModel.getReposItemClick(this))
        repos_list.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        reposViewModel.load(this)
    }

    override fun goToDetails() {
        view?.let {
            Navigation.findNavController(it).navigate(R.id.goToDetails)
        }
    }

    override fun setList(list: ArrayList<Repo>) {
        adapter.setList(list)
    }
}