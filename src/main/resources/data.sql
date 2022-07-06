insert into client(first_name, last_name, pesel, id_number, birth_date)
values ('Jan', 'Kowalski', '90101222457', 'ASD993', '1990-10-12'),
       ('Maciej', 'Zalewski', '87112242456', 'ZZZ9090', '1987-11-22'),
       ('Aneta', 'Korczyńska', '76061536749', 'LOL9393', '1976-06-15'),
       ('Wojciech', 'Sokolik', '82010877245', 'SUPE99', '1982-01-08');

insert into car(name, registration_number, fuel_type, car_type, mileage, price_per_day)
values ('Audi A6', 'EBEYY10', 'DIESEL', 'KOMBI', 200000, 150),
       ('BMW X5', 'WW101010', 'PETROL', 'SUV', 90122, 350),
       ('Mazda 6', 'EP10921', 'PETROL', 'KOMBI', 1231412, 200),
       ('Porsche', 'WW10000', 'PETROL', 'PREMIUM', 10000, 500),
       ('Audi Q7', 'KR12311', 'PETROL', 'SUV', 170000, 380),
       ('Citroen C1', 'EOP12031', 'LPG', 'SMALL', 901231, 100);

insert into rental(rental_date, return_date, client_id, car_id)
values ('2022-07-04', '2022-07-05', 1, 1),
       ('2022-02-04', '2022-03-05', 1, 1),
       ('2022-07-04', null, 2, 3),
       ('2022-07-04', null , 3, 4),
       ('2022-05-05', '2022-06-01', 1, 2);