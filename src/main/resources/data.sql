insert into client_address(address, city, state, zip)
values ('06 Portage Court', 'El Paso', 'Texas', '88546'),
 ('6 Coleman Pass', 'El Paso', 'Texas', '79934'),
 ('92247 Warner Point', 'Newport News', 'Virginia', '23612'),
 ('33 Aberg Crossing', 'Houston', 'Texas', '77065'),
 ('5 Ridge Oak Crossing', 'Berlin', 'Berlin', '12437'),
 ('4058 Westport Way', 'Arlington', 'Virginia', '22212'),
 ('6170 Annamark Alley', 'Newport News', 'Virginia', '23605'),
 ('81 Ridge Oak Lane', 'Berlin', 'Berlin', '10715'),
 ('052 Judy Plaza', 'Berlin', 'Berlin', '14199'),
 ('6 Ronald Regan Circle', 'Odessa', 'Texas', '79764'),
 ('1239 Grasskamp Hill', 'Austin', 'Texas', '78726'),
 ('62022 Fulton Road', 'Humble', 'Texas', '77346'),
('6 Buhler Court', 'Houston', 'Texas', '77035'),
 ('092 Anthes Junction', 'Houston', 'Texas', '77299'),
 ('03749 Elka Center', 'Amarillo', 'Texas', '79105'),
 ('33 Havey Terrace', 'Bryan', 'Texas', '77806'),
 ('8101 Fordem Court', 'Beaumont', 'Texas', '77713'),
 ('933 Prairieview Lane', 'Dallas', 'Texas', '75277'),
 ('2105 Ronald Regan Lane', 'Fairbanks', 'Alaska', '99709'),
 ('33979 Upham Road', 'Berlin', 'Berlin', '10409');

insert into client(first_name, last_name, id_number, birth_date, premium, email, password, role, address_id)
values ('Jan', 'Kowalski', 'ASD993', '1990-10-12', true, 'kowalski@o2.pl',
        '{bcrypt}$2a$10$k.32QKXo8tKKa2BzRWLRoOG4SJlXuNoUgPnsOymCDoXUx0ALGGgC2', 'ADMIN', 1),
       ('Maciej', 'Zalewski', 'ZZZ9090', '1987-11-22', false, 'zalewski@o2.pl',
        '{MD5}{gcbs7DFiRO4asVnRDWJ3dzxFRV3hjREwZERh6wFipXI=}3d3d786860e7740c4dd001e81c824fae', 'USER', 2),
       ('Aneta', 'Korczyńska', 'LOL9393', '1976-06-15', true, 'korczynska@o2.pl',
        '{MD5}{gcbs7DFiRO4asVnRDWJ3dzxFRV3hjREwZERh6wFipXI=}3d3d786860e7740c4dd001e81c824fae', 'USER', 3),
       ('Wojciech', 'Sokolik', 'SUPE99', '1982-01-08', false, 'sokolik@o2.pl',
        '{MD5}{gcbs7DFiRO4asVnRDWJ3dzxFRV3hjREwZERh6wFipXI=}3d3d786860e7740c4dd001e81c824fae', 'USER', 4);

insert into car(name, registration_number, fuel_type, car_type, price_per_day)
values ('Audi A6', 'EBEYY10', 'DIESEL', 'KOMBI', 150),
       ('BMW X5', 'WW101010', 'PETROL', 'SUV', 350),
       ('Mazda 6', 'EP10921', 'PETROL', 'KOMBI', 200),
       ('Porsche', 'WW10000', 'PETROL', 'PREMIUM', 500),
       ('Audi Q7', 'KR12311', 'PETROL', 'SUV', 380),
       ('Citroen C1', 'EOP12031', 'LPG', 'SMALL', 100);

insert into rental(rental_date, return_date, client_id, car_id)
values ('2022-07-04', '2022-07-05', 1, 1),
       ('2022-02-04', '2022-03-05', 1, 1),
       ('2022-07-04', null, 2, 3),
       ('2022-07-04', null, 3, 4),
       ('2022-05-05', '2022-06-01', 1, 2);