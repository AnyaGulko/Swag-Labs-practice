package ru.ingver.autotest.pages.components;

import java.util.List;

public enum SortingType {
    NAME_ASC {
        @Override
        public List<Card> getCards() {
            return List.of(
                    new Card(
                            "Sauce Labs Backpack",
                            "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                            "$29.99",
                            "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg"
                    ),
                    new Card(
                            "Sauce Labs Bike Light",
                            "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                            "$9.99",
                            "/static/media/bike-light-1200x1500.37c843b0.jpg"
                    ),
                    new Card(
                            "Sauce Labs Bolt T-Shirt",
                            "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                            "$15.99",
                            "/static/media/bolt-shirt-1200x1500.c2599ac5.jpg"
                    ),
                    new Card(
                            "Sauce Labs Fleece Jacket",
                            "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                            "$49.99",
                            "/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg"
                    ),
                    new Card(
                            "Sauce Labs Onesie",
                            "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                            "$7.99",
                            "/static/media/red-onesie-1200x1500.2ec615b2.jpg"
                    ),
                    new Card(
                            "Test.allTheThings() T-Shirt (Red)",
                            "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
                            "$15.99",
                            "/static/media/red-tatt-1200x1500.30dadef4.jpg"
                    )
            );
        }
    },
    NAME_DESC {
        @Override
        public List<Card> getCards() {
            return List.of(
                    new Card(
                            "Test.allTheThings() T-Shirt (Red)",
                            "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
                            "$15.99",
                            "/static/media/red-tatt-1200x1500.30dadef4.jpg"
                    ),
                    new Card(
                            "Sauce Labs Onesie",
                            "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                            "$7.99",
                            "/static/media/red-onesie-1200x1500.2ec615b2.jpg"
                    ),
                    new Card(
                            "Sauce Labs Fleece Jacket",
                            "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                            "$49.99",
                            "/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg"
                    ),
                    new Card(
                            "Sauce Labs Bolt T-Shirt",
                            "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                            "$15.99",
                            "/static/media/bolt-shirt-1200x1500.c2599ac5.jpg"
                    ),
                    new Card(
                            "Sauce Labs Bike Light",
                            "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                            "$9.99",
                            "/static/media/bike-light-1200x1500.37c843b0.jpg"
                    ),
                    new Card(
                            "Sauce Labs Backpack",
                            "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                            "$29.99",
                            "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg"
                    )
            );
        }
    },
    PRICE_ASC {
        @Override
        public List<Card> getCards() {
            return List.of(
                    new Card(
                            "Sauce Labs Onesie",
                            "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                            "$7.99",
                            "/static/media/red-onesie-1200x1500.2ec615b2.jpg"
                    ),
                    new Card(
                            "Sauce Labs Bike Light",
                            "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                            "$9.99",
                            "/static/media/bike-light-1200x1500.37c843b0.jpg"
                    ),
                    new Card(
                            "Sauce Labs Bolt T-Shirt",
                            "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                            "$15.99",
                            "/static/media/bolt-shirt-1200x1500.c2599ac5.jpg"
                    ),
                    new Card(
                            "Test.allTheThings() T-Shirt (Red)",
                            "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
                            "$15.99",
                            "/static/media/red-tatt-1200x1500.30dadef4.jpg"
                    ),

                    new Card(
                            "Sauce Labs Backpack",
                            "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                            "$29.99",
                            "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg"
                    ),
                    new Card(
                            "Sauce Labs Fleece Jacket",
                            "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                            "$49.99",
                            "/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg"
                    )
            );
        }
    },
    PRICE_DESC {
        @Override
        public List<Card> getCards() {
            return List.of(
                    new Card(
                            "Sauce Labs Fleece Jacket",
                            "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                            "$49.99",
                            "/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg"
                    ),
                    new Card(
                            "Sauce Labs Backpack",
                            "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                            "$29.99",
                            "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg"
                    ),
                    new Card(
                            "Sauce Labs Bolt T-Shirt",
                            "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                            "$15.99",
                            "/static/media/bolt-shirt-1200x1500.c2599ac5.jpg"
                    ),
                    new Card(
                            "Test.allTheThings() T-Shirt (Red)",
                            "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
                            "$15.99",
                            "/static/media/red-tatt-1200x1500.30dadef4.jpg"
                    ),
                    new Card(
                            "Sauce Labs Bike Light",
                            "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                            "$9.99",
                            "/static/media/bike-light-1200x1500.37c843b0.jpg"
                    ),
                    new Card(
                            "Sauce Labs Onesie",
                            "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                            "$7.99",
                            "/static/media/red-onesie-1200x1500.2ec615b2.jpg"
                    )
            );
        }
    };

    public abstract List<Card> getCards();
}
