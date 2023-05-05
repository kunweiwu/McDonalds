package tw.mason.mcdonalds.data

import kotlinx.coroutines.delay
import tw.mason.mcdonalds.screen.point.PointExchangeItem

class PointRepositoryImpl: PointRepository {

    override suspend fun getList(): List<PointExchangeItem> {
        delay(2000L)
        return listOf(
            PointExchangeItem(
                "中杯可口可樂",
                40,
                "https://s7d1.scene7.com/is/image/mcdonalds/coke-zero_860x822_2:nutrition-calculator-tile-desktop?resmode=sharp2"
            ),
            PointExchangeItem(
                "中杯檸檬風味紅茶",
                40,
                "https://s7d1.scene7.com/is/image/mcdonalds/iced-black-tea-lemon-flavor_832x822:nutrition-calculator-tile-desktop?resmode=sharp2"
            ),
            PointExchangeItem(
                "原味麥脆炸雞(2塊)",
                120,
                "https://s7d1.scene7.com/is/image/mcdonalds/chicken-mccrispy-2-pieces_832x822:1-4-product-tile-desktop"
            ),
            PointExchangeItem(
                "辣味麥脆炸雞(2塊)",
                120,
                "https://s7d1.scene7.com/is/image/mcdonalds/spicy-chicken-mccrispy-2-pieces_0321-3:1-4-product-tile-desktop"
            ),
            PointExchangeItem(
                "麥克雞塊(10塊)",
                100,
                "https://s7d1.scene7.com/is/image/mcdonalds/chicken-mcnuggets-10-pieces_832x822:1-4-product-tile-desktop"
            ),
            PointExchangeItem(
                "薯餅",
                30,
                "https://s7d1.scene7.com/is/image/mcdonalds/hash-browns_832x822:1-4-product-tile-desktop"
            ),
        )
    }
}