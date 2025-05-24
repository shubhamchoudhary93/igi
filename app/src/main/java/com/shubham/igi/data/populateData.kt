package com.shubham.igi.data

import com.shubham.igi.inventory.data.model.InventoryItem

suspend fun populateData(INSTANCE: AppDatabase?) {
    val dao = INSTANCE?.inventoryDao()
    INSTANCE?.filmInventoryDao()

    // Insert demo items
    dao?.insertItem(
        InventoryItem(
            name = "1 mm",
            category = "A class",
            amount = 0,
            defaultChange = 10,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "2 mm",
            category = "A class",
            amount = 0,
            defaultChange = 10,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3 mm",
            category = "A class",
            amount = 0,
            defaultChange = 10,
            minQ = 30
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "4 mm",
            category = "A class",
            amount = 0,
            defaultChange = 5,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5 mm",
            category = "A class",
            amount = 0,
            defaultChange = 5,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "6 mm",
            category = "A class",
            amount = 0,
            defaultChange = 5,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "8 mm",
            category = "A class",
            amount = 0,
            defaultChange = 3,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10 mm",
            category = "A class",
            amount = 0,
            defaultChange = 3,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "12 mm",
            category = "A class",
            amount = 0,
            defaultChange = 2,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "1 mm",
            category = "F class",
            amount = 0,
            defaultChange = 50,
            minQ = 50
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "1.5 mm",
            category = "F class",
            amount = 0,
            defaultChange = 10,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "2 mm",
            category = "F class",
            amount = 0,
            defaultChange = 35,
            minQ = 35
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3 mm",
            category = "F class",
            amount = 0,
            defaultChange = 30,
            minQ = 30
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "4 mm",
            category = "F class",
            amount = 0,
            defaultChange = 25,
            minQ = 25
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5 mm",
            category = "F class",
            amount = 0,
            defaultChange = 20,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "6 mm",
            category = "F class",
            amount = 0,
            defaultChange = 15,
            minQ = 15
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "8 mm",
            category = "F class",
            amount = 0,
            defaultChange = 20,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10 mm",
            category = "F class",
            amount = 0,
            defaultChange = 5,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "12 mm",
            category = "F class",
            amount = 0,
            defaultChange = 5,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "16 mm",
            category = "F class",
            amount = 0,
            defaultChange = 2,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "1 mm",
            category = "B class",
            amount = 0,
            defaultChange = 50,
            minQ = 50
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "1.5 mm",
            category = "B class",
            amount = 0,
            defaultChange = 10,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "2 mm",
            category = "B class",
            amount = 0,
            defaultChange = 35,
            minQ = 35
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3 mm",
            category = "B class",
            amount = 0,
            defaultChange = 30,
            minQ = 30
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "4 mm",
            category = "B class",
            amount = 0,
            defaultChange = 25,
            minQ = 25
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5 mm",
            category = "B class",
            amount = 0,
            defaultChange = 20,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "6 mm",
            category = "B class",
            amount = 0,
            defaultChange = 15,
            minQ = 15
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "8 mm",
            category = "B class",
            amount = 0,
            defaultChange = 20,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10 mm",
            category = "B class",
            amount = 0,
            defaultChange = 5,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "12 mm",
            category = "B class",
            amount = 0,
            defaultChange = 5,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "16 mm",
            category = "B class",
            amount = 0,
            defaultChange = 2,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "20 mm",
            category = "B class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "25 mm",
            category = "B class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 1 mm",
            category = "H class",
            amount = 0,
            defaultChange = 5,
            minQ = 40
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 1.5 mm",
            category = "H class",
            amount = 0,
            defaultChange = 5,
            minQ = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 2 mm",
            category = "H class",
            amount = 0,
            defaultChange = 5,
            minQ = 35
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 3 mm",
            category = "H class",
            amount = 0,
            defaultChange = 5,
            minQ = 30
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 4 mm",
            category = "H class",
            amount = 0,
            defaultChange = 5,
            minQ = 30
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 5 mm",
            category = "H class",
            amount = 0,
            defaultChange = 2,
            minQ = 21
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 6 mm",
            category = "H class",
            amount = 0,
            defaultChange = 2,
            minQ = 15
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 8 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 10 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 12 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 16 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 20 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 25 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 1 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 2 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 3 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 4 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 5 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 6 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 8 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 10 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 4 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 4 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 4 mm",
            category = "H class",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 1 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 1.5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 2 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 3 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 4 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 21
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 7mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 6 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 8 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 10 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 12 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 16
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 14 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 16 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 18 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 20 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 22 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "White 25 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 1 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 1.5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 2 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 3 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 4 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 6 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 8 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 10 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Black 12 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 1 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 1.5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 2 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 3 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 4 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 6 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 8 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Blue 10 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 1 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 1.5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 2 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 3 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 4 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 6 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 8 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Yellow 10 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 1 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 1.5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 2 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 3 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 4 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 5 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 6 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 8 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 10 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red 12 mm",
            category = "China",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10x0.5x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10x0.5x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10x0.75x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10x0.75x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10x1.5x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10x1.5x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10x1x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10x1x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10x2x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "10x2x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3x0.5x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3x0.5x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3x0.75x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3x0.75x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3x1.5x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3x1.5x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3x1x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 5,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3x1x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3x2x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "3x2x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5x0.5x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5x0.5x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5x0.75x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5x0.75x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5x1.5x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5x1.5x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5x1x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5x1x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5x2x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "5x2x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "777 15",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 60,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "777 25",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 50
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "777 40",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 50
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "7x0.5x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "7x0.5x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "7x0.75x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "7x0.75x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "7x1.5x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "7x1.5x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "7x1x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "7x1x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "7x2x40",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "7x2x50",
            category = "Glass Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 200 P",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 3
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 B 1",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 B 20",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 B 200",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 B 5",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 B 500",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 G 1",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 G 20",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 G 200",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 G 5",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 G 500",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 GW 1",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 3
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 GW 20",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 GW 200",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 GW 5",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 GW 500",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 3
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 W 1",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 W 20",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 W 200",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 W 5",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "A1 W 500",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Bachhi",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 5,
            minQ = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "beck 21",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Beck 225",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Beck 900",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "C Nomex 10",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "C Nomex 5",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "C Nomex 7",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "CDR 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "CDR 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "CDR DS 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "CDR DS 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "DF Sheet 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "DF Sheet 5",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "DF Sheet 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Ducati 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Ducati 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Empire 1",
            category = "Misc",
            amount = 0,
            defaultChange = 10,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Empire 3/4",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Epoxy",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Esol 1",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Esol 500",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Esol sp 500",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Esol sp1",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "FDR 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "FDR 5",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "FDR 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "FDR DS 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "FDR DS 5",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "FDR DS 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Film 10",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Film 12",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Film 15",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Film 2",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Film 3",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Film 4",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Film 5",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Film 7",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "G Cloth 10",
            category = "Glass Cloth",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "G Cloth 5",
            category = "Glass Cloth",
            amount = 0,
            defaultChange = 1,
            minQ = 3
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "G Cloth 7",
            category = "Glass Cloth",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Garware 10",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Garware 5",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Garware 7",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "GP100 B 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "GP100 B 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "GP100 G 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "GP100 G 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "HT Tape",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "INK 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "INK 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Jindal 10",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Jindal 5",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Jindal 7",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "JS 10",
            category = "Glass Cloth",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "JS 7",
            category = "Glass Cloth",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "JS Tape 12",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "JS Tape 24",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Jyoti 1",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Jyoti 20",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Jyoti 200",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Jyoti 5",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Jyoti 500",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Karamal 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Karamal 5",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Karamal 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Kumar 25",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Kumar 40",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 0.5",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 0.5 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 0.75",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 0.75 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 1",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 1 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 1.5",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 1.5 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 10",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 10 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 120",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 120 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 150",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 150 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 16",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 16 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 2.5",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 2.5 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 240",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 240 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 25",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 25 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 300",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 300 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 35",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 35 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 4",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 4 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 50",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 50 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 6",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 6 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 70",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 70 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 95",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "L Wire 95 sp",
            category = "Wire",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Lotus 15",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Lotus 25",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Lotus 40",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Lotus Box",
            category = "Misc",
            amount = 0,
            defaultChange = 2,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Lotus D",
            category = "Misc",
            amount = 0,
            defaultChange = 10,
            minQ = 30
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Lotus S",
            category = "Misc",
            amount = 0,
            defaultChange = 10,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Lotus Sp",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 5
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Mac 1",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Mac 20",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Mac 200",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Mac 5",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Mac 500",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "APA Nomex 10",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "APA Nomex 5",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "APA Nomex 7",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "O Nomex 10",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "O Nomex 5",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "O Nomex 7",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "O Sheet 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "O Sheet 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "P Nomex 10",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "P Nomex 5",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "P Nomex 7",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Pio 1",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Pio 20",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Pio 200",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Pio 5",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Pio 500",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Poly 301",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Poly 303",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Poly Lotus",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Poly Roja",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Ram 1 25",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Ram 3/4 25",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Ray 1",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Ray 20",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Ray 200",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Ray 5",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Ray 500",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Red",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Reel 10",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Reel 12",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Reel 4",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Reel 5",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Reel 6",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Reel 7",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Reel 8",
            category = "Misc",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Roja 1 25",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 30
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Roja 1/2 25",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Roja 3/4 25",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 1,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Rubber D",
            category = "Misc",
            amount = 0,
            defaultChange = 5,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Rubber S",
            category = "Misc",
            amount = 0,
            defaultChange = 5,
            minQ = 20
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "SSP 1/2",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "SSP 3/4",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "SSP Big",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "SSP Pink",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "SSP Small",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Star 10",
            category = "Glass Cloth",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Star 5",
            category = "Glass Cloth",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Star 7",
            category = "Glass Cloth",
            amount = 0,
            defaultChange = 1,
            minQ = 10
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Super 1",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 3
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Super 20",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Super 200",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Super 5",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Super 500",
            category = "Varnish",
            amount = 0,
            defaultChange = 1,
            minQ = 3
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "TF 2",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "TF 3",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "TF 4",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "TF 5",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "TF 7",
            category = "Film",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Trinity W",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Trinity P",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "UD 10",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "UD 7",
            category = "Sheet",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "USP 1/2",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "USP 3/4",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "USP Big",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 3
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "USP Pink",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "USP Small",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "VS 15",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 60,
            minQ = 60
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "VS 25",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 30
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "VS 40",
            category = "Cotton Tape",
            amount = 0,
            defaultChange = 10,
            minQ = 30
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Wonder",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 2
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Wonder 1/2",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Wonder 3/4",
            category = "Adh Cotton",
            amount = 0,
            defaultChange = 1,
            minQ = 1
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "F Nomex 10",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "F Nomex 5",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "F Nomex 7",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Plain Nomex 10",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Plain Nomex 5",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )
    dao?.insertItem(
        InventoryItem(
            name = "Plain Nomex 7",
            category = "Nomex",
            amount = 0,
            defaultChange = 1,
            minQ = 0
        )
    )

}