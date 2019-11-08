package com.ewind.boilerplate.domain.usecase

import com.ewind.boilerplate.domain.repository.WorkRepository

class WorkUseCase(val workRepository: WorkRepository) {
    fun getWorks(dates: String) = workRepository.getWorks(dates)
}