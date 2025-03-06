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