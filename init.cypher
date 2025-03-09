create (c1: City {name: 'Москва'})
create (c2: City {name: 'Пермь'})
create (c3: City {name: 'Екатеринбург'})
create (c4: City {name: 'Тюмень'})
create (c5: City {name: 'Саратов'})
create (c6: City {name: 'Нижневартовск'})
create (c7: City {name: 'Архангельск'})
create (c8: City {name: 'Санкт-Петербург'})

match (c1), (c2) where c1.name = "Москва" and c2.name = "Пермь"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"PLANE",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1)

match (c1), (c2) where c1.name = "Москва" and c2.name = "Пермь"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1)

match (c1), (c2) where c1.name = "Москва" and c2.name = "Пермь"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"BUS",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1)

match (c1), (c2) where c1.name = "Пермь" and c2.name = "Москва"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"PLANE",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1)

match (c1), (c2) where c1.name = "Пермь" and c2.name = "Москва"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1)

match (c1), (c2) where c1.name = "Пермь" and c2.name = "Москва"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"BUS",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1)

match (c1), (c2) where c1.name = "Пермь" and c2.name = "Екатеринбург"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1)

match (c1), (c2) where c1.name = "Екатеринбург" and c2.name = "Пермь"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1)

match (c1), (c2) where c1.name = "Тюмень" and c2.name = "Екатеринбург"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1)

match (c1), (c2) where c1.name = "Екатеринбург" and c2.name = "Тюмень"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1)

match (c1), (c2) where c1.name = "Екатеринбург" and c2.name = "Архангельск"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 3))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 4)))}]->(c1)

match (c1), (c2) where c1.name = "Архангельск" and c2.name = "Екатеринбург"
create (c2)-[:HAVE_ROUTE_TO{transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 6))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 7)))}]->(c1)