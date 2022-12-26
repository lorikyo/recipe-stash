package com.lorikyo.recipestash.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

class MealPagingSource(private val mealDao: MealDao) : PagingSource<Int, Meal>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Meal> {
        val page = params.key ?: 0
        return try {
            val entities = mealDao.getMeals(params.loadSize, page * params.loadSize)

            LoadResult.Page(
                data = entities,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (entities.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Meal>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}