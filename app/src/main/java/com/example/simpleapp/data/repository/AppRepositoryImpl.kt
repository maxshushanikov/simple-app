package com.example.simpleapp.data.repository

import com.example.simpleapp.data.mapper.toDomain
import com.example.simpleapp.data.remote.AppApi
import com.example.simpleapp.domain.model.AppDetails
import com.example.simpleapp.domain.model.AppInfo
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val api: AppApi,
) : AppRepository {

    override suspend fun getCatalog(): Result<List<AppInfo>> = runCatchingCancellable {
        api.getCatalog().mapNotNull { it.toDomain() }
    }

    override suspend fun getAppDetails(id: String): Result<AppDetails> = runCatchingCancellable {
        api.getAppDetails(id).toDomain() ?: error("App details have no id")
    }

    private inline fun <T> runCatchingCancellable(block: () -> T): Result<T> =
        try {
            Result.success(block())
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
}
