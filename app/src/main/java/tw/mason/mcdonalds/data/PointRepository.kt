package tw.mason.mcdonalds.data

import tw.mason.mcdonalds.screen.point.PointExchangeItem

interface PointRepository {
    suspend fun getList(): List<PointExchangeItem>
}