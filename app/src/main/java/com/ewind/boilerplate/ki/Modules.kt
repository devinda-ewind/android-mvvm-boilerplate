package com.ewind.boilerplate.ki

import com.ewind.boilerplate.data.repository.WorkRepositoryImpl
import com.ewind.boilerplate.domain.repository.WorkRepository
import com.ewind.boilerplate.domain.usecase.WorkUseCase
import com.ewind.boilerplate.ui.main.home.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.loadKoinModules

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        viewModelModule,
        useCaseModule,
        repositoryModule
    )
}

val viewModelModule: Module = module {
    viewModel { MainViewModel(workUseCase = get()) }
}

val useCaseModule: Module = module {
    factory { WorkUseCase(workRepository = get()) }
}

val repositoryModule: Module = module {
    single<WorkRepository> {
        WorkRepositoryImpl(
            worksApi = get()
        )
    }
}