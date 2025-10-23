INSERT INTO users (email, password, name, role)
    VALUES ('amith@amith.com', 'amith123', 'Amith', 'ROLE_USER'),
           ('deepthi@deepthi.com', 'deepthi123', 'Deepthi B', 'ROLE_USER');


INSERT INTO short_urls (short_key, original_url, created_by, created_at, expires_at, is_private, click_count)
    VALUES ('abcd', 'https://amith.com', 1, CURRENT_TIMESTAMP, NULL, 0, 1);