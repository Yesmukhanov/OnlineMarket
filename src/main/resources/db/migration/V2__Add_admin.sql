insert into t_users (id, email, full_name, password, role, status)
values (1,
        'yesmukhanov04@gmail.com',
        'Dauren Yesmukhanov',
        '$2a$10$uk9oVv7Cnp853BiRU4ZIjeVrokiRutadyTTaZVzTevdkI7zVJ7pMK',
        1,
        false);
insert into t_permissions (id, role)
values (1,
        'ROLE_ADMIN');
insert into t_users_permissions(user_id, permissions_id)
values (1, 1);
