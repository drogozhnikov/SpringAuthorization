SET search_path TO auth;

insert into users(username, email, password, role, status, created, updated)
values ('user', 'user_email', '$2a$12$D1.ICUpw.7hYZnfml9LL4OHg6SImjzyd8ZIEWl/1tiY3WtQsFWRI6', 'USER', 'ACTIVE',
        current_timestamp, current_timestamp);
