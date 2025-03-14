merge (c1: City {name: 'Москва'});
merge (c2: City {name: 'Пермь'});
merge (c3: City {name: 'Екатеринбург'});
merge (c4: City {name: 'Тюмень'});
merge (c5: City {name: 'Саратов'});
merge (c6: City {name: 'Нижневартовск'});
merge (c7: City {name: 'Архангельск'});
merge (c8: City {name: 'Санкт-Петербург'});

match (c1), (c2) where c1.name = "Москва" and c2.name = "Пермь"
merge (c2)-[:HAVE_ROUTE_TO{id: 0, transportMode:"PLANE",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1);

match (c1), (c2) where c1.name = "Москва" and c2.name = "Пермь"
merge (c2)-[:HAVE_ROUTE_TO{id: 1, transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1);

match (c1), (c2) where c1.name = "Москва" and c2.name = "Пермь"
merge (c2)-[:HAVE_ROUTE_TO{id: 2, transportMode:"BUS",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1);

match (c1), (c2) where c1.name = "Пермь" and c2.name = "Москва"
merge (c2)-[:HAVE_ROUTE_TO{id: 3, transportMode:"PLANE",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1);

match (c1), (c2) where c1.name = "Пермь" and c2.name = "Москва"
merge (c2)-[:HAVE_ROUTE_TO{id: 4, transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1);

match (c1), (c2) where c1.name = "Пермь" and c2.name = "Москва"
merge (c2)-[:HAVE_ROUTE_TO{id: 5, transportMode:"BUS",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1);

match (c1), (c2) where c1.name = "Пермь" and c2.name = "Екатеринбург"
merge (c2)-[:HAVE_ROUTE_TO{id: 6, transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1);

match (c1), (c2) where c1.name = "Екатеринбург" and c2.name = "Пермь"
merge (c2)-[:HAVE_ROUTE_TO{id: 7, transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1);

match (c1), (c2) where c1.name = "Тюмень" and c2.name = "Екатеринбург"
merge (c2)-[:HAVE_ROUTE_TO{id: 8, transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1);

match (c1), (c2) where c1.name = "Екатеринбург" and c2.name = "Тюмень"
merge (c2)-[:HAVE_ROUTE_TO{id: 9, transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 2)))}]->(c1);

match (c1), (c2) where c1.name = "Екатеринбург" and c2.name = "Архангельск"
merge (c2)-[:HAVE_ROUTE_TO{id: 10, transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 3))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 4)))}]->(c1);

match (c1), (c2) where c1.name = "Архангельск" and c2.name = "Екатеринбург"
merge (c2)-[:HAVE_ROUTE_TO{id: 11, transportMode:"RAILWAY",departure:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 6))),arrival:localdatetime(datetime.fromepochmillis(timestamp() + (1000 * 86400 * 7)))}]->(c1);