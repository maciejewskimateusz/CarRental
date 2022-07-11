insert into client(first_name, last_name, pesel, id_number, birth_date, premium, email, password)
values ('Jan', 'Kowalski', '90101222457', 'ASD993', '1990-10-12', true, 'kowalski@o2.pl',
        '{bcrypt}$2a$10$k.32QKXo8tKKa2BzRWLRoOG4SJlXuNoUgPnsOymCDoXUx0ALGGgC2'),
       ('Maciej', 'Zalewski', '87112242456', 'ZZZ9090', '1987-11-22', false, 'zalewski@o2.pl',
        '{MD5}{gcbs7DFiRO4asVnRDWJ3dzxFRV3hjREwZERh6wFipXI=}3d3d786860e7740c4dd001e81c824fae'),
       ('Aneta', 'Korczyńska', '76061536749', 'LOL9393', '1976-06-15', true, 'korczynska@o2.pl',
        '{MD5}{gcbs7DFiRO4asVnRDWJ3dzxFRV3hjREwZERh6wFipXI=}3d3d786860e7740c4dd001e81c824fae'),
       ('Wojciech', 'Sokolik', '82010877245', 'SUPE99', '1982-01-08', false, 'sokolik@o2.pl',
        '{MD5}{gcbs7DFiRO4asVnRDWJ3dzxFRV3hjREwZERh6wFipXI=}3d3d786860e7740c4dd001e81c824fae');

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
       ('2022-07-04', null, 3, 4),
       ('2022-05-05', '2022-06-01', 1, 2);

insert into client_role(name, description)
values ('ADMIN', 'Ma dostęp do wszystkiego'),
       ('USER', 'Dostęp tylko do odczytu');

insert into client_roles(client_id, role_id)
values (1, 1),
       (2, 2),
       (3, 2);