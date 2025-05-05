package com.shubham.igi.data

import com.shubham.igi.data.model.InventoryItem

suspend fun populateData(INSTANCE: AppDatabase?) {
    val dao = INSTANCE?.inventoryDao()

    // Insert demo items
    dao?.insertItem(
        InventoryItem(
            name = "1 mm",
            category = "A class",
            amount = 0,
            defaultChange = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "2 mm",
            category = "A class",
            amount = 0,
            defaultChange = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3 mm",
            category = "A class",
            amount = 0,
            defaultChange = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "4 mm",
            category = "A class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5 mm",
            category = "A class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "6 mm",
            category = "A class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "8 mm",
            category = "A class",
            amount = 0,
            defaultChange = 3
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10 mm",
            category = "A class",
            amount = 0,
            defaultChange = 3
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "12 mm",
            category = "A class",
            amount = 0,
            defaultChange = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "1 mm",
            category = "F class",
            amount = 0,
            defaultChange = 50
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "1.5 mm",
            category = "F class",
            amount = 0,
            defaultChange = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "2 mm",
            category = "F class",
            amount = 0,
            defaultChange = 35
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3 mm",
            category = "F class",
            amount = 0,
            defaultChange = 30
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "4 mm",
            category = "F class",
            amount = 0,
            defaultChange = 25
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5 mm",
            category = "F class",
            amount = 0,
            defaultChange = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "6 mm",
            category = "F class",
            amount = 0,
            defaultChange = 15
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "8 mm",
            category = "F class",
            amount = 0,
            defaultChange = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10 mm",
            category = "F class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "12 mm",
            category = "F class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "16 mm",
            category = "F class",
            amount = 0,
            defaultChange = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "1 mm",
            category = "B class",
            amount = 0,
            defaultChange = 50
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "1.5 mm",
            category = "B class",
            amount = 0,
            defaultChange = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "2 mm",
            category = "B class",
            amount = 0,
            defaultChange = 35
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3 mm",
            category = "B class",
            amount = 0,
            defaultChange = 30
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "4 mm",
            category = "B class",
            amount = 0,
            defaultChange = 25
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5 mm",
            category = "B class",
            amount = 0,
            defaultChange = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "6 mm",
            category = "B class",
            amount = 0,
            defaultChange = 15
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "8 mm",
            category = "B class",
            amount = 0,
            defaultChange = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10 mm",
            category = "B class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "12 mm",
            category = "B class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "16 mm",
            category = "B class",
            amount = 0,
            defaultChange = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "20 mm",
            category = "B class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "25 mm",
            category = "B class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 1 mm",
            category = "H class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 1.5 mm",
            category = "H class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 2 mm",
            category = "H class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 3 mm",
            category = "H class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 4 mm",
            category = "H class",
            amount = 0,
            defaultChange = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 5 mm",
            category = "H class",
            amount = 0,
            defaultChange = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 6 mm",
            category = "H class",
            amount = 0,
            defaultChange = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 8 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 10 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 12 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 16 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 20 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 25 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 1 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 2 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 3 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 4 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 5 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 6 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 8 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 10 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 4 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 4 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 4 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 1 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 1.5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 2 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 3 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 4 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 7mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 6 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 8 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 10 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 12 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 14 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 16 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 18 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 20 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 22 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 25 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 1 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 1.5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 2 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 3 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 4 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 6 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 8 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 10 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 12 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 1 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 1.5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 2 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 3 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 4 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 6 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 8 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 10 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 1 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 1.5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 2 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 3 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 4 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 6 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 8 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 10 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 1 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 1.5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 2 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 3 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 4 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 6 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 8 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 10 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 12 mm",
            category = "China",
            amount = 0,
            defaultChange = 1
        )
    )
}